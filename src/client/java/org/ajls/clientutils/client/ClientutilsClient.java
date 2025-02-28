package org.ajls.clientutils.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.ajls.clientutils.commands.debug.ChangeIntValueCommand;
import org.ajls.clientutils.commands.utils.NetherPortalCommand;
import org.ajls.clientutils.render.MyHudRenderer;

public class ClientutilsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new MyHudRenderer());
        // Register your command here
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
            ChangeIntValueCommand.register(dispatcher);
            NetherPortalCommand.register(dispatcher);
//            dispatcher.register(
//                    CommandManager.literal("yourcommand")
//                            .executes(context -> {
//                                ServerCommandSource source = context.getSource();
//                                source.sendFeedback(Text.of("Hello, this is your custom command!"), false);
//                                return 1;
//                            })
//            );
        });

//        System.out.println("Your mod has been initialized!");
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
