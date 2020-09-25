package mrthomas20121.tfcompat.compat.improvedbackpacks;

import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import ru.poopycoders.improvedbackpacks.init.ModItems;

public class ImprovedBackpacksRegistry implements IHeatRecipe {

    public static ImprovedBackpacksRegistry instance = new ImprovedBackpacksRegistry();

    public void init(FMLInitializationEvent event) {
        HeatHelper.addItemHeat(new ItemStack(ModItems.BOUND_LEATHER), 600, 580);
    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.register(HeatHelper.addRecipe("improved_tanned_leather", new ItemStack(ModItems.BOUND_LEATHER), new ItemStack(ModItems.TANNED_LEATHER), 500));
    }
}
