package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CinderscapesItemTags {
    public static final TagKey<Item> ROSE_QUARTZ_CONVERTIBLES = TagKey.of(Registry.ITEM_KEY, Cinderscapes.id("rose_quartz_convertibles"));
    public static final TagKey<Item> SCORCHED_STEMS = TagKey.of(Registry.ITEM_KEY, Cinderscapes.id("scorched_stems"));
    public static final TagKey<Item> SMOKY_QUARTZ_CONVERTIBLES = TagKey.of(Registry.ITEM_KEY, Cinderscapes.id("smoky_quartz_convertibles"));
    public static final TagKey<Item> SULFUR_QUARTZ_CONVERTIBLES = TagKey.of(Registry.ITEM_KEY, Cinderscapes.id("sulfur_quartz_convertibles"));
    public static final TagKey<Item> UMBRAL_STEMS = TagKey.of(Registry.ITEM_KEY, Cinderscapes.id("umbral_stems"));

    public static final TagKey<Item> DARK_ASHES_DUSTS = TagKey.of(Registry.ITEM_KEY, new Identifier("forge", "dusts/dark_ashes"));
    public static final TagKey<Item> QUARTZ = TagKey.of(Registry.ITEM_KEY, new Identifier("forge", "gems/quartz"));
    public static final TagKey<Item> QUARTZ_BLOCKS = TagKey.of(Registry.ITEM_KEY, new Identifier("forge", "storage_blocks/quartz"));
    public static final TagKey<Item> QUARTZ_ORES = TagKey.of(Registry.ITEM_KEY, new Identifier("forge", "ores/quartz"));
    public static final TagKey<Item> SULFUR_ORES = TagKey.of(Registry.ITEM_KEY, new Identifier("forge", "ores/sulfurs"));
    public static final TagKey<Item> SULFURS = TagKey.of(Registry.ITEM_KEY, new Identifier("forge", "sulfurs"));

    public static void init() { }
}
