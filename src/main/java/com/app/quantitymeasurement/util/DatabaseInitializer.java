package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.exception.DatabaseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public final class DatabaseInitializer {

    private DatabaseInitializer() {

    }

    public static void initializeDatabase() {

        String schemaLocation =

                ApplicationConfig

                        .getInstance()

                        .getSchemaLocation();

        try (

                Connection connection =

                        ConnectionPool.getConnection();

                Statement statement =

                        connection.createStatement()

        ) {

            String sql =

                    readSchemaFile(

                            schemaLocation

                    );

            String[] sqlStatements =

                    sql.split(";");

            for (

                    String sqlStatement : sqlStatements

            ) {

                if (

                        !sqlStatement.trim().isEmpty()

                ) {

                    statement.execute(

                            sqlStatement

                    );

                }

            }

            System.out.println("Database initialization complete");
        }

        catch (

                SQLException exception

        ) {

            throw new DatabaseException(

                    "Failed to initialize database.",

                    exception

            );

        }

    }

    private static String readSchemaFile(

            String schemaLocation

    ) {

        try (

                InputStream inputStream =

                        DatabaseInitializer.class

                                .getClassLoader()

                                .getResourceAsStream(

                                        schemaLocation

                                )

        ) {

            if (

                    inputStream == null

            ) {

                throw new DatabaseException(

                        "Schema file not found."

                );

            }

            return new BufferedReader(

                    new InputStreamReader(

                            inputStream

                    )

            )

                    .lines()

                    .collect(

                            Collectors.joining(

                                    "\n"

                            )

                    );

        }

        catch (

                IOException exception

        ) {

            throw new DatabaseException(

                    "Unable to read schema file.",

                    exception

            );

        }

    }

}