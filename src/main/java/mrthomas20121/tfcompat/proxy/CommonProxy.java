package mrthomas20121.tfcompat.proxy;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TFCompat.MOD_ID)
public class CommonProxy {

    public boolean isServer() {
        return true;
    }

    public boolean isClient() {
        return !isServer();
    }

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TFCompat.MOD_ID))
        {
            ConfigManager.sync(TFCompat.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
