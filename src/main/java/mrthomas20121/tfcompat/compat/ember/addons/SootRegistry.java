package mrthomas20121.tfcompat.compat.ember.addons;

import mrthomas20121.rocksalt.utils.TFCUtils;
import mrthomas20121.tfcompat.api.knapping.Types;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import soot.Registry;
import teamroots.embers.recipe.ItemStampingRecipe;


import javax.annotation.Nonnull;
import java.util.ArrayList;

public class SootRegistry extends RecipeRegistry {

    public SootRegistry() {
        super("soot_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        HeatHelper.addItemHeat(new ItemStack(Registry.STAMP_NUGGET_RAW), 1.0F, 1599.0F);
    }

    @Override
    public void removeRecipes(IForgeRegistryModifiable<IRecipe> r) {
        r.remove(new ResourceLocation("addons:stamp_nugget_raw"));
        r.remove(new ResourceLocation("addons:caminite_clay"));
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        for(Metal metal: TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable()) teamroots.embers.recipe.RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(Ingredient.EMPTY, FluidRegistry.getFluidStack(metal.getRegistryName().getPath().toLowerCase(), 16), Ingredient.fromItem(Registry.STAMP_NUGGET), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET))));
        }
    }

    @Override
    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.register(new KnappingRecipeSimple(Types.CAMINITE_BLEND, true, new ItemStack(Registry.STAMP_NUGGET_RAW), " XXX ", "XX XX", "X   X", "XX XX", " XXX ").setRegistryName(TFCUtils.getLoc("stamp_nugget")));
    }
}
