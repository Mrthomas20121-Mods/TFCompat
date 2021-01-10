package mrthomas20121.tfcompat.compat.ember;

import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class EmberModule extends ModuleCore {

    public EmberModule() {
        super("embers");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new EmberRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
