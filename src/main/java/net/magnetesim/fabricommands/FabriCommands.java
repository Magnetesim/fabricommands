package net.magnetesim.fabricommands;

import net.fabricmc.api.ModInitializer;
import net.magnetesim.fabricommands.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabriCommands implements ModInitializer {
	public static final String MOD_ID = "fabricommands";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
