package mrthomas20121.tfcompat.client;

import mrthomas20121.tfcompat.api.knapping.Types;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.client.button.GuiButtonKnapping;
import net.dries007.tfc.client.gui.GuiKnapping;
import net.dries007.tfc.objects.container.ContainerKnapping;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class CompatGuiKnapping extends GuiKnapping {

    private KnappingType type = null;

    public CompatGuiKnapping(Container container, EntityPlayer player, KnappingType type, ResourceLocation buttonTexture)
    {
        super(container, player, type, buttonTexture);
        this.type = type;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        // Check if the container has been updated
        if (inventorySlots instanceof ContainerKnapping && ((ContainerKnapping) inventorySlots).requiresReset)
        {
            for (GuiButton button : buttonList)
            {
                if (button instanceof GuiButtonKnapping)
                {
                    button.visible = ((ContainerKnapping) inventorySlots).getSlotState(button.id);
                }
            }
            ((ContainerKnapping) inventorySlots).requiresReset = false;
        }
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        if (type == Types.FLINT_CLAY || type == Types.REFRACTORY_CLAY || type == Types.PORCELAIN)
        {
            GlStateManager.color(1, 1, 1, 1);
            mc.getTextureManager().bindTexture(type == Types.FLINT_CLAY ? GuiHandler.FLINT_CLAY_DISABLED_TEXTURE : type == Types.REFRACTORY_CLAY ? GuiHandler.REFRACTORY_CLAY_DISABLED_TEXTURE : GuiHandler.PORCELAIN_DISABLED_TEXTURE);
            for (GuiButton button : buttonList)
            {
                if (!button.visible)
                {
                    Gui.drawModalRectWithCustomSizedTexture(button.x, button.y, 0, 0, 16, 16, 16, 16);
                }
            }
        }
    }
}
