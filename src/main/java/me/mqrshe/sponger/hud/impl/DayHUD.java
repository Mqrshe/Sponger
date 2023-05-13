package me.mqrshe.sponger.hud.impl;

import me.mqrshe.sponger.hud.HUDElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class DayHUD extends HUDElement {

    private static final MatrixStack MATRICES = new MatrixStack();

    static MinecraftClient mc = MinecraftClient.getInstance();

    public void render() {
        long day = mc.world.getTimeOfDay() / 24000;
        MinecraftClient.getInstance().textRenderer.drawWithShadow(MATRICES, "Day: " + day, 1 , 19, -1);
    }

}
