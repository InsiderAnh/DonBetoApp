package io.github.InsiderAnh.DonBetoApp.commands.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class BackendCommand {

    private String name;
    private String description;

    public abstract void execute(String[] args);

}
