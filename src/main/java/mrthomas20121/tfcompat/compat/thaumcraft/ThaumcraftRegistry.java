package mrthomas20121.tfcompat.compat.thaumcraft;

import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.items.ItemsTC;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class ThaumcraftRegistry extends RecipeRegistry {

    public ThaumcraftRegistry()
    {
        super("");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        HeatHelper.addItemHeat("gemCinnabar", 600, 600);
        HeatHelper.addItemHeat(new ItemStack(ItemsTC.quicksilver), 600, 600);
    }

    @Nonnull
    @Override
    public ArrayList<HeatRecipe> addHeatRecipes(ArrayList<HeatRecipe> recipes) {
        recipes.add(HeatHelper.addRecipe("cinnabar_to_quicksilver", "gemCinnabar", new ItemStack(ItemsTC.quicksilver), 500));
        return super.addHeatRecipes(recipes);
    }
}
