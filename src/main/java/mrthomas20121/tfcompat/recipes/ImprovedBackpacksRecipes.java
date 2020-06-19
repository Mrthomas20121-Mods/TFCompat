package mrthomas20121.tfcompat.recipes;

import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import ru.poopycoders.improvedbackpacks.init.ModItems;

public class ImprovedBackpacksRecipes extends Recipes {
    public static void init()
    {

    }
    public static void HeatRecipes(IForgeRegistry<HeatRecipe> r)
    {
        r.register(new HeatRecipeSimple(IIngredient.of(getStack(ModItems.BOUND_LEATHER, 1)), getStack(ModItems.TANNED_LEATHER, 1), 500).setRegistryName(new ResourceLocation(TFCompat.MODID, "tanned_leather")));
    }
    public static void initHeating()
    {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(getStack(ModItems.BOUND_LEATHER, 1)), () -> new ItemHeatHandler(null, 600, 580));
    }

}
