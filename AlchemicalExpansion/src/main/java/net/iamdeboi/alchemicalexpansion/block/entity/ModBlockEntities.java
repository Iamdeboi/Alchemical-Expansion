package net.iamdeboi.alchemicalexpansion.block.entity;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AlchemicalExpansion.MODID);

    public static final RegistryObject<BlockEntityType<MortarAndPestleBlockEntity>> MORTAR_AND_PESTLE_BE =
            BLOCK_ENTITIES.register("mortar_and_pestle_be", () ->
                    BlockEntityType.Builder.of(MortarAndPestleBlockEntity::new,
                            ModBlocks.MORTAR_AND_PESTLE_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
