package mrthomas20121.tfcompat.library.recipes;

import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public interface IHeatRecipe {

    void initHeatRecipes(IForgeRegistry<HeatRecipe> r);
}
