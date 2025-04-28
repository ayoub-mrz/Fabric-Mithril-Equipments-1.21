package net.ayoubmrz.mithrilmod.datagen;

import net.ayoubmrz.mithrilmod.block.ModBlocks;
import net.ayoubmrz.mithrilmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> MITHRIL_SMELTABLES = List.of(ModItems.RAW_MITHRIL, ModBlocks.MITHRIL_ORE,
                ModBlocks.MITHRIL_DEEPSLATE_ORE);

        offerSmelting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 0.25f, 200, "mithril_ingot");
        offerBlasting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 0.25f, 100, "mithril_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.MITHRIL_INGOT, RecipeCategory.DECORATIONS, ModBlocks.MITHRIL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.RAW_MITHRIL, RecipeCategory.DECORATIONS, ModBlocks.RAW_MITHRIL_BLOCK);

        // Sword Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_SWORD, RecipeCategory.MISC,
                new String[]{" R ", " R ", " S "},
                'R', ModItems.MITHRIL_INGOT,
                'S', Items.STICK);

        // Shovel Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_SHOVEL, RecipeCategory.MISC,
                new String[]{" R ", " S ", " S "},
                'R', ModItems.MITHRIL_INGOT,
                'S', Items.STICK);

        // Axe Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_AXE, RecipeCategory.MISC,
                new String[]{" RR", " SR", " S "},
                'R', ModItems.MITHRIL_INGOT,
                'S', Items.STICK);

        // Pickaxe Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_PICKAXE, RecipeCategory.MISC,
                new String[]{"RRR", " S ", " S "},
                'R', ModItems.MITHRIL_INGOT,
                'S', Items.STICK);

        // Hoe Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_HOE, RecipeCategory.MISC,
                new String[]{" RR", " S ", " S "},
                'R', ModItems.MITHRIL_INGOT,
                'S', Items.STICK);

        // Helmet Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_HELMET, RecipeCategory.MISC,
                new String[]{"RRR", "R R", "   "},
                'R', ModItems.MITHRIL_INGOT);

        // Chestplate Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_CHESTPLATE, RecipeCategory.MISC,
                new String[]{"R R", "RRR", "RRR"},
                'R', ModItems.MITHRIL_INGOT);

        // leggings Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_LEGGINGS, RecipeCategory.MISC,
                new String[]{"RRR", "R R", "R R"},
                'R', ModItems.MITHRIL_INGOT);

        // Boots Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_BOOTS, RecipeCategory.MISC,
                new String[]{"R R", "R R", "   "},
                'R', ModItems.MITHRIL_INGOT);

        // Horse Armor Recipe
        shapedRecipe(exporter, ModItems.MITHRIL_HORSE_ARMOR, RecipeCategory.MISC,
                new String[]{" R ", "RHR", " J "},
                'R', ModItems.MITHRIL_INGOT,
                'H', Items.DIAMOND_HORSE_ARMOR,
                'J', ModBlocks.MITHRIL_BLOCK);




    }
    private void shapedRecipe(RecipeExporter exporter, ItemConvertible output, RecipeCategory category,
                              String[] pattern, Object... inputs) {
        var builder = ShapedRecipeJsonBuilder.create(category, output);
        for (String line : pattern) builder.pattern(line);
        for (int i = 0; i < inputs.length; i += 2)
            builder.input((Character)inputs[i], (ItemConvertible)inputs[i+1]);
        builder.criterion(hasItem(output), conditionsFromItem(output)).offerTo(exporter);
    }
}
