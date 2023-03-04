package mrthomas20121.tfcompat.modules.pyrotech;

import com.codetaylor.mc.pyrotech.modules.tech.machine.recipe.StoneOvenRecipe;
import mrthomas20121.tfcompat.api.Reference;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class TFCStoneOvenRecipe extends StoneOvenRecipe {

    public TFCStoneOvenRecipe(ItemStack output, Ingredient input)
    {
        super(output, input);
        CapabilityFood.updateFoodFromPrevious(input.getMatchingStacks()[0], output);
        CapabilityFood.applyTrait(output, Reference.cookedTrait);
    }
}
