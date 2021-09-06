package com.jsburg.gusts.registry;

import com.jsburg.gusts.Gusts;
import com.jsburg.gusts.entities.GustEntity;
import com.jsburg.gusts.render.GustRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Gusts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AllEntities {

    private static DeferredRegister<EntityType<?>> TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Gusts.MOD_ID);

    static public void register(IEventBus bus) {
        TYPES.register(bus);
    }

    static private String mobName(String name) {
        return new ResourceLocation(Gusts.MOD_ID, name).toString();
    }

    public static final RegistryObject<EntityType<GustEntity>> GUST = TYPES.register("gust",
            () -> EntityType.Builder.create(GustEntity::new, EntityClassification.CREATURE)
                    .size(3, 3)
                    .build(mobName("gust"))
            );


    public static void registerAttributes(FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(GUST.get(), GustEntity.getAttributes().create());
    }

    public static void registerRenderers(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(GUST.get(), GustRenderer::new);
    }
}
