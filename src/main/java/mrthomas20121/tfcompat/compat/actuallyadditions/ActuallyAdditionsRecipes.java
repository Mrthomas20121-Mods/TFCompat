package mrthomas20121.tfcompat.compat.actuallyadditions;

import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class ActuallyAdditionsRecipes implements RecipeCore {

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        ActuallyAdditionsAPI.addOilGenRecipe("olive_oil", 1000, 5);
    }
}
