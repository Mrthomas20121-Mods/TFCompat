package mrthomas20121.tfcompat.modules.nuclearcraft;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraftforge.common.config.Config;

@Config(modid = TFCompat.MOD_ID, name = TFCompat.MOD_ID+"/nuclearcraft_compat")
public class NuclearcraftModConfig {

    @Config.Comment("Disable/Enable Melting Recipes added By TFCompat")
    public static boolean meltingRecipes = true;
    @Config.Comment("Disable/Enable Water Source Recipes added By TFCompat")
    public static boolean waterSourceRecipes = true;
    @Config.Comment("Disable/Enable Supercooler Recipes added By TFCompat")
    public static boolean supercoolerRecipes = true;
}
