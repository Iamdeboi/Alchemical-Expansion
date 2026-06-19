package net.iamdeboi.alchemicalexpansion.util;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> HERBALISM_ELIGIBLE_PLANTS = tag("herbalism_eligible_plants");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(Objects.requireNonNull(ResourceLocation.tryBuild(AlchemicalExpansion.MODID, name)));
        }
    }

    public static class Items {
        public static final TagKey<Item> ALCHEMICAL_POWDERS = tag("alchemical_powders");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(Objects.requireNonNull(ResourceLocation.tryBuild(AlchemicalExpansion.MODID, name)));
        }

    }
}
