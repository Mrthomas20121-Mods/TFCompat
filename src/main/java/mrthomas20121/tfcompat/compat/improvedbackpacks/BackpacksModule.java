package mrthomas20121.tfcompat.compat.improvedbackpacks;

import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BackpacksModule extends ModuleCore {

    public BackpacksModule()
    {
        super("improvedbackpacks");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.improved_backpacks;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        this.addRegistry(new BackpacksRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        this.getRegistry().init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
