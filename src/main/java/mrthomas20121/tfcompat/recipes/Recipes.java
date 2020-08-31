package mrthomas20121.tfcompat.recipes;

import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    protected static NonNullList<ItemStack> getOres(String ore)
    {
        return OreDictionary.getOres(ore);
    }
    protected static ArrayList<Ingredient> getIngredients(NonNullList<ItemStack> stacks)
    {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for(ItemStack stack: stacks)
        {
            ingredients.add(Ingredient.fromStacks(stack));
        }
        return ingredients;
    }
    protected static ArrayList<Ingredient> merge(Ingredient ...ingredients)
    {
        ArrayList<Ingredient> result = new ArrayList<>();
        for(Ingredient ingredient : ingredients)
        {
            result.add(ingredient);
        }
        return result;
    }
    protected static Ingredient getIngredientFromOredict(String oredict, int amount)
    {
        return convertStacks(IIngredient.of(oredict, amount).getValidIngredients());
    }
    protected static Ingredient convertStacks(NonNullList<ItemStack> stacks)
    {
        ArrayList<Ingredient> output = new ArrayList<>();
        for(ItemStack stack : stacks)
        {
            output.add(Ingredient.fromStacks(stack));
        }
        return Ingredient.merge(output);
    }
}