package mrthomas20121.tfcompat.compat.forestry;

import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class ForestryRecipes implements RecipeCore {

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        ForestryRecipeHelper.addSqueezerRecipe(100, "categoryVegetable", "seed.oil", 100);
        ForestryRecipeHelper.addSqueezerRecipe(100, "categoryFruit", "juice", 100);
    }
}
