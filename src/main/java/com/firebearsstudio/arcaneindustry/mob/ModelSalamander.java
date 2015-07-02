package com.firebearsstudio.arcaneindustry.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSalamander extends ModelBase
{
  //fields
    ModelRenderer headupper;
    ModelRenderer headlower;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Tail;
  
  public ModelSalamander()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      headupper = new ModelRenderer(this, 0, 0);
      headupper.addBox(-5F, -1F, -14F, 10, 3, 15);
      headupper.setRotationPoint(0F, 14F, -9F);
      headupper.setTextureSize(128, 64);
      headupper.mirror = true;
      setRotation(headupper, 0F, 0F, 0F);
      headlower = new ModelRenderer(this, 0, 24);
      headlower.addBox(-4F, -1F, -14F, 8, 2, 15);
      headlower.setRotationPoint(0F, 17F, -8F);
      headlower.setTextureSize(128, 64);
      headlower.mirror = true;
      setRotation(headlower, 0F, 0F, 0F);
      body = new ModelRenderer(this, 50, 18);
      body.addBox(-6F, -11F, -4F, 10, 18, 5);
      body.setRotationPoint(1F, 15F, 3F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 48, 48);
      leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
      leg1.setRotationPoint(-3F, 18F, 7F);
      leg1.setTextureSize(128, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 1.134464F);
      leg2 = new ModelRenderer(this, 64, 48);
      leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
      leg2.setRotationPoint(3F, 18F, 7F);
      leg2.setTextureSize(128, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, -1.134464F);
      leg3 = new ModelRenderer(this, 48, 48);
      leg3.addBox(-3F, 0F, -3F, 4, 12, 4);
      leg3.setRotationPoint(-3F, 18F, -4F);
      leg3.setTextureSize(128, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 1.134464F);
      leg4 = new ModelRenderer(this, 64, 48);
      leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
      leg4.setRotationPoint(3F, 18F, -4F);
      leg4.setTextureSize(128, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, -1.134464F);
      Tail = new ModelRenderer(this, 0, 44);
      Tail.addBox(-1F, -1F, 0F, 2, 2, 18);
      Tail.setRotationPoint(0F, 16F, 10F);
      Tail.setTextureSize(128, 64);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    headupper.render(f5);
    headlower.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    Tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}