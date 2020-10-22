package mrthomas20121.tfcompat.compat.betterwithmods;

import betterwithmods.common.BWRegistry;
import betterwithmods.common.items.ItemMaterial;
import betterwithmods.common.registry.block.recipe.BlockIngredient;
import com.google.common.collect.Lists;
import mrthomas20121.tfcompat.library.recipes.IRecipeRemoval;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.api.recipes.quern.QuernRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemAnimalHide;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class BetterWithModsRecipes implements RecipeCore, IRecipeRemoval {

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        millstoneRecipes();
        sawRecipes();
        cauldronRecipes();
    }

    @Override
    public void removal(IForgeRegistry<IRecipe> r) {
        ((IForgeRegistryModifiable<IRecipe>) r).remove(new ResourceLocation("tfc:gunpowder"));
        ((IForgeRegistryModifiable<IRecipe>) r).remove(new ResourceLocation("tfc:gunpowder_graphite"));
    }

    private void millstoneRecipes()
    {
        for(QuernRecipe recipe: TFCRegistries.QUERN.getValuesCollection())
        {
            NonNullList<IIngredient<ItemStack>> ingredient = recipe.getIngredients();
            NonNullList<ItemStack> outputs = recipe.getOutputs();
            ItemStack output = outputs.get(0);
            NonNullList<ItemStack> stacks = ingredient.get(0).getValidIngredients();
            if(!stacks.contains(getStack(Items.BONE, 1)) || !stacks.contains(getStack(Blocks.BONE_BLOCK, 1)) )
            {
                BWRegistry.MILLSTONE.addMillRecipe(convertStacks(stacks), output);
            }
        }
        // TFC Hides
        for(ItemAnimalHide.HideSize hideSize : ItemAnimalHide.HideSize.values())
        {
            BWRegistry.MILLSTONE.addMillRecipe(getStack(ItemAnimalHide.get(ItemAnimalHide.HideType.SOAKED, hideSize), 1), getStack(ItemAnimalHide.get(ItemAnimalHide.HideType.SCRAPED, hideSize), 1));
        }
    }
    private void sawRecipes()
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection())
        {
            BWRegistry.WOOD_SAW.addRecipe(new BlockIngredient(Lists.newArrayList(new ItemStack(BlockLogTFC.get(tree), 1, 4), new ItemStack(BlockLogTFC.get(tree), 1, 5), new ItemStack(BlockLogTFC.get(tree), 1, 6))), Lists.newArrayList(new ItemStack(ItemLumberTFC.get(tree), 8), ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.SAWDUST)));
        }
    }
    private void cauldronRecipes()
    {
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(new OreIngredient("dustSulfur"), new OreIngredient("dustSaltpeter"), new OreIngredient("dustCarbon"), new OreIngredient("dustGraphite")), getStack(Items.GUNPOWDER, 4));
        BWRegistry.CAULDRON.addStokedRecipe(getStack(ItemsTFC.QUIVER, 1), ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.GLUE));
    }
}
