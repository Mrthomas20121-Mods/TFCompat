package mrthomas20121.tfcompat.api;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;


/**
 * TFCompatGuiFactory Based on TFCGuiFactory.java.
 * Credit goes to the tfc devs for this class.
 */
@SideOnly(Side.CLIENT)
public class TFCompatGuiFactory implements IModGuiFactory {
        @Override
        public void initialize(Minecraft minecraftInstance) {

        }

        @Override
        public boolean hasConfigGui()
        {
            return true;
        }

        @Override
        public GuiScreen createConfigGui(GuiScreen parentScreen)
        {
            return new TFCompatModGui(parentScreen);
        }

        @Override
        public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
        {
            return null;
        }

        public static final class TFCompatModGui extends GuiConfig
        {
            public TFCompatModGui(GuiScreen parentScreen)
            {
                super(parentScreen, TFCompat.MOD_ID, TFCompat.NAME);
            }
        }
    }
