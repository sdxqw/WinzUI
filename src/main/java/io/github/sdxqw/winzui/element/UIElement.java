package io.github.sdxqw.winzui.element;

import lombok.Getter;

@Getter
public abstract class UIElement {
    private float x;
    private float y;
    private float width;
    private float height;

    public void setSize(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean mouseMove(float mouseX, float mouseY) {
        return mouseX >= this.x && mouseY >= this.y && mouseX <= this.x + this.width && mouseY <= this.y + this.height;
    }

    public abstract void drawElement(float mouseX, float mouseY);
}
