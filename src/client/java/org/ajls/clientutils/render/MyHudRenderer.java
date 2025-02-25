package org.ajls.clientutils.render;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import org.ajls.clientutils.calculations.HealthRegenByFoodCalc;
import org.ajls.clientutils.commands.debug.ChangeIntValueCommand;
import org.ajls.clientutils.container.HealthRegenByFoodData;

public class MyHudRenderer implements HudRenderCallback {
//    @Override
//    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
//        // Get the Minecraft client instance
//        MinecraftClient client = MinecraftClient.getInstance();
//        if (client.player == null) return; // Ensure the player is not null
//
//        // Get the text renderer
//        TextRenderer textRenderer = client.textRenderer;
//
//        // Define the text to display
//        String text = "Hello, Minecraft Fabric!";
//
//        // Calculate the position (e.g., top-left corner)
//        int x = 10; // 10 pixels from the left
//        int y = 10; // 10 pixels from the top
//
//        // Render the text on the screen
//        textRenderer.drawWithShadow(matrixStack, text, x, y, 0xFFFFFF); // 0xFFFFFF is white color
//    }

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        // Get the Minecraft client instance
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return; // Ensure the player is not null

        // Get the screen dimensions
        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();

        // Calculate the position of the health bar
        int healthBarX = screenWidth / 2 - 91; // Health bar is centered horizontally
        int healthBarY = screenHeight - 39; // Health bar is near the bottom of the screen


        // Define the text to display
        double health = (double) client.player.getHealth();
        String text = "Health: " + health;
//        String text = "Hello, Minecraft Fabric 1.21.4!";

        HealthRegenByFoodData healthRegenByFoodData = HealthRegenByFoodCalc.getHealthRegenByFoodData();
        double vigorHealth = healthRegenByFoodData.getByVigor();
        double foodLevelHealth = healthRegenByFoodData.getByFoodLevel();
        String foodHealthText = "Food Health: " + vigorHealth + ", " + foodLevelHealth;

        // Calculate the position (e.g., top-left corner)
        int x = 10; // 10 pixels from the left
        int y = 10; // 10 pixels from the top

        // Render the text on the screen using DrawContext
        drawContext.drawText(client.textRenderer, text, healthBarX, healthBarY - 10, 0xFFFFFF, true); // 0xFFFFFF is white color  //shadow false  // -8
        drawContext.drawText(client.textRenderer, foodHealthText, healthBarX, healthBarY - 20, 0xFFFFFF, true); // 0xFFFFFF is white color  //shadow false
    }

}
