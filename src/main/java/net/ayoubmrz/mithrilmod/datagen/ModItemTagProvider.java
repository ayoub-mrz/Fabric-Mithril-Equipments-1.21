package net.ayoubmrz.mithrilmod.datagen;

import net.ayoubmrz.mithrilmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MITHRIL_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MITHRIL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MITHRIL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MITHRIL_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MITHRIL_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MITHRIL_HELMET)
                .add(ModItems.MITHRIL_CHESTPLATE)
                .add(ModItems.MITHRIL_LEGGINGS)
                .add(ModItems.MITHRIL_BOOTS);
        
    }
}
