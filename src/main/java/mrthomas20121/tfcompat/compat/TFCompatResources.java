package mrthomas20121.tfcompat.compat;

import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = TFCompat.MODID)
public class TFCompatResources {

    // metals

    // better with mods metals
    public static ResourceLocation soulforged_steel = new ResourceLocation(TerraFirmaCraft.MOD_ID, "soulforged_steel");
    // mekanism metals
    public static ResourceLocation refined_glowstone = new ResourceLocation(TerraFirmaCraft.MOD_ID, "refined_glowstone");
    public static ResourceLocation refined_obsidian = new ResourceLocation(TerraFirmaCraft.MOD_ID, "refined_obsidian");
    // thermal metals
    public static ResourceLocation enderium_base = new ResourceLocation(TerraFirmaCraft.MOD_ID, "enderium_base");
    public static ResourceLocation enderium = new ResourceLocation(TerraFirmaCraft.MOD_ID, "enderium");
    public static ResourceLocation signalum = new ResourceLocation(TerraFirmaCraft.MOD_ID, "signalum");
    public static ResourceLocation lumium = new ResourceLocation(TerraFirmaCraft.MOD_ID, "lumium");
    // thaumcraft metals
    public static ResourceLocation thaumium = new ResourceLocation(TerraFirmaCraft.MOD_ID, "thaumium");
    public static ResourceLocation void_metal = new ResourceLocation(TerraFirmaCraft.MOD_ID, "void_metal");
    // nuclearcraft_overhauled metals
    public static ResourceLocation hard_carbon = new ResourceLocation(TerraFirmaCraft.MOD_ID, "hard_carbon");
    // tech reborn metals
    public static ResourceLocation refined_iron = new ResourceLocation(TerraFirmaCraft.MOD_ID, "refined_iron");

    @SubscribeEvent
    public static void registerMetals(TFCRegistryEvent.RegisterPreBlock<Metal> event) {
        IForgeRegistry<Metal> r = event.getRegistry();

        // i don't like using "mod conditional" to register metals but it's either that or i register every metals

        if(Loader.isModLoaded("bwm")) {
            r.register(new Metal(soulforged_steel, Metal.Tier.TIER_IV, true, 1500, 1300, 0x0, null, null));
        }
        if(Loader.isModLoaded("mekanism")) {
            r.registerAll(
                    new Metal(refined_glowstone, Metal.Tier.TIER_VI, true, 1500, 1300, 0x0, null, null),
                    new Metal(refined_obsidian, Metal.Tier.TIER_VI, true, 1500, 1300, 0x0, null, null)
            );
        }
        if(Loader.isModLoaded("techreborn")) {
            r.registerAll(new Metal(refined_iron,  Metal.Tier.TIER_IV, true, 3000, 1900, 0x0, null, null));
        }

        if(Loader.isModLoaded("thaumcraft")) {
            r.registerAll(
                    new Metal(void_metal, Metal.Tier.TIER_VI, true, 1500, 1300, 0x2D1847, null, null),
                    new Metal(thaumium, Metal.Tier.TIER_IV, true, 1500, 1300, 0x5A4B8B, ToolMaterialsTFCompat.thaumium, ArmorMaterialsTFCompat.thaumium)
            );
        }

        if(Loader.isModLoaded("thermalexpansion")) {
            r.registerAll(
                    new Metal(enderium_base, Metal.Tier.TIER_0, false, 1000, 1300, 0x5F96CE, null, null),
                    new Metal(enderium, Metal.Tier.TIER_VI, true, 1300, 1200, 0xA13800, ToolMaterialsTFCompat.enderium, ArmorMaterialsTFCompat.enderium),
                    new Metal(signalum, Metal.Tier.TIER_V, true, 1300, 1200, 0xA13800, ToolMaterialsTFCompat.signalum, ArmorMaterialsTFCompat.signalum),
                    new Metal(lumium, Metal.Tier.TIER_V, true, 1300, 1200, 0xFFE46A, ToolMaterialsTFCompat.lumium, ArmorMaterialsTFCompat.lumium)
            );
        }
    }
}
