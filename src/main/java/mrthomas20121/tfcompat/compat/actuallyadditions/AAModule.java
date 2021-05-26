package mrthomas20121.tfcompat.compat.actuallyadditions;

import mrthomas20121.rocksalt.utils.OreUtils;
import mrthomas20121.rocksalt.utils.VeinLoader;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AAModule extends ModuleCore {

    public AAModule()
    {
        super("actuallyadditions");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.actually_additions;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        //OreUtils.registerOre("blackquartz", false, 5d, 5d);
        //VeinLoader.preInit(TFCompat.MOD_ID, event.getModConfigurationDirectory(), "tfcompat_aa_ores.json");
        addRegistry(new AARegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
