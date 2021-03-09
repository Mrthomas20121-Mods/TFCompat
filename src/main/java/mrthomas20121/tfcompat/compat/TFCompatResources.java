package mrthomas20121.tfcompat.compat;

import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class TFCompatResources {

    // metals

    // better with mods metals
    public static ResourceLocation soulforged_steel = new ResourceLocation(TerraFirmaCraft.MOD_ID, "soulforged_steel");
    // mekanism metals
    public static ResourceLocation refined_glowstone = new ResourceLocation(TerraFirmaCraft.MOD_ID, "refined_glowstone");
    public static ResourceLocation refined_obsidian = new ResourceLocation(TerraFirmaCraft.MOD_ID, "refined_obsidian");
    // thermal metals
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


    public static void registerMetals(TFCRegistryEvent.RegisterPreBlock<Metal> event) {
        IForgeRegistry<Metal> r = event.getRegistry();
        r.registerAll(
                // register metals here
                new Metal(soulforged_steel, Metal.Tier.TIER_IV, true, 1500, 1300, 0x0, null, null),
                new Metal(refined_glowstone, Metal.Tier.TIER_VI, true, 1500, 1300, 0x0, null, null),
                new Metal(refined_obsidian, Metal.Tier.TIER_VI, true, 1500, 1300, 0x0, null, null),
                new Metal(refined_iron,  Metal.Tier.TIER_IV, true, 3000, 1900, 0x0, null, null),
                new Metal(void_metal, Metal.Tier.TIER_VI, true, 1500, 1300, 0x2D1847, null, null),
                new Metal(thaumium, Metal.Tier.TIER_IV, true, 1500, 1300, 0x5A4B8B, ToolMaterialsTFCompat.thaumium, ArmorMaterialsTFCompat.thaumium)
        );
    }
}
