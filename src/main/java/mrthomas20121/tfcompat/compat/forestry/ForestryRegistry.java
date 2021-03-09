package mrthomas20121.tfcompat.compat.forestry;

import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class ForestryRegistry extends RecipeRegistry {

    public ForestryRegistry()
    {
        super("forestry_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        ForestryRecipeHelper.addSqueezerRecipe(100, "categoryVegetable", "seed.oil", 100);
        ForestryRecipeHelper.addSqueezerRecipe(100, "categoryFruit", "juice", 100);
    }
}
