package mrthomas20121.tfcompat.compat.bloodmagic;

import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BloodMagicModule extends ModuleCore {

    public BloodMagicModule() {
        super("bloodmagic");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep());
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new BloodMagicRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
