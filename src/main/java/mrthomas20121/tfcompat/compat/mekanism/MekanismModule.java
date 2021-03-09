package mrthomas20121.tfcompat.compat.mekanism;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.rocksalt.utils.OredictUtils;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.types.Metal;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class MekanismModule extends ModuleCore {

    public MekanismModule()
    {
        super("mekanism");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.mekanism;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new MekanismRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        OredictUtils.add("refined_glowstone", "glowstone");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
