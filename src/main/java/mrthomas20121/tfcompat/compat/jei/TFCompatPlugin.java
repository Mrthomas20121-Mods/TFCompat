package mrthomas20121.tfcompat.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;
import mrthomas20121.tfcompat.client.CompatGuiKnapping;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.compat.jei.categories.KnappingCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.stream.Collectors;

@JEIPlugin
public class TFCompatPlugin implements IModPlugin
{
    public static final String KNAP_TANNED_LEATHER_UID = TFCompat.MODID + ".knap.tanned_leather";
    public static final String KNAP_PORCELAIN_UID = TFCompat.MODID + ".knap.porcelain";
    public static final String KNAP_FLINT_CLAY_UID = TFCompat.MODID + ".knap.flint_clay";
    public static final String KNAP_REFRACTORY_CLAY_UID = TFCompat.MODID + ".knap.refractory_clay";

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {

        registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_TANNED_LEATHER_UID));
        registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_PORCELAIN_UID));
        registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_FLINT_CLAY_UID));
        registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_REFRACTORY_CLAY_UID));
    }

    @Override
    public void register(IModRegistry registry)
    {
        List<CompatKnappingRecipeWrapper> porcelain_recipes = TFCRegistries.KNAPPING.getValuesCollection().stream()
                .filter(recipe -> recipe.getType() == Types.PORCELAIN)
                .map(recipe -> new CompatKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper()))
                .collect(Collectors.toList());
        registry.addRecipes(porcelain_recipes, KNAP_PORCELAIN_UID);
        NonNullList<ItemStack> ores = OreDictionary.getOres("clayPorcelain");
        for(ItemStack itemStack : ores)
        {
            registry.addRecipeCatalyst(itemStack, KNAP_PORCELAIN_UID);
        }

        List<CompatKnappingRecipeWrapper> tanned_lether_recipes = TFCRegistries.KNAPPING.getValuesCollection().stream()
                .filter(recipe -> recipe.getType() == Types.TANNED_LEATHER)
                .map(recipe -> new CompatKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper()))
                .collect(Collectors.toList());
        registry.addRecipes(tanned_lether_recipes, KNAP_TANNED_LEATHER_UID);
        NonNullList<ItemStack> ores1 = OreDictionary.getOres("tannedLeather");
        for(ItemStack itemStack : ores1)
        {
            registry.addRecipeCatalyst(itemStack, KNAP_TANNED_LEATHER_UID);
        }

        List<CompatKnappingRecipeWrapper> flintClayRecipes = TFCRegistries.KNAPPING.getValuesCollection().stream()
                .filter(recipe -> recipe.getType() == Types.REFRACTORY_CLAY)
                .map(recipe -> new CompatKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper()))
                .collect(Collectors.toList());
        registry.addRecipes(flintClayRecipes, KNAP_REFRACTORY_CLAY_UID);
        NonNullList<ItemStack> flint = OreDictionary.getOres("clayRefractory");
        for(ItemStack itemStack : flint)
        {
            registry.addRecipeCatalyst(itemStack, KNAP_REFRACTORY_CLAY_UID);
        }

        List<CompatKnappingRecipeWrapper> refractoryClayRecipes = TFCRegistries.KNAPPING.getValuesCollection().stream()
                .filter(recipe -> recipe.getType() == Types.FLINT_CLAY)
                .map(recipe -> new CompatKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper()))
                .collect(Collectors.toList());
        registry.addRecipes(refractoryClayRecipes, KNAP_FLINT_CLAY_UID);
        NonNullList<ItemStack> refractoryClay = OreDictionary.getOres("clayFlint");
        for(ItemStack itemStack : refractoryClay)
        {
            registry.addRecipeCatalyst(itemStack, KNAP_FLINT_CLAY_UID);
        }
        registry.addRecipeClickArea(CompatGuiKnapping.class, 97, 44, 22, 15, KNAP_PORCELAIN_UID, KNAP_TANNED_LEATHER_UID, KNAP_FLINT_CLAY_UID, KNAP_REFRACTORY_CLAY_UID);
    }
}