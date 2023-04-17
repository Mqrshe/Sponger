package me.mqrshe.sponger.hud.impl;

import me.mqrshe.sponger.hud.HUDElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class CoordHUD extends HUDElement {

    private static final MatrixStack MATRICES = new MatrixStack();

    static MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void render() {
        int x = (int)Math.ceil(mc.player.getX());
        int y = (int)Math.ceil(mc.player.getY());
        int z = (int)Math.ceil(mc.player.getZ());

        MinecraftClient.getInstance().textRenderer.drawWithShadow(MATRICES, "Coordinates: " + x + ", " + y + ", " + z, 1 , 10, -1);
    }
}
