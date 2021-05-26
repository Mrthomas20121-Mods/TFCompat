package mrthomas20121.tfcompat.compat.pyrotech.compat;

import com.codetaylor.mc.pyrotech.modules.core.item.ItemMaterial;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.SoakingPotRecipe;
import mrthomas20121.tfcompat.TFCompat;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import tfctech.objects.items.TechItems;

public class CompatTFCTech {

    public static void registerSoakingPotRecipes(IForgeRegistry<SoakingPotRecipe> r) {
        r.register(new SoakingPotRecipe(ItemMaterial.EnumType.SLAKED_LIME.asStack(1), Ingredient.fromItem(TechItems.LIME),
                FluidRegistry.getFluidStack("fresh_water", 125), false, 7).setRegistryName(TFCompat.MOD_ID,"tech_slaked_lime"));
    }
}
