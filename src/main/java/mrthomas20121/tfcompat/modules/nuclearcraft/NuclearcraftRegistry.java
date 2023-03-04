package mrthomas20121.tfcompat.modules.nuclearcraft;

import com.google.common.collect.Lists;
import mrthomas20121.tfcompat.api.module.ModuleRegistry;
import nc.config.NCConfig;
import nc.init.NCBlocks;
import nc.recipe.AbstractRecipeHandler;
import nc.recipe.NCRecipes;
import nc.recipe.ingredient.FluidIngredient;
import nc.recipe.ingredient.ItemIngredient;
import nc.util.UnitHelper;
import net.dries007.tfc.objects.blocks.BlocksTFC;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static nc.util.FluidStackHelper.BUCKET_VOLUME;

public class NuclearcraftRegistry extends ModuleRegistry {

    // using the lowest priority to register the recipes because Nuclearcraft init their recipe handler in this event with a normal priority
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        if(NuclearcraftModConfig.meltingRecipes) {
            // remove
            NCRecipes.melter.removeRecipe(NCRecipes.melter.getRecipeFromIngredients(Lists.newArrayList(new ItemIngredient(new ItemStack(Blocks.ICE))), Lists.newArrayList(new FluidIngredient(FluidRegistry.getFluidStack("water", BUCKET_VOLUME)))));
            NCRecipes.melter.removeRecipe(NCRecipes.melter.getRecipeFromIngredients(Lists.newArrayList(new ItemIngredient(new ItemStack(Blocks.PACKED_ICE))), Lists.newArrayList(new FluidIngredient(FluidRegistry.getFluidStack("water", BUCKET_VOLUME)))));

            // add back the ice/packed ice recipe using fresh water instead
            NCRecipes.melter.addRecipe(Blocks.ICE, AbstractRecipeHandler.fluidStack("fresh_water", BUCKET_VOLUME), 0.25D, 0.5D);
            NCRecipes.melter.addRecipe(Blocks.PACKED_ICE, AbstractRecipeHandler.fluidStack("fresh_water", BUCKET_VOLUME), 0.25D, 0.5D, 0.5D);

            // sea ice to salt water recipe
            NCRecipes.melter.addRecipe(BlocksTFC.SEA_ICE, AbstractRecipeHandler.fluidStack("salt_water", BUCKET_VOLUME), 0.25D, 0.5D);
        }

        if(NuclearcraftModConfig.waterSourceRecipes) {
            // change to infinite water source gen
            NCRecipes.collector.addRecipe(NCBlocks.water_source, AbstractRecipeHandler.emptyItemStack(), AbstractRecipeHandler.fluidStack("fresh_water", 1000), UnitHelper.prefix(NCConfig.processor_passive_rate[1], 5, "B/t", -1));
            NCRecipes.collector.addRecipe(NCBlocks.water_source_compact, AbstractRecipeHandler.emptyItemStack(), AbstractRecipeHandler.fluidStack("fresh_water", 1000), UnitHelper.prefix(NCConfig.processor_passive_rate[1] * 8.0D, 5, "B/t", -1));
            NCRecipes.collector.addRecipe(NCBlocks.water_source_dense, AbstractRecipeHandler.emptyItemStack(), AbstractRecipeHandler.fluidStack("fresh_water", 1000), UnitHelper.prefix(NCConfig.processor_passive_rate[1] * 64.0D, 5, "B/t", -1));
        }

        if(NuclearcraftModConfig.supercoolerRecipes) {
            // fresh water to ice
            NCRecipes.supercooler.addRecipe(AbstractRecipeHandler.fluidStack("fresh_water", 250), AbstractRecipeHandler.fluidStack("ice", 250), 0.25D, 0.5D);
        }
    }
}
