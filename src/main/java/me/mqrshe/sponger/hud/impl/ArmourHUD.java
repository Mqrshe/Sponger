package me.mqrshe.sponger.hud.impl;

import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.systems.RenderSystem;
import me.mqrshe.sponger.hud.HUDElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class ArmourHUD extends HUDElement {

    private static final MatrixStack MATRICES = new MatrixStack();
    private static final int HUD_PADDING = 1;

    static MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void render() {
        int hudWidth = 4 * 18;
        int hudHeight = 18;
        double x = mc.getWindow().getScaledWidth() - hudWidth - HUD_PADDING;
        double y = mc.getWindow().getScaledHeight() - hudHeight - HUD_PADDING;
        double armorX;
        double armorY;

        MatrixStack matrices = RenderSystem.getModelViewStack();
        matrices.push();

        int slot = 3; // start from the last slot
        for (int position = 0; position < 4; position++) {
            ItemStack itemStack = mc.player.getInventory().getArmorStack(slot);

            armorX = x + position * 18;
            armorY = y;

            drawItem(itemStack, (int) armorX, (int) armorY, 1, true);

            slot--; // decrement the slot index to iterate in reverse order
        }

        matrices.pop();
    }

    public static void drawItem(ItemStack itemStack, int x, int y, float scale, boolean overlay) {
        MATRICES.push();
        MATRICES.scale(scale, scale, 1f);
        MATRICES.translate(0, 0, 401);

        int scaledX = (int) (x / scale);
        int scaledY = (int) (y / scale);

        mc.getItemRenderer().renderInGuiWithOverrides(MATRICES, itemStack, scaledX, scaledY);
        if (overlay) {
            mc.getItemRenderer().renderGuiItemOverlay(MATRICES, mc.textRenderer, itemStack, scaledX, scaledY, null);
        }

        MATRICES.pop();
    }
}
