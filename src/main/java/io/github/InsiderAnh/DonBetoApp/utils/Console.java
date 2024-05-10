package io.github.InsiderAnh.DonBetoApp.utils;

import java.util.logging.Logger;

import io.github.InsiderAnh.DonBetoApp.MainApp;

public class Console {

    private static final Logger logger = MainApp.getInstance().getLogger();

    public static void debug(String format, Object... obj) {
        // Only Console Log with Debug Enable. Otherwise, don't log it.
        if (true) logger.info(String.format(format, obj));
    }

    public static void debug(String msg) {
        logger.info(msg);
    }

    public static void log(String msg, Object... obj) {
        logger.info(String.format(msg, obj));
    }

    public static void error(String format, Object... obj) {
        logger.info(String.format(format, obj));
    }

}
