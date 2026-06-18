package net.iamdeboi.alchemicalexpansion.block;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.block.custom.AlembicBlock;
import net.iamdeboi.alchemicalexpansion.block.custom.MortarAndPestleBlock;
import net.iamdeboi.alchemicalexpansion.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AlchemicalExpansion.MODID);

    // Use BlockBehavior.Properties.copy(Blocks.BLOCK_NAME_HERE) to make a new block of existing properties
    // You can override the preset properties simply by using ".propertyhere"
    // Example: .sound(SoundType.AMETHYST))); overrides the sounds of the block to be that of Amethyst blocks

    public static final RegistryObject<Block> BELLADONNA_PLANT = registerBlock("belladonna_plant",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5,
    BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_BELLADONNA = BLOCKS.register("potted_belladonna_plant",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.BELLADONNA_PLANT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH).noOcclusion()));



    public static final RegistryObject<Block> ALEMBIC_BLOCK = registerBlock("alembic_block",
            () -> new AlembicBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> MORTAR_AND_PESTLE_BLOCK = registerBlock("mortar_and_pestle_block",
            () -> new MortarAndPestleBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.BONE_BLOCK)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
