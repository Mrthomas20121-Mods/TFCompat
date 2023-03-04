package mrthomas20121.tfcompat.client;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.Types;

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

    private static final ResourceLocation TANNED_LEATHER_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/tanned_leather_button.png");
    public static final ResourceLocation PORCELAIN_TEXTURE = new ResourceLocation(TFCompat.MOD_ID,"textures/gui/knapping/porcelain_button.png");
    public static final ResourceLocation PORCELAIN_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/porcelain_button_disabled.png");
    public static final ResourceLocation FLINT_CLAY_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/flint_clay_button.png");
    public static final ResourceLocation FLINT_CLAY_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/flint_clay_button_disabled.png");
    public static final ResourceLocation REFRACTORY_CLAY_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/refractory_clay_button.png");
    public static final ResourceLocation REFRACTORY_CLAY_DISABLED_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/refractory_clay_button_disabled.png");
    public static final ResourceLocation CAMINITE_BLEND_TEXTURE = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/caminite_blend.png");
    public static final ResourceLocation CAMINITE_BLEND_TEXTURE_DISABLED = new ResourceLocation(TFCompat.MOD_ID, "textures/gui/knapping/caminite_blend_disabled.png");

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
            case CAMINITE_BLEND:
                return new ContainerKnapping(Types.CAMINITE_BLEND, player.inventory,  OreDictionaryHelper.doesStackMatchOre(stack, "caminiteBlend") ? stack : player.getHeldItemOffhand());
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
                return new CompatGuiKnapping(container, player, Types.TANNED_LEATHER, TANNED_LEATHER_TEXTURE);
            case PORCELAIN:
                return new CompatGuiKnapping(container, player, Types.PORCELAIN, PORCELAIN_TEXTURE);
            case FLINT_CLAY:
                return new CompatGuiKnapping(container, player, Types.FLINT_CLAY, FLINT_CLAY_TEXTURE);
            case REFRACTORY_CLAY:
                return new CompatGuiKnapping(container, player, Types.REFRACTORY_CLAY, REFRACTORY_CLAY_TEXTURE);
            case CAMINITE_BLEND:
                return new CompatGuiKnapping(container, player, Types.CAMINITE_BLEND, CAMINITE_BLEND_TEXTURE);
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
        CAMINITE_BLEND,
        NULL;

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