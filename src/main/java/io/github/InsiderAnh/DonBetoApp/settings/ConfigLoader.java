package io.github.InsiderAnh.DonBetoApp.settings;

import lombok.Getter;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.loader.ConfigurationLoader;

import io.github.InsiderAnh.DonBetoApp.MainApp;
import io.github.InsiderAnh.DonBetoApp.utils.Console;

import java.io.File;
import java.io.IOException;

@Getter
public class ConfigLoader {

    private final MainApp mainApp;

    private File configFile;
    private ConfigurationLoader<CommentedConfigurationNode> loader;

    private ServerConfig serverConfig;
    private CommentedConfigurationNode rootNode;

    public ConfigLoader(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public ConfigLoader init() {
        this.configFile = new File(mainApp.getLocalFolder(), "settings.conf");
        boolean exists = this.configFile.exists();

        if (!exists) {
            try {
                if (!this.configFile.createNewFile()) {
                    Console.error("Failed to create settings.conf");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.loader = HoconConfigurationLoader.builder()
            .defaultOptions(opts -> opts.shouldCopyDefaults(true))
            .path(configFile.toPath())
            .build();

        if (!exists) {
            save();
        }

        this.load();

        return this;
    }

    public void load() {
        try {
            rootNode = this.loader.load();
            this.serverConfig = rootNode.get(ServerConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            this.serverConfig = new ServerConfig();
            this.loader.save(this.loader.createNode().set(this.serverConfig));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
