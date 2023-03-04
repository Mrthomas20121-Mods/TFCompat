package mrthomas20121.tfcompat.modules.thaumcraft;

import mrthomas20121.tfcompat.ArmorMaterialsTFCompat;
import mrthomas20121.tfcompat.ToolMaterialsTFCompat;
import mrthomas20121.tfcompat.api.module.ModuleRegistry;
import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.metal.ItemMetalShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;
import thaumcraft.api.items.ItemsTC;

public class ThaumcraftModRegistry extends ModuleRegistry {

    public static final ResourceLocation thaumium = new ResourceLocation(TerraFirmaCraft.MOD_NAME, "thaumium");
    public static ResourceLocation void_metal = new ResourceLocation(TerraFirmaCraft.MOD_ID, "void_metal");

    @Override
    public void init() {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of("gemCinnabar"), () -> new ItemHeatHandler(null, 0.35f, 600));
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(ItemsTC.quicksilver), () -> new ItemHeatHandler(null, 0.35f, 600));
    }

    @SubscribeEvent
    public static void registerMetals(TFCRegistryEvent.RegisterPreBlock<Metal> event) {
        IForgeRegistry<Metal> r = event.getRegistry();

        if(ThaumcraftModConfig.thaumium) {
            r.register(new Metal(thaumium, Metal.Tier.TIER_IV, true, 1500, 1300, 0x5A4B8B, ToolMaterialsTFCompat.thaumium, ArmorMaterialsTFCompat.thaumium));
        }
        if(ThaumcraftModConfig.void_metal) {
            r.register(new Metal(void_metal, Metal.Tier.TIER_VI, true, 1500, 1300, 0x2D1847, null, null));
        }
    }

    @SubscribeEvent
    public static void registerAspects(AspectRegistryEvent event) {
        for(Metal metal: TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable()) {
                int tier = metal.getTier().ordinal();
                if(metal.isToolMetal()) {
                    ItemStack shield = new ItemStack(ItemMetalShield.get(metal, Metal.ItemType.SHIELD));
                    AspectList list = new AspectList();
                    list.add(Aspect.PROTECT, 20);
                    event.register.registerObjectTag(shield, list);

                }
                ItemStack lamp = new ItemStack(ItemMetalShield.get(metal, Metal.ItemType.LAMP));
                AspectList list = new AspectList();
                list.add(Aspect.LIGHT, 10).add(Aspect.SENSES, 5);
                event.register.registerObjectTag(lamp, list);

                Metal.ItemType[] types = { Metal.ItemType.SCRAP, Metal.ItemType.DOUBLE_INGOT, Metal.ItemType.DOUBLE_SHEET};
                for(Metal.ItemType type: types) {
                    AspectList metal_list = new AspectList();
                    ItemStack stack = new ItemStack(ItemMetal.get(metal, type));
                    metal_list.add(Aspect.METAL, 2+tier);
                    event.register.registerObjectTag(stack, metal_list);
                }
            }
        }
    }
}
