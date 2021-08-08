package mrthomas20121.tfcompat.compat.ceramics;

import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CeramicsModule extends ModuleCore {

    KnappingType porcelain = new KnappingType(2, true);

    public CeramicsModule() {
        super("ceramics");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.ceramics;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new CeramicsRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }
}