package mrthomas20121.tfcompat.library;

import com.codetaylor.mc.athenaeum.util.Properties;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.objects.items.itemblock.ItemBlockTFC;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;

public class ItemBlockPotery extends ItemBlockTFC {

    public ItemBlockPotery(Block block)
    {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setTranslationKey(block.getTranslationKey());
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new ItemHeatHandler(nbt, 1.0F, 1599.0F);
    }
}
