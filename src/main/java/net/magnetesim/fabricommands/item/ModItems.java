package net.magnetesim.fabricommands.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.magnetesim.fabricommands.FabriCommands;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot", new Item(new FabricItemSettings()
            .group(ItemGroup.MISC)
            .maxCount(16)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FabriCommands.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FabriCommands.LOGGER.info("Registering Mod Items for " + FabriCommands.MOD_ID);
    }
}
