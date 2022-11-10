package io.github.sdxqw.winzui.element;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class UIHeader {
    public UIHeader(float x, float y, int color, String... names) {
        Drawer.drawDefaultText(x, y, color, names);
    }

    static class Drawer {
        static final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

        static void drawDefaultText(float x, float y, int color, String... names) {
            for (String name : names) {
                Minecraft.getMinecraft().fontRendererObj.drawString(name, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(name)) / 2 + x), (int) (sr.getScaledHeight() / 2 + y), color);
            }
        }
    }
}
