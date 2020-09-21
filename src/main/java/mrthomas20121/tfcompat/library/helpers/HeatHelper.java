package mrthomas20121.tfcompat.library.helpers;

import mrthomas20121.rocksalt.utils.TFCUtils;
import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.items.ItemsTC;

public class HeatHelper {

    public static void addItemHeat(String oredict, int heatCap, int meltTemp)
    {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(oredict), () -> new ItemHeatHandler(null, heatCap, meltTemp));
    }
    public static void addItemHeat(ItemStack stack, int heatCap, int meltTemp)
    {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(stack), () -> new ItemHeatHandler(null, heatCap, meltTemp));
    }

    public static HeatRecipe addRecipe(String recipeName, String oredict, ItemStack output, int transformTemp)
    {
        return new HeatRecipeSimple(IIngredient.of(oredict), output, transformTemp).setRegistryName(TFCUtils.getLoc(recipeName));
    }
    public static HeatRecipe addRecipe(String recipeName, ItemStack stack, ItemStack output, int transformTemp)
    {
        return new HeatRecipeSimple(IIngredient.of(stack), output, transformTemp, Metal.Tier.TIER_I).setRegistryName(TFCUtils.getLoc(recipeName));
    }
}
