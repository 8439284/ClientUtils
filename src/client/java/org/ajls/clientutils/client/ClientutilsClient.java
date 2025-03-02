package org.ajls.clientutils.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
//import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
//import net.fabricmc.fabric.api.client.rendering.v1.LayeredDrawerWrapper;
//import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
//import net.minecraft.client.gui.DrawContext;
//import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import org.ajls.clientutils.render.MyHudRenderer;
//import org.ajls.clientutils.commands.debug.ChangeIntValueCommand;
//import org.ajls.clientutils.render.MyHudRenderer;

public class ClientutilsClient implements ClientModInitializer {
    public static final String MOD_ID = "clientutils";
    private static final Identifier EXAMPLE_LAYER = Identifier.of(MOD_ID, "hud-example-layer");
    @Override
    public void onInitializeClient() {
//        HudRenderCallback.EVENT.register(new MyHudRenderer());
        // Attach our rendering code to before the chat hud layer. Our layer will render right before the chat. The API will take care of z spacing and automatically add 200 after every layer.
        HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.CHAT, EXAMPLE_LAYER, MyHudRenderer::render));
//        HudLayerRegistrationCallback.EVENT.register((registry) -> {
//            registry.register(Identifier.of("mymod", "custom_hud"), (context, tickDelta) -> {
//                // 在此处编写渲染代码
//                DrawContext drawContext = context.drawContext();
//                drawContext.drawTextWithShadow(
//                        context.textRenderer(),
//                        "Hello, Fabric HUD!",
//                        10, 10, 0xFFFFFF
//                );
//            });
//        });
//        HudLayerRegistrationCallback.EVENT.register((layers) -> {
//            // 注册一个在 VANILLA_TEXT 层级之后渲染的 HUD
//            layers.registerAbove(HudElement.VANILLA_TEXT,
//                    new Identifier("mymod", "custom_hud"),
//                    (drawContext, tickDelta) -> {
//                        // 直接使用 drawContext 参数
//                        drawContext.drawTextWithShadow(
//                                MinecraftClient.getInstance().textRenderer, // 从 MinecraftClient 获取 textRenderer
//                                "Hello, Fabric HUD!",
//                                10, 10, 0xFFFFFF
//                        );
//                    }
//            );
//        });

        // Register your command here
//        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
//            ChangeIntValueCommand.register(dispatcher);
//
//
//
////            dispatcher.register(
////                    CommandManager.literal("yourcommand")
////                            .executes(context -> {
////                                ServerCommandSource source = context.getSource();
////                                source.sendFeedback(Text.of("Hello, this is your custom command!"), false);
////                                return 1;
////                            })
////            );
//        });

//        System.out.println("Your mod has been initialized!");

//        HudLayerRegistrationCallback.EVENT.register((LayeredDrawerWrapper layeredDrawer) -> {
//            MyHudRenderer.register(layeredDrawer);
//        });


    }

//    HudRenderCallback

//    HudRenderCallback.EVENT.register//((drawContext, tickDelta) -> {
//        // Get the transformation matrix from the matrix stack, alongside the tessellator instance and a new buffer builder.
//        Matrix4f transformationMatrix = drawContext.getMatrices().peek().getPositionMatrix();
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder buffer = tessellator.getBuffer();
//
//        // Initialize the buffer using the specified format and draw mode.
//        buffer.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
//
//        // Write our vertices, Z doesn't really matter since it's on the HUD.
//        buffer.vertex(transformationMatrix, 20, 20, 5).color(0xFF414141).next();
//        buffer.vertex(transformationMatrix, 5, 40, 5).color(0xFF000000).next();
//        buffer.vertex(transformationMatrix, 35, 40, 5).color(0xFF000000).next();
//        buffer.vertex(transformationMatrix, 20, 60, 5).color(0xFF414141).next();
//
//        // We'll get to this bit in the next section.
//        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//
//        // Draw the buffer onto the screen.
//        tessellator.draw();
//    });
}
