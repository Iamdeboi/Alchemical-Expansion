package net.iamdeboi.alchemicalexpansion.datagen;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlchemicalExpansion.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALEMBIC_BLOCK);

        simpleBlockWithItem(ModBlocks.BELLADONNA_PLANT.get(), models().cross(blockTexture(ModBlocks.BELLADONNA_PLANT.get()).getPath(),
                blockTexture(ModBlocks.BELLADONNA_PLANT.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_BELLADONNA.get(), models().singleTexture("potted_belladonna_plant", ResourceLocation.tryParse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.BELLADONNA_PLANT.get())).renderType("cutout"));

        simpleBlock(ModBlocks.MORTAR_AND_PESTLE_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/mortar_and_pestle_block")));
    }

    // Pass Registry object block --> registers custom full block and its associated item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll((blockRegistryObject.get())));
    }


}
