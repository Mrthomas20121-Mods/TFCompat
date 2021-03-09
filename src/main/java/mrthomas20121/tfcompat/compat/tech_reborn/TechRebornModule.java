package mrthomas20121.tfcompat.compat.tech_reborn;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TechRebornModule extends ModuleCore {

    public TechRebornModule()
    {
        super("techreborn");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.tech_reborn;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new TechRebornRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
