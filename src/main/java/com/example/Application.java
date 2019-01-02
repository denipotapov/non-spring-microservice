package com.example;

import com.example.server.Server;
import com.example.server.UndertowEmbedded;

import javax.servlet.ServletException;

import static com.example.configuration.Configuration.loadConfiguration;

public class Application {

    public static void main(String[] args) throws ServletException {
        loadConfiguration("application.properties");
        Server server = UndertowEmbedded.getInstance();
        server.run();
    }


}
