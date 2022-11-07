package io.github.sdxqw.winzui.screen;

interface IScreen {
    default void drawElement(float mouseX, float mouseY) {

    }

    default void drawElementsOnScreen(float mouseX, float mouseY) {

    }

    default void elementsMouseClicked(float mouseX, float mouseY, int state) {

    }
}
