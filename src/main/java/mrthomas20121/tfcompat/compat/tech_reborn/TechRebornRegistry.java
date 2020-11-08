package mrthomas20121.tfcompat.compat.tech_reborn;

import mrthomas20121.rocksalt.utils.TFCUtils;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.objects.blocks.wood.BlockSaplingTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.metal.ItemOreTFC;
import net.dries007.tfc.objects.items.metal.ItemSmallOre;
import net.dries007.tfc.objects.items.wood.ItemLumberTFC;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import reborncore.api.recipe.RecipeHandler;
import techreborn.api.recipe.Recipes;
import techreborn.api.recipe.machines.IndustrialSawmillRecipe;
import techreborn.init.ModItems;
import tfctech.objects.items.metal.ItemTechMetal;

import javax.annotation.Nonnull;
import java.util.ArrayList;

@SuppressWarnings("ConstantConditions")
public class TechRebornRegistry extends RecipeRegistry {

    public TechRebornRegistry()
    {
        super("techreborn_registry");
    }

    @Nonnull
    @Override
    public ArrayList<IRecipe> addRecipes(ArrayList<IRecipe> recipes) {
        sawMillRecipes();
        wireMillRecipes();
        grinderRecipes();
        extractorRecipes();
        compressorRecipes();
        rollingMachineRecipes();
        return super.addRecipes(recipes);
    }

    private void sawMillRecipes()
    {
        for(Tree tree : TFCRegistries.TREES.getValuesCollection())
        {
            BlockLogTFC blockLogTFC = BlockLogTFC.get(tree);
            ItemLumberTFC itemLumberTFC = ItemLumberTFC.get(tree);


            RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(blockLogTFC, 1), FluidRegistry.getFluidStack("fresh_water", 1000), new ItemStack(itemLumberTFC, 8), null, null, 50, 4000, false));
        }
    }

    private void wireMillRecipes()
    {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection())
        {
            if(checkMetal(metal))
            {
                ItemStack scrap = new ItemStack(ItemMetal.get(metal, Metal.ItemType.SCRAP), 1);
                ItemStack wire = new ItemStack(ItemTechMetal.get(metal, ItemTechMetal.ItemType.WIRE), 2);
                Recipes.wireMill.createRecipe().withInput(scrap).withOutput(wire).withEnergyCostPerTick(2).withOperationDuration(200).register();
            }
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
                ItemStack normal_ore = ItemOreTFC.get(ore, Ore.Grade.NORMAL, 4);
                ItemStack poor_ore = ItemOreTFC.get(ore, Ore.Grade.POOR, 6);
                ItemStack rich_ore = ItemOreTFC.get(ore, Ore.Grade.RICH, 3);
                ItemStack small_ore = ItemSmallOre.get(ore, 10);
                Recipes.grinder.createRecipe().withInput(small_ore).withOutput(new ItemStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
                Recipes.grinder.createRecipe().withInput(poor_ore).withOutput(new ItemStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
                Recipes.grinder.createRecipe().withInput(normal_ore).withOutput(new ItemStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
                Recipes.grinder.createRecipe().withInput(rich_ore).withOutput(new ItemStack(dust, 1)).withEnergyCostPerTick(5).withOperationDuration(200).register();
            }
        }
    }

    private void extractorRecipes()
    {
        if(Loader.isModLoaded("tfctech"))
        {
            Tree hevea = TFCRegistries.TREES.getValue(TFCUtils.getLoc("hevea"));
            BlockSaplingTFC heave_sap = BlockSaplingTFC.get(hevea);
            Recipes.extractor.createRecipe().withInput(new ItemStack(heave_sap, 1)).withOutput(new ItemStack(ModItems.PARTS, 1, 32)).register();
        }
    }

    private void compressorRecipes()
    {

    }

    private void rollingMachineRecipes()
    {

    }

    private static boolean checkMetal(Metal metal)
    {
        return ObfuscationReflectionHelper.getPrivateValue(Metal.class, metal, "usable").equals(true);
    }
}
