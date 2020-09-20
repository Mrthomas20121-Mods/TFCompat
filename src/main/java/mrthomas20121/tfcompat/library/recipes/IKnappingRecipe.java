package mrthomas20121.tfcompat.library.recipes;

import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public interface IKnappingRecipe {
    void initKnappingRecipes(IForgeRegistry<KnappingRecipe> r);
}
