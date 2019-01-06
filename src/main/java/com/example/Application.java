package com.example;

import com.example.configuration.HibernateEntityManagerFactory;
import com.example.server.Server;
import com.example.server.UndertowEmbedded;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.example.configuration.Configuration.loadConfiguration;

public class Application {

    public static void main(String[] args) throws ServletException, IOException, URISyntaxException {
        loadConfiguration("application.properties");
        HibernateEntityManagerFactory.configureManagerFactory();
        Server server = UndertowEmbedded.getInstance();
        server.run();
    }


}
