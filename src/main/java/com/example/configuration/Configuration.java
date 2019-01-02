package com.example.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Properties configuration;

    public static void loadConfiguration(String fileName) {
        configuration = new Properties();
        try (InputStream properties =
                     Configuration.class.getClassLoader().getResourceAsStream(fileName)) {
            configuration.load(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String name) {
        return configuration.getProperty(name);
    }

    public static String getOrDefault(String name, String defaultValue) {
        if (configuration.getProperty(name) == null) {
            return defaultValue;
        } else return configuration.getProperty(name);
    }
}
