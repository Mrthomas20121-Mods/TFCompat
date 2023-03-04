package mrthomas20121.tfcompat.config;


import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.Reference;
import net.minecraftforge.common.config.Config;

import java.util.Map;
import java.util.TreeMap;

/**
 * Inspired by Pyrotech Config system
 */
@Config(modid = TFCompat.MOD_ID, name = TFCompat.MOD_ID + "/modules")
public class TFCompatConfig {

    public static Map<String, Boolean> MODULES = new TreeMap<>();

    static {
        // add modules to the map
        MODULES.put(Reference.actuallyAdditionsModule, true);
        MODULES.put(Reference.betterwithmodsModule, true);
        MODULES.put(Reference.bloodmagicModule, true);
        MODULES.put(Reference.ceramicsModule, true);
        MODULES.put(Reference.sootModule, true);
        MODULES.put(Reference.emberModule, true);
        MODULES.put(Reference.forestryModule, true);
        MODULES.put(Reference.improvedbackpacksModule, true);
        MODULES.put(Reference.ironBackpacksModule, true);
        MODULES.put(Reference.mekanismModule, true);
        MODULES.put(Reference.moreCauldronsModule, true);
        MODULES.put(Reference.techRebornModule, true);
        MODULES.put(Reference.nuclearcraftModule, true);
        MODULES.put(Reference.pyrotechModule, true);
        MODULES.put(Reference.rusticModule, true);
        MODULES.put(Reference.thaumcraftModule, true);
        MODULES.put(Reference.thermalExpansionModule, true);
    }
}
