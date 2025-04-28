package net.ayoubmrz.mithrilmod.util;

import net.ayoubmrz.mithrilmod.MithrilMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_MITHRIL_TOOL = createTag("needs_mithril_tool");
        public static final TagKey<Block> INCORRECT_FOR_MITHRIL_TOOL = createTag("incorrect_for_mithril_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MithrilMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MithrilMod.MOD_ID, name));
        }
    }
}
