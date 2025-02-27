package org.ajls.clientutils.mixin.client;

import net.minecraft.client.render.*;
import net.minecraft.client.render.WorldRenderer;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public class NoFogMixin {

//    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
//    private void onRender(RenderTickCounter tickCounter, boolean tick, CallbackInfo ci) {
//        // Disable fog by modifying the render logic
//        // You can also target specific fog types (e.g., chunk border fog)
//        // For example, disable chunk border fog:
//        GameRenderer gameRenderer = (GameRenderer) (Object) this;
//        gameRenderer.getClient().worldRenderer.getChunkBuilder().getChunkRenderer().setFogEnabled(false);
//    }


//    @Inject(method = "render", at = @At(value = "INVOKE", target = ""), cancellable = true)
//    private void render(ObjectAllocator allocator, RenderTickCounter tickCounter, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, Matrix4f positionMatrix, Matrix4f projectionMatrix, CallbackInfo ci) {
//        // Disable fog by modifying the render logic
//        // You can also target specific fog types (e.g., chunk border fog)
//        // For example, disable chunk border fog:
//
//
//
//    }

    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/BackgroundRenderer;applyFog(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/BackgroundRenderer$FogType;Lorg/joml/Vector4f;FZF)Lnet/minecraft/client/render/Fog;"
            )
    )
    public Fog redirectApplyFog(Camera camera, BackgroundRenderer.FogType fogType, Vector4f vector4f, float f, boolean bl, float g) {
        // Return a dummy Fog object or null to effectively disable the fog application
        return Fog.DUMMY;
    }
}
