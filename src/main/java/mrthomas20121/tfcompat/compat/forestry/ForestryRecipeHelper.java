package mrthomas20121.tfcompat.compat.forestry;

import forestry.api.recipes.RecipeManagers;
import forestry.core.ModuleCore;
import forestry.core.items.ItemRegistryCore;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class ForestryRecipeHelper {

    public static void addSqueezerRecipe(int time, ItemStack input, String fluidName, int amount)
    {
        RecipeManagers.squeezerManager.addRecipe(time, input, getFluidStack(fluidName, amount));
    }

    public static void addSqueezerRecipe(int time, String oredict, String fluidName, int amount)
    {
        ItemRegistryCore coreItems = ModuleCore.getItems();
        NonNullList<ItemStack> stacks = OreDictionary.getOres(oredict);
        for(ItemStack stack : stacks)
        {
            RecipeManagers.squeezerManager.addRecipe(time, stack, getFluidStack(fluidName, amount), new ItemStack(coreItems.mulch, 1), 20);
        }
    }

    private static FluidStack getFluidStack(String fluidName, int amount)
    {
        return new FluidStack(getFluid(fluidName), amount);
    }

    private static Fluid getFluid(String fluidName)
    {
        return FluidRegistry.getFluid(fluidName);
    }
}
