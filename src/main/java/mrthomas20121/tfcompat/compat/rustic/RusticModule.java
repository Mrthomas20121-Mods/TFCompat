package mrthomas20121.tfcompat.compat.rustic;

import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class RusticModule extends ModuleCore {

    public RusticModule()
    {
        super("rustic");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new RusticRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        this.getRegistry().init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
