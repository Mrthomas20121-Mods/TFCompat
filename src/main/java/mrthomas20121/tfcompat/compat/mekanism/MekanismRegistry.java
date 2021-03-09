package mrthomas20121.tfcompat.compat.mekanism;

import mekanism.common.recipe.RecipeHandler;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.*;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class MekanismRegistry extends RecipeRegistry {

    public MekanismRegistry()
    {
        super("mekanism_registry");
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        if(TFCompatConfig.DefaultConfig.mekanism.sawmill) sawMillRecipes();
        if(TFCompatConfig.DefaultConfig.mekanism.crusher) crusherRecipes();
        if(TFCompatConfig.DefaultConfig.mekanism.evaporation) evaporationRecipes();
    }

    private void sawMillRecipes()
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection())
        {
            RecipeHandler.addPrecisionSawmillRecipe(new ItemStack(BlockLogTFC.get(tree), 1), new ItemStack(ItemLumberTFC.get(tree), 8), new ItemStack(ItemsTFC.WOOD_ASH, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(new ItemStack(BlockPlanksTFC.get(tree), 1), new ItemStack(ItemLumberTFC.get(tree), 3), new ItemStack(ItemsTFC.WOOD_ASH, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(new ItemStack(BlockDoorTFC.get(tree), 1), new ItemStack(ItemLumberTFC.get(tree), 4), new ItemStack(ItemsTFC.WOOD_ASH, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(new ItemStack(BlockTrapDoorWoodTFC.get(tree), 1), new ItemStack(ItemLumberTFC.get(tree), 4), new ItemStack(ItemsTFC.WOOD_ASH, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(new ItemStack(BlockFenceTFC.get(tree), 1), new ItemStack(ItemLumberTFC.get(tree), 3), new ItemStack(ItemsTFC.WOOD_ASH, 1), 0.2D);
            RecipeHandler.addPrecisionSawmillRecipe(new ItemStack(BlockFenceGateTFC.get(tree), 1), new ItemStack(ItemLumberTFC.get(tree), 4), new ItemStack(ItemsTFC.WOOD_ASH, 1), 0.2D);
        }
    }
    private void crusherRecipes()
    {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection())
        {
            RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.DOUBLE_INGOT), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.DUST), 2));
            RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SCRAP), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.DUST), 1));
            RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SHEET), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.DUST), 1));
            RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.DOUBLE_SHEET), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.DUST), 2));
            if(metal.isToolMetal())
            {
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.ANVIL), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 7));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.AXE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.CHISEL), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.HAMMER), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.HOE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.JAVELIN), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.KNIFE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.MACE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.PICK), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.PROPICK), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SAW), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SCYTHE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SHOVEL), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SWORD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.TUYERE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SHEARS), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));

                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.AXE_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.CHISEL_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.HAMMER_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.HOE_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.JAVELIN_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.KNIFE_BLADE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.MACE_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.PICK_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.PROPICK_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SAW_BLADE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SCYTHE_BLADE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SHOVEL_HEAD), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.SWORD_BLADE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.NUGGET), 5));
            }
            if(metal.isArmorMetal())
            {
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.BOOTS), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.CHESTPLATE), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 3));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.GREAVES), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 2));
                RecipeHandler.addCrusherRecipe(new ItemStack(ItemMetal.get(metal, Metal.ItemType.HELMET), 1), new ItemStack(ItemMetal.get(metal, Metal.ItemType.INGOT), 1));
            }
        }
    }
    private void evaporationRecipes()
    {
        RecipeHandler.addThermalEvaporationRecipe(FluidRegistry.getFluidStack("salt_water", 1), FluidRegistry.getFluidStack("brine", 1));
    }
}
