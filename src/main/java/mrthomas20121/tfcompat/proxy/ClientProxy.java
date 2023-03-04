package mrthomas20121.tfcompat.proxy;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.module.ModuleBase;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = TFCompat.MOD_ID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public boolean isServer() {
        return false;
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        //TFCompatRegistryHandler.getCompatList().forEach(ICompat::registerModels);
        TFCompat.getModules().forEach(ModuleBase::registerModels);
    }
}
