package me.mqrshe.sponger.hud.impl;

import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.systems.RenderSystem;
import me.mqrshe.sponger.hud.HUDElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;


public class ArmourHUD extends HUDElement {

    private static final MatrixStack MATRICES = new MatrixStack();

    static MinecraftClient mc = MinecraftClient.getInstance();



    @Override
    public void render() {

        double x = 100;
        double y = 100;
        double armorX;
        double armorY;

        MatrixStack matrices = RenderSystem.getModelViewStack();

        matrices.push();
//        matrices.scale(scale.get().floatValue(), scale.get().floatValue(), 1);

        int slot = 0;
        for (int position = 0; position < 4; position++) {
            ItemStack itemStack = mc.player.getInventory().getArmorStack(slot);


            armorX = x + position * 18;
            armorY = y;


            drawItem(itemStack, (int) armorX, (int) armorY, 1,  (true));


            slot++;
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
        if (overlay) mc.getItemRenderer().renderGuiItemOverlay(MATRICES, mc.textRenderer, itemStack, scaledX, scaledY, null);

        MATRICES.pop();
    }

}
