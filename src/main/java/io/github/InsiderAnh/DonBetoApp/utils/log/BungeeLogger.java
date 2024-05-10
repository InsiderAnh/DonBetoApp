package io.github.InsiderAnh.DonBetoApp.utils.log;

import jline.console.ConsoleReader;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class BungeeLogger extends Logger {

    private final LogDispatcher dispatcher = new LogDispatcher(this);

    public BungeeLogger(String loggerName, String filePattern, ConsoleReader reader) {
        super(loggerName, null);
        setLevel(Level.ALL);

        try {
            FileHandler fileHandler = new FileHandler(filePattern, 1 << 24, 8, true);
            fileHandler.setLevel(Level.parse(System.getProperty("net.md_5.bungee.file-log-level", "INFO")));
            fileHandler.setFormatter(new ConciseFormatter(false));
            addHandler(fileHandler);

            ColouredWriter consoleHandler = new ColouredWriter(reader);
            consoleHandler.setLevel(Level.parse(System.getProperty("net.md_5.bungee.console-log-level", "INFO")));
            consoleHandler.setFormatter(new ConciseFormatter(true));
            addHandler(consoleHandler);
        } catch (IOException ex) {
            System.err.println("Could not register logger!");
            ex.printStackTrace();
        }

        dispatcher.start();
    }

    @Override
    public void log(LogRecord record) {
        dispatcher.queue(record);
    }

    void doLog(LogRecord record) {
        super.log(record);
    }
    
}