package mrthomas20121.tfcompat.recipes;

import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.BlockDoorTFC;
import net.dries007.tfc.objects.blocks.wood.BlockFenceGateTFC;
import net.dries007.tfc.objects.blocks.wood.BlockFenceTFC;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.objects.blocks.wood.BlockPlanksTFC;
import net.dries007.tfc.objects.blocks.wood.BlockTrapDoorWoodTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tfctech.objects.items.TechItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import mekanism.common.recipe.RecipeHandler;

public class MekanismRecipes extends Recipes
{
    public static void recipes() 
    {
        SawMillRecipes();
        EvaporationRecipes();
        CrusherRecipes();
    }
    private static void SawMillRecipes() 
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection()) 
        {
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockLogTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 6), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockPlanksTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 3), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockDoorTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 4), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockTrapDoorWoodTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 4), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockFenceTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 3), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockFenceGateTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 4), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
        }
    }
    private static void CrusherRecipes()
    {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection()) 
        {
            RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.DOUBLE_INGOT), 1), getStack(ItemMetal.get(metal, Metal.ItemType.DUST), 2));
            RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SCRAP), 1), getStack(ItemMetal.get(metal, Metal.ItemType.DUST), 1));
            RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SHEET), 1), getStack(ItemMetal.get(metal, Metal.ItemType.DUST), 1));
            RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.DOUBLE_SHEET), 1), getStack(ItemMetal.get(metal, Metal.ItemType.DUST), 2));
            if(metal.isToolMetal()) 
            {
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.ANVIL), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 7));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.AXE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.CHISEL), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.HAMMER), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.HOE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.JAVELIN), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.KNIFE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.MACE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.PICK), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.PROPICK), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SAW), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SCYTHE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SHOVEL), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SWORD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.TUYERE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SHEARS), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));

                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.AXE_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.CHISEL_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.HAMMER_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.HOE_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.JAVELIN_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.KNIFE_BLADE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.MACE_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.PICK_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.PROPICK_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SAW_BLADE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SCYTHE_BLADE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SHOVEL_HEAD), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.SWORD_BLADE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
            }
            if(metal.isArmorMetal()) 
            {
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.BOOTS), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.CHESTPLATE), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 3));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.GREAVES), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 2));
                RecipeHandler.addCrusherRecipe(getStack(ItemMetal.get(metal, Metal.ItemType.HELMET), 1), getStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
            }
        }
    }
    private static void EvaporationRecipes() 
    {
        RecipeHandler.addThermalEvaporationRecipe(getFluid("salt_water", 1), getFluid("brine", 1));
    }
}