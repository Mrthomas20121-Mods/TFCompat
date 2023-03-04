package mrthomas20121.tfcompat;

import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.types.IArmorMaterialTFC;
import net.dries007.tfc.objects.ArmorMaterialTFC;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterialsTFCompat {
    public static final IArmorMaterialTFC thaumium = new ArmorMaterialTFC(EnumHelper.addArmorMaterial("thaumium", TFCompat.MOD_ID + ":thaumium", 33, new int[] {1, 4, 5, 2}, 120, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F), 20, 20, 13.2f);
    public static final IArmorMaterialTFC signalum = new ArmorMaterialTFC(EnumHelper.addArmorMaterial("signalum", TFCompat.MOD_ID + ":signalum", 40, new int[] {2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F), 25, 30, 16.5f);
    public static final IArmorMaterialTFC lumium = new ArmorMaterialTFC(EnumHelper.addArmorMaterial("enderium", TFCompat.MOD_ID + ":enderium", 40, new int[] {2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F), 25, 30, 16.5f);
    public static final IArmorMaterialTFC enderium = new ArmorMaterialTFC(EnumHelper.addArmorMaterial("enderium", TFCompat.MOD_ID + ":enderium", 40, new int[] {2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F), 40, 20, 17.5f);
}
