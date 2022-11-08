package io.github.sdxqw.winzui.element;

import lombok.Getter;
import net.minecraft.client.Minecraft;

/**
 * Create elements to be displayed on the screen
 *
 * @author sdxqw
 */
@Getter
public abstract class UIElement {

    private final Minecraft mc = Minecraft.getMinecraft();
    private final String name;
    private float x;
    private float y;
    private float width;
    private float height;

    /**
     * Creates a UIElement with the given name
     * @param name String name of the element
     */
    public UIElement(String name) {
        this.name = name;
    }

    /**
     * Creates a UIElement size with the specified x, y, width and height
     * Please note that need to be instanced as an object
     *
     * @param x Float the x position of the element
     * @param y Float the y position of the element
     * @param width Float the width of the element
     * @param height Float the height of the element
     */
    public void setSize(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Mouse move its used most of the time to check if the mouse its on the element
     * @param mouseX Float the mouseX
     * @param mouseY Float the mouseY
     * @return The float position of the element if its override
     */
    public boolean mouseMove(float mouseX, float mouseY) {
        return mouseX >= this.x && mouseY >= this.y && mouseX <= this.x + this.width && mouseY <= this.y + this.height;
    }

    public abstract void drawElement(float mouseX, float mouseY);
}
