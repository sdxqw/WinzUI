package io.github.sdxqw.winzui.element;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

/**
 * Create any type of picture on the screen
 *
 * @author sdxqw
 */
@Getter
public class UIPicture {
    public static final Minecraft mc = Minecraft.getMinecraft();

    private final ResourceLocation pictureLocation;

    private final float x;
    private final float y;
    private final float width;
    private final float height;

    public UIPicture(float x, float y, float width, float height, String pictureLocation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.pictureLocation = new ResourceLocation(pictureLocation);
    }

    public UIPicture(float x, float y, float width, float height, ResourceLocation pictureLocation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.pictureLocation = pictureLocation;
    }

    public void drawPicture() {
        pushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0F);
        Gui.drawModalRectWithCustomSizedTexture((int) getX(),
                (int) getY(),
                0.0f,
                0.0f,
                (int) getWidth(),
                (int) getHeight(),
                getWidth(),
                getHeight());
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }

    private void pushMatrix() {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL13.GL_MULTISAMPLE);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        mc.getTextureManager().bindTexture(getPictureLocation());
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
    }

    public void drawPicture(float alpha) {
        pushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
        Gui.drawModalRectWithCustomSizedTexture((int) getX(),
                (int) getY(),
                0.0f,
                0.0f,
                (int) getWidth(),
                (int) getHeight(),
                getWidth(),
                getHeight());
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }
}

