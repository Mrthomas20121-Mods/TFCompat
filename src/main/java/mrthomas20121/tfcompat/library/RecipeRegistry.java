package mrthomas20121.tfcompat.library;

import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public abstract class RecipeRegistry {

    private ResourceLocation registryName;

    public RecipeRegistry(ResourceLocation registryName)
    {
        this.registryName=registryName;
    }

    public RecipeRegistry(String registryName) {
        this(new ResourceLocation(TFCompat.MODID, registryName));
    }

    public ResourceLocation getRegistryName() {
        return registryName;
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void registerRecipes(IForgeRegistry<IRecipe> r) {

    }

    public void removeRecipes(IForgeRegistryModifiable<IRecipe> r)
    {
    }

    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {

    }

    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
    }

    public void registerBarrelRecipes(IForgeRegistry<BarrelRecipe> r) {

    }

    public void registerAnvilRecipes(IForgeRegistry<AnvilRecipe> r) {

    }

    public void registerItems(IForgeRegistry<Item> r)
    {

    }

    public void registerBlocks(IForgeRegistry<Block> r)
    {

    }

    public void registerModels(ModelRegistryEvent event)
    {

    }

    public void onRightClickBlockEvent(PlayerInteractEvent.RightClickBlock event)
    {

    }

    public void onRightClick(PlayerInteractEvent.RightClickItem event)
    {

    }
}
