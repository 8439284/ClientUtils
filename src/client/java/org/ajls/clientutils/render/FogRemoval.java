//package org.ajls.clientutils.render;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.render.GameRenderer;
//import net.minecraft.client.render.WorldRenderer;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.client.world.ClientWorld;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.chunk.Chunk;
//import net.fabricmc.api.ModInitializer;
//import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
////import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientRenderEvents;
//import net.minecraft.client.render.Camera;
////import net.minecraft.client.render.FogType;
//import net.minecraft.client.render.RenderPhase;
//import net.minecraft.client.render.entity.EntityRendererFactory;
//
//public class FogRemoval {
//
////    @Override
////    public void onInitialize() {
////        // Register for the end of the world render event
////        ClientRenderEvents.END.register(this::onRenderWorld);
////    }
//
//    private void onRenderWorld(MatrixStack matrices, float tickDelta, long startTime) {
//        MinecraftClient client = MinecraftClient.getInstance();
//        ClientWorld world = client.world;
//        Camera camera = client.gameRenderer.getCamera();
//
//        if (world == null || camera == null) {
//            return;
//        }
//
//        BlockPos cameraPos = camera.getBlockPos();
//        int chunkRadius = 8;  // Define how many chunks from the player you want to affect
//
//        // Check if the camera is near the edge of loaded chunks
//        int minX = cameraPos.getX() - chunkRadius;
//        int maxX = cameraPos.getX() + chunkRadius;
//        int minZ = cameraPos.getZ() - chunkRadius;
//        int maxZ = cameraPos.getZ() + chunkRadius;
//
//        // If we're in the chunk edge range, disable fog rendering
//        if (cameraPos.getX() < minX || cameraPos.getX() > maxX || cameraPos.getZ() < minZ || cameraPos.getZ() > maxZ) {
//            // This is where you can disable fog
//            RenderSystem.disableFog();
//        } else {
//            // Enable fog if inside the loaded chunk region
//            RenderSystem.enableFog();
//        }
//    }
//
//    private void onRenderWorld(WorldRenderer worldRenderer, MatrixStack matrixStack, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, Matrix4f projectionMatrix) {
//        // Disable the chunk border fog by setting the fog distance to a very high value
//        gameRenderer.getClient().worldRenderer.fog(1000000.0F); // This method may vary depending on the Minecraft version
//    }
//
//    // Handling render fog in your event or tick handler
//    public static void renderWorldLast(MatrixStack matrixStack, float tickDelta) {
//        // Disable the fog entirely or adjust its behavior at the chunk borders.
//        MinecraftClient client = MinecraftClient.getInstance();
//        GameRenderer gameRenderer = client.gameRenderer;
//
//
//        // Disable the fog by manipulating the FogRenderer
//        FogR.setFogState(FogRenderer.FogState.NONE);
//
//        // Custom rendering logic (optional) for chunk borders
//
//        // Re-enable fog after rendering if needed
//        FogRenderer.setFogState(FogRenderer.FogState.DEFAULT)
//    }
//}
