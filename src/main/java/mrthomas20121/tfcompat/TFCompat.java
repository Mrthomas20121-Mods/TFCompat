package mrthomas20121.tfcompat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TFCompat.MODID, name = TFCompat.NAME, version = TFCompat.VERSION)
public class TFCompat
{
    public static final String MODID = "tfcompat";
    public static final String NAME = "TFCompat";
    public static final String VERSION = "1.0.2";

    private static Logger logger;
	
    public static Logger getLog() 
    {
		return logger;
	}

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
