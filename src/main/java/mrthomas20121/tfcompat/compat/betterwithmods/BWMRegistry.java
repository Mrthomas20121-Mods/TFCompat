package mrthomas20121.tfcompat.compat.betterwithmods;

import betterwithmods.common.BWMBlocks;
import betterwithmods.common.BWRegistry;
import betterwithmods.common.items.ItemMaterial;
import betterwithmods.common.BWMItems;
import betterwithmods.common.registry.block.recipe.BlockIngredient;
import betterwithmods.common.registry.bulk.recipes.MillRecipe;
import com.google.common.collect.Lists;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemAnimalHide;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class BWMRegistry extends RecipeRegistry {

    public BWMRegistry()
    {
        super("bwm_registry");
    }

    @Override
    public void removeRecipes(IForgeRegistryModifiable<IRecipe> r) {
        r.remove(new ResourceLocation("tfc:gunpowder"));
        r.remove(new ResourceLocation("tfc:gunpowder_graphite"));
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        if(TFCompatConfig.DefaultConfig.betterwithmods.millstone) millstoneRecipes();
        if(TFCompatConfig.DefaultConfig.betterwithmods.saw) sawRecipes();
        if(TFCompatConfig.DefaultConfig.betterwithmods.cauldron) cauldronRecipes();
    }

    private void millstoneRecipes()
    {
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

        Metal soulforged_steel = TFCRegistries.METALS.getValue(new ResourceLocation("tfc:soulforged_steel"));
        Metal wrought_iron = TFCRegistries.METALS.getValue(new ResourceLocation("tfc:wrought_iron"));

        List<Ingredient> inputs = new ArrayList<>();
        inputs.add(Ingredient.fromStacks(new ItemStack(BWMBlocks.URN, 1, 8)));
        inputs.add(Ingredient.fromItem(ItemMetal.get(wrought_iron, Metal.ItemType.INGOT)));
        inputs.add(new OreIngredient("dustCarbon"));
        inputs.add(Ingredient.fromStacks(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.SOUL_FLUX)));

        List<ItemStack> outputs = new ArrayList<>();
        outputs.add(new ItemStack(ItemMetal.get(soulforged_steel, Metal.ItemType.INGOT)));
        outputs.add(new ItemStack(BWMBlocks.URN, 1, 0));
        BWRegistry.CAULDRON.addStokedRecipe(inputs, outputs);

        removeCauldronRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.INGOT_STEEL), new ItemStack(BWMBlocks.URN, 1, 0));
    }

    private static void removeCauldronRecipe(ItemStack ...output) {
        List<ItemStack> stacks = Lists.newArrayList(output);
        BWRegistry.CAULDRON.remove(stacks);
    }
}
