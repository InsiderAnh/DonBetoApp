package io.github.InsiderAnh.DonBetoApp;

import lombok.SneakyThrows;

public class Bootstrap {

    @SneakyThrows
    public static void main(String[] args) {
        MainApp backend = MainApp.class.getConstructor().newInstance();

        Runtime.getRuntime().addShutdownHook(new Thread(backend::stop));
    }

}
