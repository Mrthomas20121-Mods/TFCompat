package mrthomas20121.tfcompat.modules.thermal;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraftforge.common.config.Config;

@Config(modid = TFCompat.MOD_ID, name = TFCompat.MOD_ID+"/thermal")
public class ThermalConfig {

    @Config.Comment("Enable/Disable Enderium TFCMetal")
    public static boolean enderium = true;
    @Config.Comment("Enable/Disable Signalum TFC Metal")
    public static boolean signalum = true;
    @Config.Comment("Enable/Disable Lumium TFC Metal")
    public static boolean lumium = true;

    @Config.Comment("Enable/Disable Fluid Transposer Recipes")
    public static boolean fluidTransposerRecipes = true;
    @Config.Comment("Enable/Disable Pyrolysis Augment Recipes")
    public static boolean pyrolysisRecipes = true;
    @Config.Comment("Enable/Disable Lapidary Augment Recipes")
    public static boolean lapidaryRecipes = true;
    @Config.Comment("Enable/Disable extruder Recipes")
    public static boolean extruderRecipes = true;
    @Config.Comment("Enable/Disable Precipitator Recipes")
    public static boolean precipitatorRecipes = true;
    @Config.Comment("Enable/Disable Sawmill Recipes")
    public static boolean sawmillRecipes = true;
    @Config.Comment("Enable/Disable Redstone Furnace Recipes")
    public static boolean redstoneFurnaceRecipes = true;
    @Config.Comment("Enable/Disable Refinery Recipes")
    public static boolean refineryRecipes = true;
    @Config.Comment("Enable/Disable Pulverizer Recipes")
    public static boolean pulverizerRecipes = true;
}
