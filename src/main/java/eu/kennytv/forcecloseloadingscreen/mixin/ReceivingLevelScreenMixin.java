package eu.kennytv.forcecloseloadingscreen.mixin;

import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ReceivingLevelScreen.class)
public abstract class ReceivingLevelScreenMixin extends Screen {

    protected ReceivingLevelScreenMixin(final Component component) {
        super(component);
    }

    @Redirect(method = "tick",
            at = @At(target = "Lnet/minecraft/client/renderer/LevelRenderer;isChunkCompiled(Lnet/minecraft/core/BlockPos;)Z", value = "INVOKE")
    )
    private boolean isChunkCompiled(final LevelRenderer instance, final BlockPos blockPos) {
        return true;
    }
}
