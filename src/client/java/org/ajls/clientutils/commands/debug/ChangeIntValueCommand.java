//package org.ajls.clientutils.commands.debug;
//
//import com.mojang.brigadier.Command;
//import com.mojang.brigadier.CommandDispatcher;
//import com.mojang.brigadier.arguments.IntegerArgumentType;
//import com.mojang.brigadier.arguments.StringArgumentType;
//import com.mojang.brigadier.context.CommandContext;
//import net.minecraft.server.command.CommandManager;
//import net.minecraft.server.command.ServerCommandSource;
//import net.minecraft.text.Text;
//
//public class ChangeIntValueCommand {
//    public static int CommandInt = 0;
//    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
//        dispatcher.register(
//                CommandManager.literal("int")
//                        .then(CommandManager.literal("set")
//                                .then(CommandManager.argument("value", IntegerArgumentType.integer())
//                                        .executes(context -> {
//                                            int value = IntegerArgumentType.getInteger(context, "value");
//                                            CommandInt = value;
//                                            context.getSource().sendFeedback(() -> Text.literal("Value set to: " + CommandInt), false);
//                                            return Command.SINGLE_SUCCESS;
//                                        })
//                                )
//                        )
//                        .then(CommandManager.literal("get")
//                                .executes(context -> {
//                                    context.getSource().sendFeedback(() -> Text.literal("Current value: " + CommandInt), false);
//                                    return Command.SINGLE_SUCCESS;
//                                })
//                        )
//                        .then(CommandManager.literal("add")
//                                .then(CommandManager.argument("value", IntegerArgumentType.integer())
//                                        .executes(context -> {
//                                            int value = IntegerArgumentType.getInteger(context, "value");
//                                            CommandInt += value;
//                                            context.getSource().sendFeedback(() -> Text.literal("Value set to: " + CommandInt), false);
//                                            return Command.SINGLE_SUCCESS;
//                                        })
//                                )
//                        )
////                CommandManager.literal("int")
////                        .then(CommandManager.argument("name", StringArgumentType.string())
////                                .executes(context -> runWithArgument(context, StringArgumentType.getString(context, "name"))))
//        );
//    }
//
//    private static int runWithArgument(CommandContext<ServerCommandSource> context, String name) {
//        ServerCommandSource source = context.getSource();
//        source.sendFeedback(() -> Text.of("Hello, " + name + "!"), true);
//        return 1;
//    }
//}
