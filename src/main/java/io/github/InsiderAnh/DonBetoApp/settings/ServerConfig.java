package io.github.InsiderAnh.DonBetoApp.settings;

import lombok.Data;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@Data
@ConfigSerializable
public class ServerConfig {

    @Setting
    private boolean debug;
    @Setting
    private String host = "0.0.0.0";
    @Setting
    private int port = 2500;

}
