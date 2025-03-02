package org.ajls.clientutils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.ajls.clientutils.commands.utils.NetherPortalCommand;

public class Clientutils implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
            NetherPortalCommand.register(dispatcher);
        });
    }
}
