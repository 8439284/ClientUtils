package org.ajls.clientutils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;

public class MyCustomScreen extends Screen {
    public MyCustomScreen(Text title) {
        super(title);
    }

//    @Override
//    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
//        super.render(matrices, mouseX, mouseY, delta);
//
//        // Set the color for the text
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//
//        // Get Minecraft's text renderer
//        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
//
//        // Define the text you want to render
//        Text text = Text.of("Hello, Minecraft!");
//
//        // Render the text at the position (x, y)
//        textRenderer.draw(matrices, text, 50, 50, 0xFFFFFF);  // white text at position (50, 50)
//    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Set the color for the text
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        // Get Minecraft's text renderer
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        // Define the text you want to render
        Text text = Text.of("Hello, Minecraft!");
        int color = 0xFFFFFF;  // white

//        // Create the text you want to render
//        Text text = Text.of("Hello, Minecraft!");

        // Convert Text to OrderedText for rendering (to allow rich formatting)
        OrderedText orderedText = text.asOrderedText();
        // Render the text at the position (x, y)
//        context.drawText(textRenderer, text, 50, 50, 0xFFFFFF);  // white text at position (50, 50)
        context.drawText(textRenderer, orderedText, 50, 50, color, true);
    }
}
