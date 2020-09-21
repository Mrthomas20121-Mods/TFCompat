package mrthomas20121.tfcompat.library.helpers;

import mrthomas20121.rocksalt.utils.TFCUtils;
import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.minecraft.item.ItemStack;

public class KnappingHelper {

    public static KnappingRecipeSimple addClayKnapping(String registryName, boolean outsideSlotRequired, ItemStack output, String... pattern)
    {
        KnappingRecipeSimple recipe = new KnappingRecipeSimple(KnappingType.CLAY, outsideSlotRequired, output, pattern);
        recipe.setRegistryName(TFCUtils.getLoc(registryName));
        return recipe;
    }
}
