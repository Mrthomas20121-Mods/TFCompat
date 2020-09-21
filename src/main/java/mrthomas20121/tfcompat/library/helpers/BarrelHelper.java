package mrthomas20121.tfcompat.library.helpers;

import mrthomas20121.rocksalt.utils.TFCUtils;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.util.calendar.ICalendar;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BarrelHelper {

    public static BarrelRecipe addRecipe(String recipeName, String fluidInput, int amount, String oredict, ItemStack output, int duration)
    {
        BarrelRecipe barrelRecipe = new BarrelRecipe(IIngredient.of(getFluid(fluidInput), amount), IIngredient.of(oredict), null, output, ICalendar.TICKS_IN_HOUR*duration);
        barrelRecipe.setRegistryName(TFCUtils.getLoc(recipeName));
        return barrelRecipe;
    }

    public static BarrelRecipe addRecipe(String recipeName, Fluid fluidInput, int amount, String oredict, ItemStack output, int duration)
    {
        BarrelRecipe barrelRecipe = new BarrelRecipe(IIngredient.of(getFluid(fluidInput, amount)), IIngredient.of(oredict), null, output, ICalendar.TICKS_IN_HOUR*duration);
        barrelRecipe.setRegistryName(TFCUtils.getLoc(recipeName));
        return barrelRecipe;
    }

    public static BarrelRecipe addRecipe(String recipeName, Fluid fluidInput, int amount, ItemStack stack, ItemStack output, int duration)
    {
        BarrelRecipe barrelRecipe = new BarrelRecipe(IIngredient.of(getFluid(fluidInput, amount)), IIngredient.of(stack), null, output, ICalendar.TICKS_IN_HOUR*duration);
        barrelRecipe.setRegistryName(TFCUtils.getLoc(recipeName));
        return barrelRecipe;
    }

    public static BarrelRecipe addRecipe(String recipeName, String fluidInput, int amount, ItemStack input, ItemStack output, int duration)
    {
        BarrelRecipe barrelRecipe = new BarrelRecipe(IIngredient.of(getFluid(fluidInput), amount), IIngredient.of(input), null, output, ICalendar.TICKS_IN_HOUR*duration);
        barrelRecipe.setRegistryName(TFCUtils.getLoc(recipeName));
        return barrelRecipe;
    }

    public static BarrelRecipe addRecipe(String recipeName, String fluidInput, int amount, ItemStack input, ItemStack output, String outputFluid, int outputAmount, int duration)
    {
        BarrelRecipe barrelRecipe = new BarrelRecipe(IIngredient.of(getFluid(fluidInput), amount), IIngredient.of(input), getFluid(outputFluid, outputAmount), output, ICalendar.TICKS_IN_HOUR*duration);
        barrelRecipe.setRegistryName(TFCUtils.getLoc(recipeName));
        return barrelRecipe;
    }

    private static Fluid getFluid(String fluidname)
    {
        return FluidRegistry.getFluid(fluidname);
    }
    private static FluidStack getFluid(String fluidname, int amount)
    {
        return new FluidStack(FluidRegistry.getFluid(fluidname), amount);
    }
    private static FluidStack getFluid(Fluid fluid, int amount)
    {
        return new FluidStack(fluid, amount);
    }
}
