package mrthomas20121.tfcompat.compat.betterwithmods;

import betterwithmods.common.BWRegistry;
import betterwithmods.common.items.ItemMaterial;
import betterwithmods.common.registry.block.recipe.BlockIngredient;
import com.google.common.collect.Lists;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
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
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreIngredient;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class BWMRegistry extends RecipeRegistry {

    public BWMRegistry()
    {
        super("bwm_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Nonnull
    @Override
    public ArrayList<ResourceLocation> removeRecipes(ArrayList<ResourceLocation> recipes) {
        recipes.add(new ResourceLocation("tfc:gunpowder"));
        recipes.add(new ResourceLocation("tfc:gunpowder_graphite"));
        return recipes;
    }

    @Nonnull
    @Override
    public ArrayList<IRecipe> addRecipes(ArrayList<IRecipe> recipes) {
        if(TFCompatConfig.DefaultConfig.betterwithmods.millstone) millstoneRecipes();
        if(TFCompatConfig.DefaultConfig.betterwithmods.saw) sawRecipes();
        if(TFCompatConfig.DefaultConfig.betterwithmods.cauldron) cauldronRecipes();
        return recipes;
    }

    private void millstoneRecipes()
    {
        // quern recipes
        for(QuernRecipe recipe: TFCRegistries.QUERN.getValuesCollection())
        {
            NonNullList<IIngredient<ItemStack>> ingredient = recipe.getIngredients();
            NonNullList<ItemStack> stacks = ingredient.get(0).getValidIngredients();
            if(!stacks.contains(new ItemStack(Items.BONE, 1)) || !stacks.contains(new ItemStack(Blocks.BONE_BLOCK, 1)) )
            {
                BWRegistry.MILLSTONE.addMillRecipe(this.convertStacks(stacks), recipe.getOutputItem(stacks.get(0)));
            }
        }
        // TFC Hides
        for(ItemAnimalHide.HideSize hideSize : ItemAnimalHide.HideSize.values())
        {
            BWRegistry.MILLSTONE.addMillRecipe(new ItemStack(ItemAnimalHide.get(ItemAnimalHide.HideType.SOAKED, hideSize), 1), new ItemStack(ItemAnimalHide.get(ItemAnimalHide.HideType.SCRAPED, hideSize), 1));
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
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(new OreIngredient("dustSulfur"), new OreIngredient("dustSaltpeter"), new OreIngredient("dustCarbon"), new OreIngredient("dustGraphite")), new ItemStack(Items.GUNPOWDER, 4));
        BWRegistry.CAULDRON.addStokedRecipe(new ItemStack(ItemsTFC.QUIVER, 1), ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.GLUE));
    }
}
