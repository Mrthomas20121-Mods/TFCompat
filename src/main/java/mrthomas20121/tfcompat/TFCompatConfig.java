package mrthomas20121.tfcompat;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TFCompatConfig {

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TFCompat.MODID))
        {
            ConfigManager.sync(TFCompat.MODID, Config.Type.INSTANCE);
        }
    }

    @Config(modid = TFCompat.MODID, name = "TFCompat")
    public static class DefaultConfig {

        @Config.LangKey("config."+TFCompat.MODID+".refinery_recipes")
        @Config.Comment("Should Thermal Refinery Recipes be made in a barrel?")
        public static boolean thermal_refinery_recipes = false;
    }
}
