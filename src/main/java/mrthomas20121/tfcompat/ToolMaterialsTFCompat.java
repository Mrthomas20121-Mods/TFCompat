package mrthomas20121.tfcompat;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialsTFCompat {
    public static final Item.ToolMaterial thaumium = EnumHelper.addToolMaterial("tfcompat_thaumium", 2, 2200, 12, 4.9f, 120);
    public static final Item.ToolMaterial signalum = EnumHelper.addToolMaterial("tfcompat_signalum", 2, 3400, 15, 5.75f, 10);
    public static final Item.ToolMaterial lumium = EnumHelper.addToolMaterial("tfcompat_lumium", 2, 3400, 15, 5.75f, 11);
    public static final Item.ToolMaterial enderium = EnumHelper.addToolMaterial("tfcompat_enderium", 2, 5400, 15, 5.75f, 22);
}
