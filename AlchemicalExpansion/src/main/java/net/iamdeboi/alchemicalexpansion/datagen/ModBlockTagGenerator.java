package net.iamdeboi.alchemicalexpansion.datagen;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.iamdeboi.alchemicalexpansion.item.ModItems;
import net.iamdeboi.alchemicalexpansion.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AlchemicalExpansion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Blocks
        this.tag(ModTags.Blocks.HERBALISM_ELIGIBLE_PLANTS)
                .add(ModBlocks.BELLADONNA_PLANT.get())
                    .addTag(BlockTags.FLOWERS)
                    .addTag(BlockTags.SWORD_EFFICIENT);

        // Items
        //this.tag(ModTags.Items.ALCHEMICAL_INGREDIENTS);

        // Mineable with Tools Tags
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.MORTAR_AND_PESTLE_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEMBIC_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.BELLADONNA_PLANT.get());

        // Tool Strength Requirement Tags
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ALEMBIC_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
    }
}
