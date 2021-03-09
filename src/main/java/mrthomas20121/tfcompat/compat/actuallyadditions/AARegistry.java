package mrthomas20121.tfcompat.compat.actuallyadditions;

import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class AARegistry extends RecipeRegistry {

    public AARegistry()
    {
        super("aa_registry");
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        ActuallyAdditionsAPI.addOilGenRecipe("olive_oil", 1000, 5);
    }
}
