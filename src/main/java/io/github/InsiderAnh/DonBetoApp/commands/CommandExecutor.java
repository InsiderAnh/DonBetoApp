package io.github.InsiderAnh.DonBetoApp.commands;

import java.util.Map;
import com.google.common.collect.Maps;

import io.github.InsiderAnh.DonBetoApp.commands.api.BackendCommand;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import lombok.Getter;

@Getter
public class CommandExecutor {

    private final Map<String, BackendCommand> commands;

    public CommandExecutor() {
        this.commands = Maps.newConcurrentMap();
    }

    public void load() {
    }

    void register(BackendCommand waffleCommand) {
        this.commands.put(waffleCommand.getName().toLowerCase(), waffleCommand);
    }

    public void run(String line) {
        String[] args = line.split(" ");
        String cmd = args[0].toLowerCase();

        BackendCommand waffleCommand = commands.get(cmd);
        if (waffleCommand == null) return;

        try {
            waffleCommand.execute(Arrays.copyOfRange(args, 1, args.length));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Collection<Map.Entry<String, BackendCommand>> getCommandsCollection() {
        return Collections.unmodifiableCollection(commands.entrySet());
    }

}
