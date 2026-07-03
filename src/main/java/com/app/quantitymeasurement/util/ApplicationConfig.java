package com.app.quantitymeasurement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ApplicationConfig {

    private static final String CONFIG_FILE = "application.properties";

    private static final ApplicationConfig INSTANCE =
            new ApplicationConfig();

    private final Properties properties;

    private ApplicationConfig() {

        properties = new Properties();

        loadProperties();

    }

    public static ApplicationConfig getInstance() {

        return INSTANCE;

    }

    private void loadProperties() {

        try (

                InputStream inputStream =

                        getClass()

                                .getClassLoader()

                                .getResourceAsStream(

                                        CONFIG_FILE

                                )

        ) {

            if (

                    inputStream == null

            ) {

                throw new IllegalStateException(

                        CONFIG_FILE

                                +

                                " not found."

                );

            }

            properties.load(

                    inputStream

            );

        }

        catch (

                IOException exception

        ) {

            throw new RuntimeException(

                    "Unable to load configuration.",

                    exception

            );

        }

    }

    // ==================================================
    // Application
    // ==================================================

    public String getApplicationName() {

        return properties.getProperty(

                "application.name"

        );

    }

    // ==================================================
    // Repository
    // ==================================================

    public String getRepositoryType() {

        return properties.getProperty(

                "repository.type"

        );

    }

    // ==================================================
    // Database
    // ==================================================

    public String getDatabaseDriver() {

        return properties.getProperty(

                "database.driver"

        );

    }

    public String getDatabaseUrl() {

        return properties.getProperty(

                "database.url"

        );

    }

    public String getDatabaseUsername() {

        return properties.getProperty(

                "database.username"

        );

    }

    public String getDatabasePassword() {

        return properties.getProperty(

                "database.password"

        );

    }

    public String getSchemaLocation() {

        return properties.getProperty(

                "database.schema"

        );

    }

    // ==================================================
    // Logging
    // ==================================================

    public boolean isLoggingEnabled() {

        return Boolean.parseBoolean(

                properties.getProperty(

                        "logging.enabled"

                )

        );

    }

    public String getLoggingLevel() {

        return properties.getProperty(

                "logging.level"

        );

    }

}