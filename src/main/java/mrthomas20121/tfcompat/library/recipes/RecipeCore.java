package mrthomas20121.tfcompat.library.recipes;

import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public interface RecipeCore {

    void registerRecipes(IForgeRegistry<IRecipe> r);

    default ItemStack getStack(Item item, int stack, int metadata)
    {
        return new ItemStack(item, stack, metadata);
    }

    default ItemStack getStack(Item item, int stack)
    {
        return new ItemStack(item, stack);
    }

    default ItemStack getStack(Block block, int stack)
    {
        return new ItemStack(block, stack);
    }

    default FluidStack getFluid(String fluid, int amount)
    {
        return new FluidStack(FluidRegistry.getFluid(fluid), amount);
    }
    default NonNullList<ItemStack> getOres(String ore)
    {
        return OreDictionary.getOres(ore);
    }
    default ArrayList<Ingredient> getIngredients(NonNullList<ItemStack> stacks)
    {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for(ItemStack stack: stacks)
        {
            ingredients.add(Ingredient.fromStacks(stack));
        }
        return ingredients;
    }
    default ArrayList<Ingredient> merge(Ingredient ...ingredients)
    {
        ArrayList<Ingredient> result = new ArrayList<>();
        for(Ingredient ingredient : ingredients)
        {
            result.add(ingredient);
        }
        return result;
    }
    default Ingredient getIngredientFromOredict(String oredict, int amount)
    {
        return convertStacks(IIngredient.of(oredict, amount).getValidIngredients());
    }
    default Ingredient convertStacks(NonNullList<ItemStack> stacks)
    {
        ArrayList<Ingredient> output = new ArrayList<>();
        for(ItemStack stack : stacks)
        {
            output.add(Ingredient.fromStacks(stack));
        }
        return Ingredient.merge(output);
    }
}
