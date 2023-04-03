package me.mqrshe.sponger.hud.impl;

import me.mqrshe.sponger.hud.HUDElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class FpsHUD extends HUDElement {

    private static final MatrixStack MATRICES = new MatrixStack();

    static MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void render() {
        String fps = String.valueOf(mc.getCurrentFps());
        MinecraftClient.getInstance().textRenderer.drawWithShadow(MATRICES, "Fps: " + fps, 1 , 1, -1);

    }
}
