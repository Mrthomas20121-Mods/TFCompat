package mrthomas20121.tfcompat.modules.thaumcraft;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraftforge.common.config.Config;

@Config(modid = TFCompat.MOD_ID, name = TFCompat.MOD_ID+"/thaumcraft")
public class ThaumcraftModConfig {

    @Config.Comment("Enable/Disable thaumium metal")
    public static boolean thaumium = true;

    @Config.Comment("Enable/Disable void_metal metal")
    public static boolean void_metal = true;
}
