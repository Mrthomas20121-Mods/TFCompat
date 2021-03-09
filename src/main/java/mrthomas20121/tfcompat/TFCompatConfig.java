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

    @Config(modid = TFCompat.MODID, name = TFCompat.MODID+"/"+TFCompat.MODID)
    public static class DefaultConfig {

        @Config.Comment("Modules Settings")
        public static final ModuleSettings modules = new ModuleSettings();

        @Config.Comment("TFC Addons Compats.\nBasically a config option for those who don't want cross compatibility between other tfc addons and the mods this support.")
        public static final TFCAddonsSettings tfc_addons = new TFCAddonsSettings();

        @Config.Comment("Thermal Module Settings")
        public static final Thermal thermal = new Thermal();

        @Config.Comment("Pyrotech Module Settings")
        public static final Pyrotech pyrotech = new Pyrotech();

        @Config.Comment("Techreborn Module Settings")
        public static final Techreborn techreborn = new Techreborn();

        @Config.Comment("Mekanism Module Settings")
        public static final Mekanism mekanism = new Mekanism();

        @Config.Comment("Betterwithmods Module Settings")
        public static final BWM betterwithmods = new BWM();
    }

    public static class ModuleSettings {

        @Config.Comment("Enable/Disable Actually Addition Module")
        public boolean actually_additions = true;

        @Config.Comment("Enable/Disable Better With Mods Module")
        public boolean better_with_mods = true;

        @Config.Comment("Enable/Disable Ceramics Module")
        public boolean ceramics = true;

        @Config.Comment("Enable/Disable Ember Module")
        public boolean ember = true;

        @Config.Comment("Enable/Disable Soot Module. Won't be Loaded if the Ember Module is not loaded")
        public boolean soot = true;

        @Config.Comment("Enable/Disable Forestry Module.")
        public boolean forestry = true;

        @Config.Comment("Enable/Disable Improved Backpacks Module")
        public boolean improved_backpacks = true;

        @Config.Comment("Enable/Disable Iron Backpacks Module")
        public boolean iron_backpacks = true;

        @Config.Comment("Enable/Disable Mekanism Module")
        public boolean mekanism = true;

        @Config.Comment("Enable/Disable Pyrotech Module")
        public boolean pyrotech = true;

        @Config.Comment("Enable/Disable Rustic Module")
        public boolean rustic = true;

        @Config.Comment("Enable/Disable Tech Reborn Module")
        public boolean tech_reborn = true;

        @Config.Comment("Enable/Disable Thaumcraft Module")
        public boolean thaumcraft = true;

        @Config.Comment("Enable/Disable Thermal Module")
        public boolean thermal = true;
    }

    public static class TFCAddonsSettings {

        @Config.Comment("Enable/Disable TFC Aged Drinks Compat with other mods")
        public boolean tfc_aged_drinks = true;

        @Config.Comment("Enable/Disable TFC Drying Rack Compat with other mods")
        public boolean tfc_drying_rack = true;

        @Config.Comment("Enable/Disable Firmalife Compat with other mods")
        public boolean firmalife = true;

        @Config.Comment("Enable/Disable TFC Tech Compat with other mods")
        public boolean tfc_tech = true;
    }

    public static class Thermal {
        @Config.Comment("Should Thermal Refinery Recipes be made in a barrel?")
        public boolean thermal_refinery_recipes = false;

        @Config.Comment("Should TFC and/Rocks be made in an extruder?")
        public boolean extruder = true;

        @Config.Comment("Enable Precipitator recipes.")
        public boolean precipitator = true;

        @Config.Comment("Enable Pulverizer recipes.")
        public boolean pulverizer = true;

        @Config.Comment("Enable Sawmill recipes.")
        public boolean sawmill = true;

        @Config.Comment("Enable Redstone Furnace recipes.")
        public boolean redstone_furnace = true;
    }

    public static class Pyrotech {

        @Config.Comment("Register TFC Hammers as valid Pyrotech Hammers.")
        public boolean hammer = true;

        @Config.Comment("Enable Pyrotech anvil recipes.")
        public boolean anvil = true;

        @Config.Comment("Enable Soaking Pot recipes.")
        public boolean soaking_pot = true;

        @Config.Comment("Enable Compacting Bin recipes.")
        public boolean compacting_bin = true;

        @Config.Comment("Enable Stone Oven recipes.")
        public boolean stone_oven = true;

        @Config.Comment("Enable Brick Oven recipes.")
        public boolean brick_oven = true;

    }

    public static class Techreborn {

        @Config.Comment("Enable sawmill recipes.")
        public boolean sawmill = true;

        @Config.Comment("Enable wiremill recipes.")
        public boolean wiremill = true;

        @Config.Comment("Enable grinder recipes.")
        public boolean grinder = true;

        @Config.Comment("Enable extractor recipes.")
        public boolean extractor = true;

        @Config.Comment("Enable compressor recipes.")
        public boolean compressor = true;

        @Config.Comment("Enable rolling machine recipes.")
        public boolean rollingmachine = true;
    }

    public static class Mekanism {

        @Config.Comment("Enable sawmill recipes.")
        public boolean sawmill = true;

        @Config.Comment("Enable crusher recipes.")
        public boolean crusher = true;

        @Config.Comment("Enable evaporation recipes.")
        public boolean evaporation = true;
    }

    public static class BWM {
        @Config.Comment("Enable millstone recipes.")
        public boolean millstone = true;

        @Config.Comment("Enable saw recipes.")
        public boolean saw = true;

        @Config.Comment("Enable cauldron recipes.")
        public boolean cauldron = true;
    }
}
