package mrthomas20121.tfcompat.compat.improvedbackpacks;

import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ImprovedBackpacksModule extends ModuleCore implements IHeatRecipe {

    public ImprovedBackpacksModule()
    {
        super("module_ibp", "improvedbackpacks");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ImprovedBackpacksRegistry.instance.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {

    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {

    }
}
