package com.jsburg.gusts.render;

import com.jsburg.gusts.Gusts;
import com.jsburg.gusts.entities.GustEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GustRenderer extends MobRenderer<GustEntity, GustModel<GustEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Gusts.MOD_ID, "textures/entity/gust.png");

    public GustRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GustModel<>(), 1.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(GustEntity entity) {
        return TEXTURE;
    }
}
