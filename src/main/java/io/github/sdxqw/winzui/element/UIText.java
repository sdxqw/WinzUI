package io.github.sdxqw.winzui.element;

import io.github.sdxqw.winzlogger.LogLevel;
import io.github.sdxqw.winzlogger.Logger;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Create text on the screen with default font
 *
 * @author sdxqw
 */
@Getter
public class UIText {
    public static void drawText(String text, Alignment alignment, int color) {
        Drawer.drawDefaultText(text, alignment, color);
    }

    public static void drawText(String text, Alignment alignment, float x, float y, int color) {
        Drawer.drawDefaultText(text, alignment, x, y, color);
    }

    static class Drawer {
        static final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

        static void drawDefaultText(String text, Alignment alignment, float x, float y, int color) {
            switch (alignment) {
                case CENTER:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                    break;
                case LEFT:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 - 150 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                    break;
                case RIGHT:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 + 150 + x), (int) (sr.getScaledHeight() / 2 + y), color);
                    break;
                case NONE:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (int) ((sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) + x), (int) (sr.getScaledHeight() + y), color);
                    break;
                default:
                    Logger.print("no alignment", LogLevel.ERROR);
                    break;
            }
        }

        static void drawDefaultText(String text, Alignment alignment, int color) {
            switch (alignment) {
                case CENTER:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2, sr.getScaledHeight() / 2, color);
                    break;
                case LEFT:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 - 250, sr.getScaledHeight() / 2, color);
                    break;
                case RIGHT:
                    Minecraft.getMinecraft().fontRendererObj.drawString(text, (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 + 250, sr.getScaledHeight() / 2, color);
                    break;
                default:
                    Logger.print("alignment not implemented", LogLevel.ERROR);
                    break;
            }
        }
    }
}
