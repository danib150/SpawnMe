package it.dbruni.spawn.commands.mainCommand;

import it.dbruni.spawn.commands.mainCommand.subCommands.HelpArgument;
import it.dbruni.spawn.commands.mainCommand.subCommands.ReloadArgument;
import it.dbruni.spawn.commands.mainCommand.subCommands.SetSpawnArgument;
import it.dbruni.spawn.commands.mainCommand.subCommands.UnknownArgument;
import it.dbruni.spawn.managers.SenderUtils;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;



public class SpawnMeCommand implements CommandExecutor {
    private final List<CommandArguments> arguments;
    @Setter
    private CommandArguments unknownArgument;

    public SpawnMeCommand() {
        Bukkit.getPluginCommand("spawnme").setExecutor(this);

        arguments = new ArrayList<>();
        unknownArgument = new UnknownArgument();

        registerArgument(new SetSpawnArgument());

        registerArgument(new HelpArgument());
        registerArgument(new ReloadArgument());
    }

    public void registerArgument(CommandArguments argument) {
        arguments.add(argument);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        SenderUtils senderUtils = new SenderUtils(sender);
        if (!senderUtils.hasPermission("spawnme.admin")) return true;

        if (args.length == 0) {
            unknownArgument.execute(sender, args);
            return true;
        }

        arguments.stream()
                .filter(commandArguments -> commandArguments
                        .getArgument()
                        .equalsIgnoreCase(args[0]) && commandArguments.getLength() <= args.length)
                .findFirst()
                .orElse(unknownArgument)
                .execute(sender, args);

        return true;
    }

}
