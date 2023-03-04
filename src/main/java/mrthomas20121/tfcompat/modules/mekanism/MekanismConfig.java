package mrthomas20121.tfcompat.modules.mekanism;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraftforge.common.config.Config;

@Config(modid = TFCompat.MOD_ID, name = TFCompat.MOD_ID+"/mekanism")
public class MekanismConfig {

    @Config.Comment("Enable/Disable Sawmill Recipes added by TFCompat")
    public static boolean sawmillRecipes = true;

    @Config.Comment("Enable/Disable Crusher Recipes added by TFCompat")
    public static boolean crusherRecipes = true;

    @Config.Comment("Enable/Disable Evaporation Recipes added by TFCompat")
    public static boolean evaporationRecipes = true;
}
