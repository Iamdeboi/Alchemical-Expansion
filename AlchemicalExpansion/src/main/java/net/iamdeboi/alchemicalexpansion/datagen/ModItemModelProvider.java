package net.iamdeboi.alchemicalexpansion.datagen;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.iamdeboi.alchemicalexpansion.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AlchemicalExpansion.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ALCHEMICAL_BOLUS);
        simpleItem(ModItems.BELLADONNA);
        simpleItem(ModItems.ESSENCE_CONTAINER);

        simpleItem(ModItems.AQUATIC_POWDER);
        simpleItem(ModItems.ARTHROPOD_POWDER);
        simpleItem(ModItems.BOTANICAL_POWDER);
        simpleItem(ModItems.ENDER_POWDER);
        simpleItem(ModItems.FLESHY_POWDER);
        simpleItem(ModItems.GLITTERING_POWDER);
        simpleItem(ModItems.NETHERBOUND_POWDER);
        simpleItem(ModItems.SPORE_POWDER);

        simpleBlockItemBlockTexture(ModBlocks.BELLADONNA_PLANT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(AlchemicalExpansion.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(AlchemicalExpansion.MODID,"block/" + item.getId().getPath()));
    }
}
