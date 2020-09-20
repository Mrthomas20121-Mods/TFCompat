package mrthomas20121.tfcompat.compat.mekanism;

import mekanism.common.recipe.RecipeHandler;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.*;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import tfctech.objects.items.TechItems;

public class MekanismRecipes implements RecipeCore {

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        sawMillRecipes();
        crusherRecipes();
        evaporationRecipes();
    }

    private void sawMillRecipes()
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection())
        {
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockLogTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 8), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockPlanksTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 3), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockDoorTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 4), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockTrapDoorWoodTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 4), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockFenceTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 3), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(getStack(BlockFenceGateTFC.get(tree), 1), getStack(ItemLumberTFC.get(tree), 4), getStack(TechItems.WOOD_POWDER, 1), 0.2D);
        }
    }
    private void crusherRecipes()
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
    private void evaporationRecipes()
    {
        RecipeHandler.addThermalEvaporationRecipe(getFluid("salt_water", 1), getFluid("brine", 1));
    }
}
