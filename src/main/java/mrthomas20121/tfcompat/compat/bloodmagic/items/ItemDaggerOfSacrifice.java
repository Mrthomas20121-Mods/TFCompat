package mrthomas20121.tfcompat.compat.bloodmagic.items;

import WayofTime.bloodmagic.api.impl.BloodMagicAPI;
import WayofTime.bloodmagic.util.DamageSourceBloodMagic;
import WayofTime.bloodmagic.util.helper.PlayerSacrificeHelper;
import WayofTime.bloodmagic.util.helper.PurificationHelper;
import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.capability.forge.ForgeableHeatableHandler;
import net.dries007.tfc.api.capability.metal.IMetalItem;
import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.CreativeTabsTFC;
import net.dries007.tfc.objects.items.ItemTFC;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;

public class ItemDaggerOfSacrifice extends ItemTFC implements IMetalItem {

    private static HashMap<Metal, ItemDaggerOfSacrifice> table = new HashMap<>();

    private final Metal metal;

    @Nullable
    public static ItemDaggerOfSacrifice get(Metal metal) {
        if(table.containsKey(metal))
            return table.get(metal);
        return null;
    }

    public ItemDaggerOfSacrifice(Metal metal) {
        this.metal = metal;

        this.setRegistryName(TFCompat.MODID, metal.getRegistryName().getPath()+"/dagger_of_sacrifice");
        this.setTranslationKey(TFCompat.MODID+"_"+this.getRegistryName().getPath().replace("/", "_"));

        this.setCreativeTab(CreativeTabsTFC.CT_METAL);

        if(!table.containsKey(metal))
            table.put(metal, this);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (attacker instanceof FakePlayer)
            return false;

        if (target == null || attacker == null || attacker.getEntityWorld().isRemote || (attacker instanceof EntityPlayer && !(attacker instanceof EntityPlayerMP)))
            return false;

        if (!target.isNonBoss())
            return false;

        if (target instanceof EntityPlayer)
            return false;

        if (target.isChild() && !(target instanceof IMob))
            return false;

        if (target.isDead || target.getHealth() < 0.5F)
            return false;

        EntityEntry entityEntry = EntityRegistry.getEntry(target.getClass());
        if (entityEntry == null)
            return false;
        int lifeEssenceRatio = BloodMagicAPI.INSTANCE.getValueManager().getSacrificial().getOrDefault(entityEntry.getRegistryName(), 25);

        if (lifeEssenceRatio <= 0)
            return false;

        int lifeEssence = (int) (lifeEssenceRatio * target.getHealth());
        if (target instanceof EntityAnimal) {
            lifeEssence = (int) (lifeEssence * (1 + PurificationHelper.getCurrentPurity((EntityAnimal) target)))*metal.getTier().ordinal();
        }

        if (target.isChild()) {
            lifeEssence *= 0.5F;
        }

        if (PlayerSacrificeHelper.findAndFillAltar(attacker.getEntityWorld(), target, lifeEssence, true)) {
            target.getEntityWorld().playSound(null, target.posX, target.posY, target.posZ, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (target.getEntityWorld().rand.nextFloat() - target.getEntityWorld().rand.nextFloat()) * 0.8F);
            target.setHealth(-1);
            target.onDeath(DamageSourceBloodMagic.INSTANCE);
        }

        return false;
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(@Nonnull ItemStack stack)
    {
        String name = (new TextComponentTranslation("tfc.types.metal."+metal.getRegistryName().getPath().toLowerCase())).getFormattedText();
        return (new TextComponentTranslation("item.tfcompat.dagger_of_sacrifice.name", name)).getFormattedText();
    }

    @Nonnull
    @Override
    public Size getSize(@Nonnull ItemStack itemStack) {
        return Size.SMALL;
    }

    @Nonnull
    @Override
    public Weight getWeight(@Nonnull ItemStack itemStack) {
        return Weight.MEDIUM;
    }

    @Override
    public int getStackSize(@Nonnull ItemStack stack) {
        return 1;
    }

    @Nullable
    @Override
    public Metal getMetal(ItemStack itemStack) {
        return metal;
    }

    @Override
    public int getSmeltAmount(ItemStack itemStack) {
        return 100;
    }

    @Override
    public float getMeltTemp(ItemStack stack) {
        return metal.getMeltTemp();
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(@Nonnull ItemStack stack, @Nullable NBTTagCompound nbt)
    {
        return new ForgeableHeatableHandler(nbt, metal.getSpecificHeat(), this.getMeltTemp(stack));
    }
}
