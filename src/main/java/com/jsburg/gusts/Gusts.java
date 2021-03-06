package com.jsburg.gusts;

import com.jsburg.gusts.registry.AllEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gusts")
public class Gusts
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gusts";

    public Gusts() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AllEntities.register(modEventBus);
//        AllSounds.SOUNDS.register(modEventBus);
//        AllParticles.PARTICLE_TYPES.register(modEventBus);
//        AllEnchantments.ENCHANTMENTS.register(modEventBus);

        modEventBus.addListener(this::setupCommon);
        modEventBus.addListener(this::setupClient);

    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        AllEntities.registerAttributes(event);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        AllEntities.registerRenderers(event);
//        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ClientEvents::fiddleWithHands);
//        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ClientEvents::doCameraStuff);
//        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, ClientEvents::doClientTick);
    }

}
