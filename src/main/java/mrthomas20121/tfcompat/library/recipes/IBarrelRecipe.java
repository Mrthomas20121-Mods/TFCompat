package mrthomas20121.tfcompat.library.recipes;

import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public interface IBarrelRecipe {

    void initBarrelRecipes(IForgeRegistry<BarrelRecipe> r);
}
