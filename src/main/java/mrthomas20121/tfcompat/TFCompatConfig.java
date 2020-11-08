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

        @Config.Comment("Thermal Module Settings")
        @Config.LangKey("config."+TFCompat.MODID+".thermal")
        public static final Thermal thermal = new Thermal();

        @Config.Comment("Pyrotech Module Settings")
        @Config.LangKey("config."+TFCompat.MODID+".pyrotech")
        public static final Pyrotech pyrotech = new Pyrotech();

        @Config.Comment("Techreborn Module Settings")
        @Config.LangKey("config."+TFCompat.MODID+".techreborn")
        public static final Techreborn techreborn = new Techreborn();

        @Config.Comment("Mekanism Module Settings")
        @Config.LangKey("config."+TFCompat.MODID+".mekanism")
        public static final Mekanism mekanism = new Mekanism();

        @Config.Comment("Betterwithmods Module Settings")
        @Config.LangKey("config."+TFCompat.MODID+".bwm")
        public static final BWM betterwithmods = new BWM();
    }

    public static class Thermal {
        @Config.LangKey("config."+TFCompat.MODID+".thermal.refinery_recipes")
        @Config.Comment("Should Thermal Refinery Recipes be made in a barrel?")
        public boolean thermal_refinery_recipes = false;

        @Config.LangKey("config."+TFCompat.MODID+".thermal.extruder")
        @Config.Comment("Should TFC and/Rocks be made in an extruder?")
        public boolean extruder = true;

        @Config.LangKey("config."+TFCompat.MODID+".thermal.precipitator")
        @Config.Comment("Enable Precipitator recipes.")
        public boolean precipitator = true;

        @Config.LangKey("config."+TFCompat.MODID+".thermal.pulverizer")
        @Config.Comment("Enable Pulverizer recipes.")
        public boolean pulverizer = true;

        @Config.LangKey("config."+TFCompat.MODID+".thermal.sawmill")
        @Config.Comment("Enable Sawmill recipes.")
        public boolean sawmill = true;

        @Config.LangKey("config."+TFCompat.MODID+".thermal.redstone_furnace")
        @Config.Comment("Enable Redstone Furnace recipes.")
        public boolean redstone_furnace = true;
    }

    public static class Pyrotech {

        @Config.LangKey("config."+TFCompat.MODID+".pyrotech.hammer")
        @Config.Comment("Register TFC Hammers as valid Pyrotech Hammers.")
        public boolean hammer = true;

        @Config.LangKey("config."+TFCompat.MODID+".pyrotech.anvil")
        @Config.Comment("Enable Pyrotech anvil recipes.")
        public boolean anvil = true;

        @Config.LangKey("config."+TFCompat.MODID+".pyrotech.soaking_pot")
        @Config.Comment("Enable Soaking Pot recipes.")
        public boolean soaking_pot = true;

        @Config.LangKey("config."+TFCompat.MODID+".pyrotech.compacting_bin")
        @Config.Comment("Enable Compacting Bin recipes.")
        public boolean compacting_bin = true;

        @Config.LangKey("config."+TFCompat.MODID+".pyrotech.stone_oven")
        @Config.Comment("Enable Stone Oven recipes.")
        public boolean stone_oven = true;

        @Config.LangKey("config."+TFCompat.MODID+".pyrotech.brick_oven")
        @Config.Comment("Enable Brick Oven recipes.")
        public boolean brick_oven = true;

    }

    public static class Techreborn {

        @Config.LangKey("config."+TFCompat.MODID+".techreborn.sawmill")
        @Config.Comment("Enable sawmill recipes.")
        public boolean sawmill = true;

        @Config.LangKey("config."+TFCompat.MODID+".techreborn.wiremill")
        @Config.Comment("Enable wiremill recipes.")
        public boolean wiremill = true;

        @Config.LangKey("config."+TFCompat.MODID+".techreborn.grinder")
        @Config.Comment("Enable grinder recipes.")
        public boolean grinder = true;

        @Config.LangKey("config."+TFCompat.MODID+".techreborn.extractor")
        @Config.Comment("Enable extractor recipes.")
        public boolean extractor = true;

        @Config.LangKey("config."+TFCompat.MODID+".techreborn.compressor")
        @Config.Comment("Enable compressor recipes.")
        public boolean compressor = true;

        @Config.LangKey("config."+TFCompat.MODID+".techreborn.rollingmachine")
        @Config.Comment("Enable rolling machine recipes.")
        public boolean rollingmachine = true;
    }

    public static class Mekanism {
        @Config.LangKey("config."+TFCompat.MODID+".mekanism.sawmill")
        @Config.Comment("Enable sawmill recipes.")
        public boolean sawmill = true;

        @Config.LangKey("config."+TFCompat.MODID+".mekanism.crusher")
        @Config.Comment("Enable crusher recipes.")
        public boolean crusher = true;

        @Config.LangKey("config."+TFCompat.MODID+".mekanism.evaporation")
        @Config.Comment("Enable evaporation recipes.")
        public boolean evaporation = true;
    }

    public static class BWM {
        @Config.LangKey("config."+TFCompat.MODID+".bwm.millstone")
        @Config.Comment("Enable millstone recipes.")
        public boolean millstone = true;

        @Config.LangKey("config."+TFCompat.MODID+".bwm.saw")
        @Config.Comment("Enable saw recipes.")
        public boolean saw = true;

        @Config.LangKey("config."+TFCompat.MODID+".bwm.cauldron")
        @Config.Comment("Enable cauldron recipes.")
        public boolean cauldron = true;
    }
}
