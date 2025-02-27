//package org.ajls.clientutils.mixin.client;
//
//import net.minecraft.client.gui.DrawContext;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.util.math.MathHelper;
//import org.spongepowered.asm.mixin.*;
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.font.TextRenderer;
////import net.minecraft.client.gui.DrawableHelper;
//import net.minecraft.client.gui.hud.InGameHud;
//import net.minecraft.client.render.BufferBuilder;
//import net.minecraft.client.render.Tessellator;
//import net.minecraft.client.render.VertexFormats;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.util.Identifier;
//import org.lwjgl.opengl.GL11;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.Redirect;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
//
//@Mixin(InGameHud.class)
//public class HealthRenderMixin {
//
//    @Shadow
//    static enum InGameHud.HeartType heartType;
//
//    @Overwrite
//    private void renderHealthBar(
//            DrawContext context,
//            PlayerEntity player,
//            int x,
//            int y,
//            int lines,
//            int regeneratingHeartIndex,
//            float maxHealth,
//            int lastHealth,
//            int health,
//            int absorption,
//            boolean blinking
//    ) {
//        InGameHud.HeartType heartType = InGameHud.HeartType.fromPlayerState(player);
//        boolean bl = player.getWorld().getLevelProperties().isHardcore();
//        int i = MathHelper.ceil((double)maxHealth / 2.0);
//        int j = MathHelper.ceil((double)absorption / 2.0);
//        int k = i * 2;
//
//        for (int l = i + j - 1; l >= 0; l--) {
//            int m = l / 10;
//            int n = l % 10;
//            int o = x + n * 8;
//            int p = y - m * lines;
//            if (lastHealth + absorption <= 4) {
//                p += this.random.nextInt(2);
//            }
//
//            if (l < i && l == regeneratingHeartIndex) {
//                p -= 2;
//            }
//
//            this.drawHeart(context, InGameHud.HeartType.CONTAINER, o, p, bl, blinking, false);
//            int q = l * 2;
//            boolean bl2 = l >= i;
//            if (bl2) {
//                int r = q - k;
//                if (r < absorption) {
//                    boolean bl3 = r + 1 == absorption;
//                    this.drawHeart(context, heartType == InGameHud.HeartType.WITHERED ? heartType : InGameHud.HeartType.ABSORBING, o, p, bl, false, bl3);
//                }
//            }
//
//            if (blinking && q < health) {
//                boolean bl4 = q + 1 == health;
//                this.drawHeart(context, heartType, o, p, bl, true, bl4);
//            }
//
//            if (q < lastHealth) {
//                boolean bl4 = q + 1 == lastHealth;
//                this.drawHeart(context, heartType, o, p, bl, false, bl4);
//            }
//        }
//    }
//}
