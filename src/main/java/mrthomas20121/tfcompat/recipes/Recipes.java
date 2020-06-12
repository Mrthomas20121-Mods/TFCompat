package mrthomas20121.tfcompat.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public abstract class Recipes 
{
    protected static ItemStack getStack(Item item, int stack) 
    {
        return new ItemStack(item, stack);
    }
    protected static ItemStack getStack(Block block, int stack) 
    {
        return new ItemStack(block, stack);
    }
    protected static FluidStack getFluid(String fluid, int amount)
    {
        return new FluidStack(FluidRegistry.getFluid(fluid), amount);
    }
}