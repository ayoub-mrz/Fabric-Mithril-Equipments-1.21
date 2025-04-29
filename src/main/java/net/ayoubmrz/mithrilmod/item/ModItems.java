package net.ayoubmrz.mithrilmod.item;

import net.ayoubmrz.mithrilmod.MithrilMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot", new Item(new Item.Settings()));
    public static final Item RAW_MITHRIL = registerItem("raw_mithril", new Item(new Item.Settings()));

    public static final Item MITHRIL_SWORD = registerItem("mithril_sword",
            new SwordItem(ModToolMaterials.MITHRIL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 7, -2.2f))));
    public static final Item MITHRIL_PICKAXE = registerItem("mithril_pickaxe",
            new PickaxeItem(ModToolMaterials.MITHRIL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 1, -2.8f))));
    public static final Item MITHRIL_SHOVEL = registerItem("mithril_shovel",
            new ShovelItem(ModToolMaterials.MITHRIL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 1.5f, -3.0f))));
    public static final Item MITHRIL_AXE = registerItem("mithril_axe",
            new AxeItem(ModToolMaterials.MITHRIL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 9, -3f))));
    public static final Item MITHRIL_HOE = registerItem("mithril_hoe",
            new HoeItem(ModToolMaterials.MITHRIL, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MITHRIL, 0, -3f))));

    public static final Item MITHRIL_HELMET = registerItem("mithril_helmet",
            new ArmorItem(ModArmorMaterials.MITHRIL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30))));
    public static final Item MITHRIL_CHESTPLATE = registerItem("mithril_chestplate",
            new ArmorItem(ModArmorMaterials.MITHRIL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(30))));
    public static final Item MITHRIL_LEGGINGS = registerItem("mithril_leggings",
            new ArmorItem(ModArmorMaterials.MITHRIL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(30))));
    public static final Item MITHRIL_BOOTS = registerItem("mithril_boots",
            new ArmorItem(ModArmorMaterials.MITHRIL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30))));

    public static final Item MITHRIL_HORSE_ARMOR = registerItem("mithril_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.MITHRIL_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MithrilMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MithrilMod.LOGGER.info("Registering Mod Items for " + MithrilMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MITHRIL_INGOT);
            entries.add(RAW_MITHRIL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(MITHRIL_SWORD);
            entries.add(MITHRIL_AXE);
            entries.add(MITHRIL_HELMET);
            entries.add(MITHRIL_CHESTPLATE);
            entries.add(MITHRIL_LEGGINGS);
            entries.add(MITHRIL_BOOTS);
            entries.add(MITHRIL_HORSE_ARMOR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(MITHRIL_PICKAXE);
            entries.add(MITHRIL_SHOVEL);
            entries.add(MITHRIL_AXE);
            entries.add(MITHRIL_HOE);
        });
    }
}
