package mrthomas20121.tfcompat.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.client.gui.GuiKnapping;
import net.dries007.tfc.compat.jei.categories.KnappingCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.stream.Collectors;

import static net.dries007.tfc.compat.jei.TFCJEIPlugin.*;

public class TFCompatPlugin implements IModPlugin
{

    public static final String KNAP_TANNED_LEATHER_UID = TFCompat.MODID + ".knap.tanned_leather";
    public static final String KNAP_PORCELAIN_UID = TFCompat.MODID + ".knap.porcelain";

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        if(Loader.isModLoaded("ceramics")) registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_TANNED_LEATHER_UID));
        if(Loader.isModLoaded("improvedbackpacks")) registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_PORCELAIN_UID));
    }

    @Override
    public void register(IModRegistry registry)
    {
        if(Loader.isModLoaded("ceramics"))
        {
            List<CompatKnappingRecipeWrapper> porcelain_recipes = TFCRegistries.KNAPPING.getValuesCollection().stream()
                    .filter(recipe -> recipe.getType() == Types.PORCELAIN)
                    .map(recipe -> new CompatKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper()))
                    .collect(Collectors.toList());
            registry.addRecipes(porcelain_recipes, KNAP_PORCELAIN_UID);
            NonNullList<ItemStack> ores = OreDictionary.getOres("porcelain");
            for(ItemStack itemStack : ores)
            {
                registry.addRecipeCatalyst(itemStack, KNAP_TANNED_LEATHER_UID);
            }
        }

        if(Loader.isModLoaded("improvedbackpacks"))
        {
            List<CompatKnappingRecipeWrapper> tanned_lether_recipes = TFCRegistries.KNAPPING.getValuesCollection().stream()
                    .filter(recipe -> recipe.getType() == Types.PORCELAIN)
                    .map(recipe -> new CompatKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper()))
                    .collect(Collectors.toList());
            registry.addRecipes(tanned_lether_recipes, KNAP_TANNED_LEATHER_UID);
            NonNullList<ItemStack> ores = OreDictionary.getOres("tannedLeather");
            for(ItemStack itemStack : ores)
            {
                registry.addRecipeCatalyst(itemStack, KNAP_TANNED_LEATHER_UID);
            }
        }
        registry.addRecipeClickArea(GuiKnapping.class, 97, 44, 22, 15, KNAP_PORCELAIN_UID, KNAP_TANNED_LEATHER_UID, KNAP_CLAY_UID, KNAP_FIRECLAY_UID, KNAP_LEATHER_UID, KNAP_STONE_UID);
    }
}