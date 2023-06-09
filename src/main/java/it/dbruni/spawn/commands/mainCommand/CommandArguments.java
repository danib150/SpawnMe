package it.dbruni.spawn.commands.mainCommand;

import lombok.Getter;
import org.bukkit.command.CommandSender;

@Getter
public abstract class CommandArguments {

        private final String argument;
        private final int length;

        public CommandArguments(String argument, int length) {
            this.argument = argument;
            this.length = length;
        }

        public abstract void execute(CommandSender sender, String[] args);

}
