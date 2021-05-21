package mrthomas20121.tfcompat.compat.bloodmagic;

import WayofTime.bloodmagic.altar.AltarTier;
import WayofTime.bloodmagic.api.impl.BloodMagicAPI;
import WayofTime.bloodmagic.core.RegistrarBloodMagic;
import WayofTime.bloodmagic.orb.BloodOrb;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.client.ClientEvents;
import mrthomas20121.tfcompat.compat.bloodmagic.items.ItemDaggerOfSacrifice;
import mrthomas20121.tfcompat.compat.bloodmagic.recipes.AlchemyTableRecipeTFC;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.items.food.ItemFoodTFC;
import net.dries007.tfc.objects.items.metal.ItemMetalTool;
import net.dries007.tfc.util.agriculture.Food;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;

public class BloodMagicRegistry extends RecipeRegistry {

    public BloodMagicRegistry() {
        super("bloodmagic_registry");
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        BloodMagicAPI.INSTANCE.getRecipeRegistrar().removeBloodAltar(new ItemStack(Items.IRON_SWORD));
        BloodMagicAPI.INSTANCE.getRecipeRegistrar().removeBloodAltar(new ItemStack(Blocks.GOLD_BLOCK));
        for(Metal metal : TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable() && metal.isToolMetal()) {
                BloodMagicAPI.INSTANCE.getRecipeRegistrar().addBloodAltar(Ingredient.fromItem(ItemMetalTool.get(metal, Metal.ItemType.SWORD)), new ItemStack(ItemDaggerOfSacrifice.get(metal)), AltarTier.TWO.ordinal(), 3000, 5, 5);
            }
        }

        BloodMagicAPI.INSTANCE.getRecipeRegistrar().addBloodAltar(new OreIngredient("doubleIngotRoseGold"), getOrbStack(RegistrarBloodMagic.ORB_MAGICIAN), AltarTier.THREE.ordinal(), 25000, 20, 20);
    }

    @Override
    public void registerItems(IForgeRegistry<Item> r) {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable() && metal.isToolMetal()) {
                ItemDaggerOfSacrifice itemDaggerOfSacrifice = new ItemDaggerOfSacrifice(metal);
                r.register(itemDaggerOfSacrifice);
                ClientEvents.colorItems.add(itemDaggerOfSacrifice);
            }
        }
    }

    @Override
    public void registerModels(ModelRegistryEvent event) {
        for(Metal metal: TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable() && metal.isToolMetal()) {
                ItemDaggerOfSacrifice itemDaggerOfSacrifice = ItemDaggerOfSacrifice.get(metal);
                ModelLoader.setCustomModelResourceLocation(itemDaggerOfSacrifice, 0, new ModelResourceLocation(new ResourceLocation(TFCompat.MODID, "dagger_of_sacrifice"), "inventory"));
            }
        }
    }

    public static ItemStack getOrbStack(BloodOrb orb) {
        Item orb_item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("bloodmagic:blood_orb"));
        ItemStack ret = new ItemStack(orb_item);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("orb", orb.getRegistryName().toString());
        ret.setTagCompound(tag);
        return ret;
    }
}
