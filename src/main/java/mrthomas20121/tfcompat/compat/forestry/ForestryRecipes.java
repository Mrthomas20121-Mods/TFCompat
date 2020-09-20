package mrthomas20121.tfcompat.compat.forestry;

import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.objects.blocks.agriculture.BlockCropTFC;
import net.dries007.tfc.util.agriculture.Crop;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class ForestryRecipes implements RecipeCore {

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        for(Crop crop: Crop.values())
        {
            ItemStack drop = crop.getFoodDrop(crop.getMaxStage());
            ItemStack blockCropTFC = getStack(BlockCropTFC.get(crop), 1);

            ForestryRecipeHelper.addSqueezerRecipe(100, drop, "seed_oil", 100);


        }
    }
}
