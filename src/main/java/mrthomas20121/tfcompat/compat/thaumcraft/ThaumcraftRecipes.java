package mrthomas20121.tfcompat.compat.thaumcraft;

import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.items.ItemsTC;

public class ThaumcraftRecipes implements IHeatRecipe {

    public static ThaumcraftRecipes instance = new ThaumcraftRecipes();

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.register(HeatHelper.addRecipe("cinnabar_to_quicksilver", "gemCinnabar", new ItemStack(ItemsTC.quicksilver), 500));
    }
}
