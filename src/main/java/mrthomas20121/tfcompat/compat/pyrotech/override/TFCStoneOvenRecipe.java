package mrthomas20121.tfcompat.compat.pyrotech.override;

import com.codetaylor.mc.pyrotech.modules.tech.machine.recipe.StoneOvenRecipe;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.dries007.tfc.api.capability.food.FoodTrait;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class TFCStoneOvenRecipe extends StoneOvenRecipe {

    public TFCStoneOvenRecipe(ItemStack output, Ingredient input)
    {
        super(output, input);
        CapabilityFood.updateFoodFromPrevious(input.getMatchingStacks()[0], output);
        CapabilityFood.applyTrait(output, FoodTrait.WOOD_GRILLED);
    }
}
