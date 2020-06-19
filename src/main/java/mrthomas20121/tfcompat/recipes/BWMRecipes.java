package mrthomas20121.tfcompat.recipes;

import betterwithmods.common.BWMItems;
import betterwithmods.common.BWRegistry;
import betterwithmods.common.items.ItemMaterial;
import betterwithmods.common.registry.crafting.CuttingRecipe;
import betterwithmods.util.StackIngredient;
import com.google.common.collect.Lists;
import net.dries007.tfc.api.recipes.quern.QuernRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.blocks.BlockSlabTFC;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.objects.blocks.wood.BlockPlanksTFC;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemAnimalHide;
import net.dries007.tfc.objects.items.ItemPowder;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.metal.ItemMetalShears;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

import java.util.ArrayList;
import java.util.List;

public class BWMRecipes extends Recipes {

    public static void init()
    {
        registerOredict();
        millstoneRecipes();
        sawRecipes();
        CauldronRecipes();
    }
    private static void millstoneRecipes()
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
    private static void sawRecipes()
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection())
        {
            BWRegistry.WOOD_SAW.addRecipe(getStack(BlockLogTFC.get(tree), 1), ItemLumberTFC.get(tree, 8));
        }
    }
    private static void CauldronRecipes()
    {
        BWRegistry.CAULDRON.addUnstokedRecipe(Lists.newArrayList(new OreIngredient("dustSulfur"), new OreIngredient("dustSaltpeter"), new OreIngredient("dustCarbon"), new OreIngredient("dustGraphite")), getStack(Items.GUNPOWDER, 4));
        BWRegistry.CAULDRON.addStokedRecipe(getStack(ItemsTFC.QUIVER, 1), ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.GLUE));
    }
    private static void registerOredict()
    {
        OreDictionary.registerOre("dustCarbon", ItemPowder.get(Powder.CHARCOAL));
    }
}
