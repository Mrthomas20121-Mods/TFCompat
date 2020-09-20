package mrthomas20121.tfcompat.library;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public abstract class ModuleCore {

    private String name;
    private String dep;

    public ModuleCore(String name, String dep)
    {
        this.name = name;
        this.dep = dep;
    }

    public String getName() {
        return name;
    }

    public String getDep()
    {
        return this.dep;
    }

    public abstract void preInit(FMLPreInitializationEvent event);

    public abstract void init(FMLInitializationEvent event);

    public abstract void postInit(FMLPostInitializationEvent event);

    public abstract void initRecipes(IForgeRegistry<IRecipe> r);
}
