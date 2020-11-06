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
        return null;
    }

    public CompatKnappingRecipeWrapper(KnappingRecipe recipe, IGuiHelper helper)
    {
        super(recipe, helper, getHighTexture(recipe.getType()), null);

    }
    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ItemStack output = recipe.getOutput(ItemStack.EMPTY);
        ingredients.setOutput(VanillaTypes.ITEM, output);
    }
}
