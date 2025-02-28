package org.ajls.clientutils.commands.utils;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.block.Blocks;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class NetherPortalCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("netherportal")
                        .executes(context -> {
                            ServerPlayerEntity serverPlayerEntity = context.getSource().getPlayer();
                            if (serverPlayerEntity != null) {
                                createNetherPortal(serverPlayerEntity);
                            }
                            return Command.SINGLE_SUCCESS;
                        })
//                        .then(CommandManager.literal("set")
//
//                        )
        );
    }

    private static void createNetherPortal(ServerPlayerEntity player) {
        World world = player.getWorld();
        BlockPos playerPos = player.getBlockPos();
        Direction facing = player.getHorizontalFacing();

        // Calculate the position in front of the player
        BlockPos portalPos = playerPos.offset(facing, 3).down();  //up

        // Create the Obsidian frame
        for (int y = 0; y < 5; y++) {
            for (int x = -1; x <= 2; x++) { //x<= 1
                BlockPos framePos = portalPos.add(x, y, 0);
                world.setBlockState(framePos, Blocks.OBSIDIAN.getDefaultState());
            }
        }

        // Fill the inner area with Nether Portal blocks
        for (int y = 1; y < 4; y++) {
            for (int x = 0; x <= 1; x++) { // x <= 0
                BlockPos portalBlockPos = portalPos.add(x, y, 0);
                world.setBlockState(portalBlockPos, Blocks.NETHER_PORTAL.getDefaultState());
            }
        }
    }
}
