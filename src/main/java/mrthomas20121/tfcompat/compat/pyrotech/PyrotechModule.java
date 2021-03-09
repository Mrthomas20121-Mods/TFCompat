package mrthomas20121.tfcompat.compat.pyrotech;

import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PyrotechModule extends ModuleCore {

    public PyrotechModule()
    {
        super("pyrotech");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.pyrotech;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new PyrotechRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {}
}
