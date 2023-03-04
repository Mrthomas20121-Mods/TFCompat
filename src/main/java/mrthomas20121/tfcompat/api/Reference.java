package mrthomas20121.tfcompat.api;

import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.capability.food.FoodTrait;
import net.minecraftforge.fml.common.Loader;

public class Reference {

    // modid reference
    public static String actuallyadditions = "actuallyadditions";
    public static String betterwithmods = "betterwithmods";
    public static String bloodmagic = "bloodmagic";
    public static String ceramics = "ceramics";
    public static String soot = "soot";
    public static String ember = "ember";
    public static String forestry = "forestry";
    public static String improvedbackpacks = "improvedbackpacks";
    public static String iron_backpacks = "ironbackpacks";
    public static String moreCauldrons = "morecauldrons";
    public static String mekanism = "mekanism";
    public static String nuclearcraft = "nuclearcraft";
    public static String pyrotech = "pyrotech";
    public static String rustic = "rustic";
    public static String techReborn = "techreborn";
    public static String thaumcraft = "thaumcraft";
    public static String thermalexpansion = "thermalexpansion";

    // module names
    public static String actuallyAdditionsModule = TFCompat.MOD_ID+"_"+actuallyadditions;
    public static String betterwithmodsModule = TFCompat.MOD_ID+"_"+betterwithmods;
    public static String bloodmagicModule = TFCompat.MOD_ID+"_"+bloodmagic;
    public static String ceramicsModule = TFCompat.MOD_ID+"_"+ceramics;
    public static String sootModule = TFCompat.MOD_ID+"_"+soot;
    public static String emberModule = TFCompat.MOD_ID+"_"+ember;
    public static String forestryModule = TFCompat.MOD_ID+"_"+forestry;
    public static String improvedbackpacksModule = TFCompat.MOD_ID+"_"+improvedbackpacks;
    public static String ironBackpacksModule = TFCompat.MOD_ID+"_"+iron_backpacks;
    public static String mekanismModule = TFCompat.MOD_ID+"_"+mekanism;
    public static String moreCauldronsModule = TFCompat.MOD_ID+"_"+moreCauldrons;
    public static String nuclearcraftModule = TFCompat.MOD_ID+"_"+nuclearcraft;
    public static String pyrotechModule = TFCompat.MOD_ID+"_"+pyrotech;
    public static String rusticModule = TFCompat.MOD_ID+"_"+rustic;
    public static String techRebornModule = TFCompat.MOD_ID+"_"+techReborn;
    public static String thaumcraftModule = TFCompat.MOD_ID+"_"+thaumcraft;
    public static String thermalExpansionModule = TFCompat.MOD_ID+"_"+thermalexpansion;

    public static boolean isModLoaded(String modname) {
        return Loader.isModLoaded(modname);
    }

    public static FoodTrait cookedTrait = new FoodTrait("cooked", 0.5F);
}
