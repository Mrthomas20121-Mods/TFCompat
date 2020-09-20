package mrthomas20121.tfcompat.compat.forestry;

import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ForestryRecipeHelper {

    public static void addSqueezerRecipe(int time, ItemStack input, String fluidName, int amount)
    {
        RecipeManagers.squeezerManager.addRecipe(time, input, getFluidStack(fluidName, amount));
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
