package mrthomas20121.tfcompat.compat.ember.addons;

import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class SootModule extends ModuleCore {

    public SootModule() {
        super("soot");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.soot && TFCompatConfig.DefaultConfig.modules.ember;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new SootRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }


}
