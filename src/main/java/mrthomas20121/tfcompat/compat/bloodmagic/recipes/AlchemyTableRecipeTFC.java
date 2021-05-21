package mrthomas20121.tfcompat.compat.bloodmagic.recipes;

import WayofTime.bloodmagic.api.impl.recipe.RecipeAlchemyTable;
import WayofTime.bloodmagic.recipe.alchemyTable.AlchemyTableRecipe;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class AlchemyTableRecipeTFC extends RecipeAlchemyTable {

    public AlchemyTableRecipeTFC(@Nonnull NonNullList<Ingredient> input, @Nonnull ItemStack output, int syphon, int ticks, int minimumTier) {
        super(input, output, syphon, ticks, minimumTier);
        CapabilityFood.updateFoodDecayOnCreate(output);
    }

    public AlchemyTableRecipeTFC(@Nonnull ItemStack input, @Nonnull ItemStack output, int syphon, int ticks, int minimumTier) {
        this(NonNullList.from(Ingredient.fromStacks(input)), output, syphon, ticks, minimumTier);
    }
}
