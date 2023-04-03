package me.mqrshe.sponger.handlers;

import me.mqrshe.sponger.Sponger;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.util.math.MatrixStack;

public class RenderEventHandler implements HudRenderCallback {
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        Sponger.hudManager.doRender();
    }
}
