package mrthomas20121.tfcompat.compat.ember;

import mrthomas20121.rocksalt.utils.TFCUtils;
import mrthomas20121.tfcompat.api.knapping.Types;
import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.util.OreDictionaryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import teamroots.embers.RegistryManager;
import teamroots.embers.recipe.ItemMeltingRecipe;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class EmberRegistry extends RecipeRegistry {

    public EmberRegistry() {
        super("ember_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        OreDictionary.registerOre("caminiteBlend", RegistryManager.blend_caminite);

        HeatHelper.addItemHeat(new ItemStack(RegistryManager.stamp_flat_raw), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(RegistryManager.stamp_plate_raw), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(RegistryManager.stamp_bar_raw), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(RegistryManager.stamp_gear_raw), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(RegistryManager.plate_caminite_raw), 1.0F, 1599.0F);
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        for(Metal metal: TFCRegistries.METALS.getValuesCollection()) {
            teamroots.embers.recipe.RecipeRegistry.meltingRecipes.add(new ItemMeltingRecipe(new OreIngredient(OreDictionaryHelper.toString("ingot", metal.getRegistryName().getPath())), FluidRegistry.getFluidStack(metal.getRegistryName().getPath().toLowerCase(), 144)));
            if(metal.isUsable()) {
                teamroots.embers.recipe.RecipeRegistry.meltingRecipes.add(new ItemMeltingRecipe(new OreIngredient(OreDictionaryHelper.toString("dust", metal.getRegistryName().getPath())), FluidRegistry.getFluidStack(metal.getRegistryName().getPath().toLowerCase(), 144)));
                teamroots.embers.recipe.RecipeRegistry.meltingRecipes.add(new ItemMeltingRecipe(new OreIngredient(OreDictionaryHelper.toString("nugget", metal.getRegistryName().getPath())), FluidRegistry.getFluidStack(metal.getRegistryName().getPath().toLowerCase(), 144)));
            }
        }
    }

    @Override
    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.registerAll(
                new HeatRecipeSimple(IIngredient.of(RegistryManager.stamp_flat_raw), new ItemStack(RegistryManager.stamp_flat), 1500).setRegistryName(TFCUtils.getLoc("stamp")),
                new HeatRecipeSimple(IIngredient.of(RegistryManager.stamp_bar_raw), new ItemStack(RegistryManager.stamp_bar), 1500).setRegistryName(TFCUtils.getLoc("stamp_bar")),
                new HeatRecipeSimple(IIngredient.of(RegistryManager.stamp_gear_raw), new ItemStack(RegistryManager.stamp_gear), 1500).setRegistryName(TFCUtils.getLoc("stamp_gear")),
                new HeatRecipeSimple(IIngredient.of(RegistryManager.stamp_plate_raw), new ItemStack(RegistryManager.stamp_plate), 1500).setRegistryName(TFCUtils.getLoc("stamp_plate")),
                new HeatRecipeSimple(IIngredient.of(RegistryManager.plate_caminite_raw), new ItemStack(RegistryManager.plate_caminite), 1500).setRegistryName(TFCUtils.getLoc("plate"))
        );
    }

    @Override
    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.registerAll(
                new KnappingRecipeSimple(Types.CAMINITE_BLEND, true, new ItemStack(RegistryManager.plate_caminite_raw), "XXX  ", "     ", "     ", "     ", "  XXX").setRegistryName(TFCUtils.getLoc("plate")),
                new KnappingRecipeSimple(Types.CAMINITE_BLEND, true, new ItemStack(RegistryManager.stamp_flat_raw), "     ", "     ", "  X  ", "     ", "     ").setRegistryName(TFCUtils.getLoc("stamp_flat")),
                new KnappingRecipeSimple(Types.CAMINITE_BLEND, true, new ItemStack(RegistryManager.stamp_bar_raw), "X   X", "     ", " XXX ", "     ", "X   X").setRegistryName(TFCUtils.getLoc("stamp_bar")),
                new KnappingRecipeSimple(Types.CAMINITE_BLEND, true, new ItemStack(RegistryManager.stamp_gear_raw), "X X X", " XXX ", "XX XX", " XXX ", "X X X").setRegistryName(TFCUtils.getLoc("stamp_gear")),
                new KnappingRecipeSimple(Types.CAMINITE_BLEND, true, new ItemStack(RegistryManager.stamp_plate_raw), "     ", "XXXXX", "XXXXX", "XXXXX", "     ").setRegistryName(TFCUtils.getLoc("stamp_plate"))
        );
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        super.onRightClick(event);
        if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "caminiteBlend"))
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.CAMINITE_BLEND);
            }
        }
    }
}
