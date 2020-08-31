package mrthomas20121.tfcompat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TFCompat.MODID, name = TFCompat.NAME, version = TFCompat.VERSION, dependencies = TFCompat.DEPENDENCIES)
public class TFCompat
{
    public static final String MODID = "tfcompat";
    public static final String NAME = "TFCompat";
    public static final String VERSION = "1.1.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,);"
            + "required-after:rocksalt@[1.0.1,);"
            + "required-after:tfc;"
            + "required-after:tfcmetallum@[1.3.0,);"
            + "required-after:tfctech@[1.2.13,);"
            + "after:betterwithmods;"
            + "after:pyrotech;"
            + "after:mekanism;"
            + "after:improvedbackpacks;"
            + "after:thermalexpansion;"
            + "after:thaumcraft;";

    private static Logger logger;
	
    public static Logger getLog() 
    {
		return logger;
	}

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        Registry.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Registry.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Registry.postInit();
    }
}
