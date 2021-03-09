package mrthomas20121.tfcompat.compat.improvedbackpacks;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;
import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.OreDictionaryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import ru.poopycoders.improvedbackpacks.init.ModItems;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class BackpacksRegistry extends RecipeRegistry {

    public BackpacksRegistry()
    {
        super("backpack_registry");
    }

    public void init(FMLInitializationEvent event) {
        HeatHelper.addItemHeat(new ItemStack(ModItems.BOUND_LEATHER), 600, 580);
        HeatHelper.addItemHeat(new ItemStack(ModItems.TANNED_LEATHER), 600, 580);
        OreDictionary.registerOre("tannedLeather", ModItems.TANNED_LEATHER);
    }

    @Override
    public void removeRecipes(IForgeRegistryModifiable<IRecipe> r) {
        r.remove(new ResourceLocation("improvedbackpacks:item.backpack"));
    }

    @Override
    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.register(new HeatRecipeSimple(IIngredient.of(new ItemStack(ModItems.BOUND_LEATHER)), new ItemStack(ModItems.TANNED_LEATHER), 500).setRegistryName(TFCompat.MODID, "tanned_leather"));
    }

    @Override
    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.register(new KnappingRecipeSimple(Types.TANNED_LEATHER, false, new ItemStack(ModItems.BACKPACK, 1), "X   X", "X   X", "X   X", "X   X", "XXXXX").setRegistryName(TFCompat.MODID, "backpack"));
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "tannedLeather") && Helpers.playerHasItemMatchingOre(event.getEntityPlayer().inventory, "knife"))
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.TANNED_LEATHER);
                event.setCancellationResult(EnumActionResult.SUCCESS);
            }

        }
        else event.setCancellationResult(EnumActionResult.FAIL);
    }
}
