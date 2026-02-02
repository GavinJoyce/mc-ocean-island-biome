package com.oceanislandbiome;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(OceanIslandBiome.MOD_ID)
public class OceanIslandBiome {
    public static final String MOD_ID = "oceanislandbiome";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Block> PURE_SAND = BLOCKS.register("pure_sand",
            () -> new SandBlock(0xF5F5DC, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> COCONUT_LOG = BLOCKS.register("coconut_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> COCONUT_LEAVES = BLOCKS.register("coconut_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .strength(0.2F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .isValidSpawn((state, level, pos, type) -> type == net.minecraft.world.entity.EntityType.OCELOT || type == net.minecraft.world.entity.EntityType.PARROT)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));

    public static final RegistryObject<Item> PURE_SAND_ITEM = ITEMS.register("pure_sand",
            () -> new BlockItem(PURE_SAND.get(), new Item.Properties()));

    public static final RegistryObject<Item> COCONUT_LOG_ITEM = ITEMS.register("coconut_log",
            () -> new BlockItem(COCONUT_LOG.get(), new Item.Properties()));

    public static final RegistryObject<Item> COCONUT_LEAVES_ITEM = ITEMS.register("coconut_leaves",
            () -> new BlockItem(COCONUT_LEAVES.get(), new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("ocean_island_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MOD_ID))
                    .withTabsBefore(CreativeModeTabs.NATURAL_BLOCKS)
                    .icon(() -> PURE_SAND_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(PURE_SAND_ITEM.get());
                        output.accept(COCONUT_LOG_ITEM.get());
                        output.accept(COCONUT_LEAVES_ITEM.get());
                    }).build());

    public OceanIslandBiome() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(PURE_SAND_ITEM);
            event.accept(COCONUT_LOG_ITEM);
            event.accept(COCONUT_LEAVES_ITEM);
        }
    }
}
