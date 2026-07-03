package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionPool {

    private static final ApplicationConfig CONFIG =

            ApplicationConfig.getInstance();

    static {

        try {

            Class.forName(

                    CONFIG.getDatabaseDriver()

            );

        }

        catch (ClassNotFoundException exception) {

            throw new DatabaseException(

                    "Failed to load JDBC Driver.",

                    exception

            );

        }

    }

    private ConnectionPool() {

        // Prevent object creation

    }

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(

                    CONFIG.getDatabaseUrl(),

                    CONFIG.getDatabaseUsername(),

                    CONFIG.getDatabasePassword()

            );

        }

        catch (SQLException exception) {

            throw new DatabaseException(

                    "Failed to create database connection.",

                    exception

            );

        }

    }

    public static void closeConnection(

            Connection connection

    ) {

        if (

                connection != null

        ) {

            try {

                if (

                        !connection.isClosed()

                ) {

                    connection.close();

                }

            }

            catch (SQLException exception) {

                throw new DatabaseException(

                        "Failed to close database connection.",

                        exception

                );

            }

        }

    }

}