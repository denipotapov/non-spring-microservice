package com.example.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.Properties;

public class Configuration {

    private static Properties systemProperties = System.getProperties();

    public static void loadConfiguration(String fileName) throws IOException {
        InputStream properties = Configuration.class.getClassLoader().getResourceAsStream(fileName);
        if (properties == null) {
            throw new NoSuchFileException(fileName);
        }
        systemProperties.load(properties);
    }

    public static String get(String name) {
        return systemProperties.getProperty(name);
    }

    public static String getOrDefault(String name, String defaultValue) {
        if (systemProperties.getProperty(name) == null) {
            return defaultValue;
        } else return systemProperties.getProperty(name);
    }
}
