package mrthomas20121.tfcompat.compat.tech_reborn;

import mrthomas20121.rocksalt.utils.FluidUtils;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.metal.ItemOreTFC;
import net.dries007.tfc.objects.items.metal.ItemSmallOre;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import reborncore.api.recipe.RecipeHandler;
import techreborn.api.recipe.Recipes;
import techreborn.api.recipe.machines.IndustrialSawmillRecipe;
import techreborn.init.recipes.IndustrialSawmillRecipes;
import techreborn.init.recipes.WireMillRecipes;
import tfctech.objects.items.metal.ItemTechMetal;

public class TechRebornRecipes implements RecipeCore, IHeatRecipe {

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        sawMillRecipes();
        wireMillRecipes();
        grinderRecipes();
        extractorRecipes();
        compressorRecipes();
        rollingMachineRecipes();
    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {

    }

    private void sawMillRecipes()
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection())
        {
            BlockLogTFC blockLogTFC = BlockLogTFC.get(tree);
            ItemLumberTFC itemLumberTFC = ItemLumberTFC.get(tree);

            RecipeHandler.addRecipe(new IndustrialSawmillRecipe(getStack(blockLogTFC, 1), getFluid("fresh_water", 1000), getStack(itemLumberTFC, 1), (ItemStack)null, (ItemStack)null, 5, 4000, false));
        }
    }

    private void wireMillRecipes()
    {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection())
        {
            ItemStack scrap = getStack(ItemMetal.get(metal, Metal.ItemType.SCRAP), 1);
            ItemStack wire = getStack(ItemTechMetal.get(metal, ItemTechMetal.ItemType.WIRE), 2);
            Recipes.wireMill.createRecipe().withInput(scrap).withOutput(wire).withEnergyCostPerTick(2).withOperationDuration(200).register();
        }
    }

    private void grinderRecipes()
    {
        for(Ore ore : TFCRegistries.ORES.getValuesCollection())
        {
            if(ore.getMetal() != null)
            {
                Metal metal = ore.getMetal();
                Item dust = ItemMetal.get(metal, Metal.ItemType.DUST);
                ItemStack normal_ore = ItemOreTFC.get(ore, Ore.Grade.NORMAL, 2);
                ItemStack poor_ore = ItemOreTFC.get(ore, Ore.Grade.POOR, 5);
                ItemStack rich_ore = ItemOreTFC.get(ore, Ore.Grade.RICH, 1);
                ItemStack small_ore = ItemSmallOre.get(ore, 10);
                Recipes.grinder.createRecipe().withInput(small_ore).withOutput(getStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
                Recipes.grinder.createRecipe().withInput(poor_ore).withOutput(getStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
                Recipes.grinder.createRecipe().withInput(normal_ore).withOutput(getStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
                Recipes.grinder.createRecipe().withInput(rich_ore).withOutput(getStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
            }
        }
    }

    private void extractorRecipes()
    {

    }

    private void compressorRecipes()
    {

    }

    private void rollingMachineRecipes()
    {

    }
}
