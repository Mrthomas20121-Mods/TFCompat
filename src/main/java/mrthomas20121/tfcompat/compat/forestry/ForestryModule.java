package mrthomas20121.tfcompat.compat.forestry;

import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ForestryModule extends ModuleCore {


    public ForestryModule()
    {
        super("forestry");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.forestry;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        this.addRegistry(new ForestryRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }
}
