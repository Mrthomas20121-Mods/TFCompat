package mrthomas20121.tfcompat.compat.thaumcraft;

import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
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
        super("thaumcraft_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        HeatHelper.addItemHeat("gemCinnabar", 600, 600);
        HeatHelper.addItemHeat(new ItemStack(ItemsTC.quicksilver), 600, 600);
    }

    @Override
    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.register(HeatHelper.addRecipe("cinnabar_to_quicksilver", "gemCinnabar", new ItemStack(ItemsTC.quicksilver), 500));
    }
}
