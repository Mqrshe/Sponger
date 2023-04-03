package me.mqrshe.sponger.mixin;

import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import me.mqrshe.sponger.gui.SpongerScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title){
        super(title);
    }

    private static final Identifier SPONGE = new Identifier("textures/block/sponge.png");

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addCustomButton(int y, int spacingY, CallbackInfo ci){
        this.addDrawableChild(ButtonWidget.builder(Text.translatable(""), (button) -> {
            this.client.setScreen(new SpongerScreen());
        }).dimensions(1, 1, 18, 18).build());
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void goldBootsOverlayMixin(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        int y = this.height / 4 + 48;
        RenderSystem.setShaderTexture(0,SPONGE);
        drawTexture(matrices, 5, 5, 0.0F, 0.0F, 9, 9, 16, 16);

    }



}