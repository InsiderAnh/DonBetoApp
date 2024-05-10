package io.github.InsiderAnh.DonBetoApp.utils;

import jline.console.completer.Completer;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import io.github.InsiderAnh.DonBetoApp.MainApp;

@RequiredArgsConstructor
public class ConsoleCommandCompleter implements Completer {

    private final MainApp mainApp;

    @Override
    public int complete(String buffer, int cursor, List<CharSequence> candidates) {
        int lastSpace = buffer.lastIndexOf(' ');

        if (lastSpace == -1) {
            String lowerCase = buffer.toLowerCase(Locale.ROOT);
            candidates.addAll(mainApp.getCommandExecutor().getCommandsCollection().stream()
                .map(Map.Entry::getKey)
                .filter((name) -> name.toLowerCase(Locale.ROOT).startsWith(lowerCase))
                .collect(Collectors.toList()));
        }

        return (lastSpace == -1) ? cursor - buffer.length() : cursor - (buffer.length() - lastSpace - 1);
    }
}
