package net.ayoubmrz.mithrilmod.datagen;

import net.ayoubmrz.mithrilmod.block.ModBlocks;
import net.ayoubmrz.mithrilmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MITHRIL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MITHRIL_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.MITHRIL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MITHRIL, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MITHRIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MITHRIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MITHRIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MITHRIL_BOOTS));

        itemModelGenerator.register(ModItems.MITHRIL_HORSE_ARMOR, Models.GENERATED);

    }
}
