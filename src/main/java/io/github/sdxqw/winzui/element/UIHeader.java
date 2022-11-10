package io.github.sdxqw.winzui.element;

import io.github.sdxqw.winzlogger.LogLevel;
import io.github.sdxqw.winzlogger.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class UIHeader {
    public static void drawText(float x, float y, int color, String... text) {
        Drawer.drawDefaultText(x, y, color, text);
    }

    static class Drawer {
        static final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

        static void drawDefaultText(float x, float y, int color, String... text) {
            if (text != null) {
                for (String texts : text) {
                    Minecraft.getMinecraft().fontRendererObj.drawString(texts, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(texts)) / 2 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                }
            } else Logger.print("text its null", LogLevel.ERROR);
        }

        static void drawDefaultText(Alignment alignment, float x, float y, int color, String... text) {
            if (text != null) {
                for (String texts : text) {
                    switch (alignment) {
                        case LEFT:
                            Minecraft.getMinecraft().fontRendererObj.drawString(texts, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(texts)) / 2 - 150 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                            break;
                        case RIGHT:
                            Minecraft.getMinecraft().fontRendererObj.drawString(texts, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(texts)) / 2 + 150 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                            break;
                        case CENTER:
                            Minecraft.getMinecraft().fontRendererObj.drawString(texts, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(texts)) / 2 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                            break;
                        case NONE:
                            Minecraft.getMinecraft().fontRendererObj.drawString(texts, (int) (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(texts) + x), (int) (sr.getScaledHeight() + y), color);
                            break;
                        default:
                            Logger.print("no alignment", LogLevel.ERROR);
                            break;
                    }
                }
            } else Logger.print("text its null", LogLevel.ERROR);
        }
    }
}
