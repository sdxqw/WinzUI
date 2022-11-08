package io.github.sdxqw.winzui.element;

import io.github.sdxqw.winzlogger.LogLevel;
import io.github.sdxqw.winzlogger.Logger;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

import static org.lwjgl.opengl.GL11.*;

/**
 * Create text on the screen with default font
 *
 * @author sdxqw
 */
@Getter
public class UIText {
    private String text;
    private Alignment alignment;
    private int color;

    public UIText(String text, Alignment alignment, int color) {
        this.text = text;
        this.alignment = alignment;
        this.color = color;
    }

    public UIText(String text, float x, float y, int color) {
        DrawText.drawDefaultText(text, x, y, color);
    }

    public void drawText() {
        switch (alignment) {
            case CENTER:
                DrawText.drawCenterAlignmentText(getText(), getColor());
                break;
            case LEFT:
                DrawText.drawLeftAlignmentText(getText(), getColor());
                break;
            case RIGHT:
                DrawText.drawRightAlignmentText(getText(), getColor());
                break;
            default:
                Logger.print("no alignment", LogLevel.ERROR);
                break;
        }
    }

    public enum Alignment {
        CENTER, LEFT, RIGHT
    }

    static class DrawText {
        private static final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

        public static void drawDefaultText(String text, float x, float y, int color) {
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            Minecraft.getMinecraft().fontRendererObj.drawString(text, (int) x, (int) y, color);
        }

        public static void drawLeftAlignmentText(String text, int color) {
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            Minecraft.getMinecraft().fontRendererObj.drawString(text, (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 - 250, sr.getScaledHeight() / 2, color);
        }

        public static void drawRightAlignmentText(String text, int color) {
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            Minecraft.getMinecraft().fontRendererObj.drawString(text, (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 + 250, sr.getScaledHeight() / 2, color);
        }

        public static void drawCenterAlignmentText(String text, int color) {
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            Minecraft.getMinecraft().fontRendererObj.drawString(text, (sr.getScaledWidth() - Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2, sr.getScaledHeight() / 2, color);
        }
    }
}
