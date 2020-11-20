package mrthomas20121.tfcompat.compat.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.compat.jei.wrappers.KnappingRecipeWrapper;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CompatKnappingRecipeWrapper extends KnappingRecipeWrapper {

    private static final ResourceLocation TANNED_LEATHER_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/tanned_leather.png");
    private static final ResourceLocation PORCELAIN_TEXTURE = new ResourceLocation("ceramics:textures/blocks/porcelain_raw.png");
    private static final ResourceLocation FLINT_CLAY_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/flint_clay_button.png");
    private static final ResourceLocation FLINT_CLAY_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/flint_clay_button_disabled.png");
    private static final ResourceLocation REFRACTORY_CLAY_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/refractory_clay_button.png");
    private static final ResourceLocation REFRACTORY_CLAY_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/refractory_clay_button.png");

    private static ResourceLocation getHighTexture(KnappingType type)
    {
        if(type == Types.PORCELAIN)
        {
            return PORCELAIN_TEXTURE;
        }
        else if (type == Types.TANNED_LEATHER)
        {
            return TANNED_LEATHER_TEXTURE;
        }
        else if(type == Types.FLINT_CLAY)
        {
            return FLINT_CLAY_TEXTURE;
        }
        else if(type == Types.REFRACTORY_CLAY)
        {
            return REFRACTORY_CLAY_TEXTURE;
        }
        return null;
    }
    private static ResourceLocation getLowTexture(KnappingType type)
    {
        if(type == Types.FLINT_CLAY)
        {
            return FLINT_CLAY_DISABLED_TEXTURE;
        }
        else if(type == Types.REFRACTORY_CLAY)
        {
            return REFRACTORY_CLAY_DISABLED_TEXTURE;
        }
        return null;
    }

    public CompatKnappingRecipeWrapper(KnappingRecipe recipe, IGuiHelper helper)
    {
        super(recipe, helper, getHighTexture(recipe.getType()), getLowTexture(recipe.getType()));

    }
}
