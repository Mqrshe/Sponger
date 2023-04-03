package me.mqrshe.sponger.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class SpongerScreen extends Screen {

    private final Identifier BUTTON_TEXTURE = new Identifier("minecraft", "textures/gui/widgets.png");
    private boolean showFps = false;

    public SpongerScreen() {
        super(Text.translatable("Blank Screen"));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrixStack);

        if (showFps && MinecraftClient.getInstance().world != null) {
            int fps = MinecraftClient.getInstance().getCurrentFps();
            MinecraftClient.getInstance().textRenderer.drawWithShadow(matrixStack, "FPS: " + fps, 10, 10, 0xFFFFFF);
        }

        super.render(matrixStack, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
            int x = (this.width - 100) / 2;
            int y = (this.height - 30) / 2;
            if (mouseX >= x && mouseX <= x + 100 && mouseY >= y && mouseY <= y + 30) {
                if (MinecraftClient.getInstance().world != null) {
                    this.showFps = !this.showFps;
                }
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }


    @Override
    public void init() {
        int x = (this.width - 100) / 2;
        int y = (this.height - 30) / 2;
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("FPS"), (button) -> {
            this.showFps = !this.showFps;
        }).dimensions(x, y, 100, 30).build());
    }

    public void onClose() {
        super.close();
    }
}
