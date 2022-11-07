package io.github.sdxqw.winzui.screen;

import lombok.Getter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

@Getter
public class UIScreen extends GuiScreen implements IScreen {

    private ScaledResolution sr;

    @Override
    public void initGui() {
        sr = new ScaledResolution(mc);
        drawElement(mc.mouseHelper.deltaX, mc.mouseHelper.deltaY);
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        final float scaleFactor = getScaleFactor();
        GL11.glPushMatrix();
        GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
        drawElementsOnScreen(mouseX / scaleFactor, mouseY / scaleFactor);
        GL11.glPopMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int state) throws IOException {
        final float scaleFactor = getScaleFactor();
        elementsMouseClicked(mouseX / scaleFactor, mouseY / scaleFactor, state);
        super.mouseClicked(mouseX, mouseY, state);
    }

    private float getScaleFactor() {
        return 1.0f / (getSr().getScaleFactor() * .5f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}