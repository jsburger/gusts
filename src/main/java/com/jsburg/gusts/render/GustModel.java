package com.jsburg.gusts.render;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GustModel<T extends Entity> extends SegmentedModel<T> {
    private final ImmutableList<ModelRenderer> partsList;
    private final ModelRenderer tail;
    private final ModelRenderer body;

    public GustModel() {

        textureWidth = 192;
        textureHeight = 144;

        ImmutableList.Builder<ModelRenderer> builder = ImmutableList.builder();

        ModelRenderer body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 35.0F, 0.0F);
        //Head
        body.setTextureOffset(0, 0).addBox(-24.0F, -59.0F, -24.0F, 48.0F, 48.0F, 48.0F, 0.0F, false);
        //Flaps
        body.setTextureOffset(20, 100).addBox(-14.0F, -11.0F, -14.0F, 28.0F, 11.0F, 28.0F, 0.0F, false);

        //Tail
        ModelRenderer tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, -12.0F, 0.0F);
        body.addChild(tail);
        tail.setTextureOffset(160, 98).addBox(0.0F, 0.0F, 0.0F, 0.0F, 44.0F, 2.0F, 0.0F, false);

        builder.add(body);

        this.partsList = builder.build();
        this.tail = tail;
        this.body = body;
    }


    @Override
    public Iterable<ModelRenderer> getParts() {
        return partsList;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.tail.rotateAngleX = (float) (0.2 * MathHelper.sin((float) (ageInTicks * 0.15)) + 0.4);
    }
}
