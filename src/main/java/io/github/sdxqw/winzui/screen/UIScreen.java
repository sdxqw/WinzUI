package io.github.sdxqw.winzui.screen;

import lombok.Getter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

/**
 * Create screen for the elements / anything you want scaled
 *
 * @author sdxqw
 */
@Getter
public abstract class UIScreen extends GuiScreen {

    protected ScaledResolution sr;

    public abstract void initElements();

    public abstract void drawElementsOnScreen(float mouseX, float mouseY);

    public abstract void elementsMouseClicked(float mouseX, float mouseY, int state);

    @Override
    public void initGui() {
        sr = new ScaledResolution(mc);
        initElements();
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        final float scaleFactor = getScaleFactor();
        GL11.glPushMatrix();
        GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
        drawElementsOnScreen((mouseX / scaleFactor), (mouseY / scaleFactor));
        GL11.glPopMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int state) throws IOException {
        final float scaleFactor = getScaleFactor();
        elementsMouseClicked((mouseX / scaleFactor), (mouseY / scaleFactor), state);
        super.mouseClicked(mouseX, mouseY, state);
    }

    public float getScaleFactor() {
        return 1.0f / (getSr().getScaleFactor() * .5f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}