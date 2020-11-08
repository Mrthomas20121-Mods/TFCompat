package mrthomas20121.tfcompat.client;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;

import net.dries007.tfc.client.gui.*;
import net.dries007.tfc.objects.container.*;

import net.dries007.tfc.util.OreDictionaryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class GuiHandler implements IGuiHandler {

    private static final ResourceLocation TANNED_LEATHER_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/tanned_leather_button.png");
    private static final ResourceLocation PORCELAIN_TEXTURE = new ResourceLocation("ceramics:textures/blocks/porcelain_raw.png");
    private static final ResourceLocation FLINT_CLAY_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/flint_clay_button.png");
    private static final ResourceLocation FLINT_CLAY_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/flint_clay_button_disabled.png");
    private static final ResourceLocation REFRACTORY_CLAY_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/refractory_clay_button.png");
    private static final ResourceLocation REFRACTORY_CLAY_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MODID, "textures/gui/knapping/refractory_clay_button.png");

    public static void openGui(World world, BlockPos pos, EntityPlayer player, Type type)
    {
        player.openGui(TFCompat.instance, type.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
    }

    public static void openGui(World world, EntityPlayer player, Type type)
    {
        player.openGui(TFCompat.instance, type.ordinal(), world, 0, 0, 0);
    }

    @Override
    @Nullable
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        ItemStack stack = player.getHeldItemMainhand();
        Type type = Type.valueOf(ID);
        switch (type)
        {
            case TANNED_LEATHER:
                return new ContainerKnapping(Types.TANNED_LEATHER, player.inventory,  OreDictionaryHelper.doesStackMatchOre(stack, "tannedLeather") ? stack : player.getHeldItemOffhand());
            case PORCELAIN:
                return new ContainerKnapping(Types.PORCELAIN, player.inventory,  OreDictionaryHelper.doesStackMatchOre(stack, "clayPorcelain") ? stack : player.getHeldItemOffhand());
            case FLINT_CLAY:
                return new ContainerKnapping(Types.FLINT_CLAY, player.inventory,  OreDictionaryHelper.doesStackMatchOre(stack, "clayFlint") ? stack : player.getHeldItemOffhand());
            case REFRACTORY_CLAY:
                return new ContainerKnapping(Types.REFRACTORY_CLAY, player.inventory,  OreDictionaryHelper.doesStackMatchOre(stack, "clayRefractory") ? stack : player.getHeldItemOffhand());
            default:
                return null;
        }
    }

    @Override
    @Nullable
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Container container = getServerGuiElement(ID, player, world, x, y, z);
        Type type = Type.valueOf(ID);
        switch (type)
        {
            case TANNED_LEATHER:
                return new GuiKnapping(container, player, Types.TANNED_LEATHER, TANNED_LEATHER_TEXTURE);
            case PORCELAIN:
                return new GuiKnapping(container, player, Types.PORCELAIN, PORCELAIN_TEXTURE);
            case FLINT_CLAY:
                return new GuiKnapping(container, player, Types.FLINT_CLAY, FLINT_CLAY_TEXTURE);
            case REFRACTORY_CLAY:
                return new GuiKnapping(container, player, Types.REFRACTORY_CLAY, REFRACTORY_CLAY_TEXTURE);
            default :
                return null;
        }
    }

    public enum Type
    {
        TANNED_LEATHER,
        PORCELAIN,
        FLINT_CLAY,
        REFRACTORY_CLAY,
        NULL; // This is special, it is a non-null null.

        private static final Type[] values = values();

        @Nonnull
        public static Type valueOf(int id)
        {
            while (id >= values.length) id -= values.length;
            while (id < 0) id += values.length;
            return values[id];
        }
    }
}