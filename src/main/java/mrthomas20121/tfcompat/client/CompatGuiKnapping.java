package mrthomas20121.tfcompat.client;

import mrthomas20121.tfcompat.api.Types;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.client.gui.GuiKnapping;
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
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        if (type == Types.FLINT_CLAY || type == Types.REFRACTORY_CLAY || type == Types.PORCELAIN || type == Types.CAMINITE_BLEND)
        {
            GlStateManager.color(1, 1, 1, 1);
            if(type == Types.FLINT_CLAY) mc.getTextureManager().bindTexture(GuiHandler.FLINT_CLAY_DISABLED_TEXTURE);
            else if(type == Types.REFRACTORY_CLAY) mc.getTextureManager().bindTexture(GuiHandler.REFRACTORY_CLAY_DISABLED_TEXTURE);
            else if(type == Types.PORCELAIN) mc.getTextureManager().bindTexture(GuiHandler.PORCELAIN_DISABLED_TEXTURE);
            else if(type == Types.CAMINITE_BLEND) mc.getTextureManager().bindTexture(GuiHandler.CAMINITE_BLEND_TEXTURE_DISABLED);
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