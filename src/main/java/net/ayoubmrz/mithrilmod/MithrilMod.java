package net.ayoubmrz.mithrilmod;

import net.ayoubmrz.mithrilmod.block.ModBlocks;
import net.ayoubmrz.mithrilmod.item.ModItemGroups;
import net.ayoubmrz.mithrilmod.item.ModItems;
import net.ayoubmrz.mithrilmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MithrilMod implements ModInitializer {
	public static final String MOD_ID = "mithrilmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		ModWorldGeneration.generateModWorldGen();

	}
}