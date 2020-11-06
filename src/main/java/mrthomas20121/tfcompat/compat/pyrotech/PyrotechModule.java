package mrthomas20121.tfcompat.compat.pyrotech;

import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PyrotechModule extends ModuleCore {

    public PyrotechModule()
    {
        super("pyrotech");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new PyrotechRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
       getRegistry().init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {}
}
