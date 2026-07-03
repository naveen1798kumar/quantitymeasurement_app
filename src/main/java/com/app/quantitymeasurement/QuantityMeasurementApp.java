package com.app.quantitymeasurement;

import com.app.quantitymeasurement.controller.QuantityMeasurementController;
import com.app.quantitymeasurement.entity.Quantity;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.app.quantitymeasurement.unit.Unit;

import com.app.quantitymeasurement.util.DatabaseInitializer;

import com.app.quantitymeasurement.util.ApplicationConfig;

// DB connection

import com.app.quantitymeasurement.util.ConnectionPool;

import java.sql.Connection;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        ApplicationConfig config =

                ApplicationConfig.getInstance();

        System.out.println(

                config.getApplicationName()

        );

        System.out.println(

                config.getDatabaseUrl()

        );

        System.out.println(

                config.getRepositoryType()

        );

        // ==========================
        // Repository Layer
        // ==========================

        IQuantityMeasurementRepository repository =

                new QuantityMeasurementDatabaseRepository();

        // =========================
        // Connection Pool

        Connection connection =

                ConnectionPool.getConnection();

        System.out.println(

                "Database Connected Successfully."

        );

        ConnectionPool.closeConnection(

                connection

        );

        // ==========================
        // Database Initializer
        // ==========================

        DatabaseInitializer.initializeDatabase();

        System.out.println(

                "Database Initialized Successfully."

        );

        // ==========================
        // Service Layer
        // ==========================

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        repository

                );

        // ==========================
        // Controller Layer
        // ==========================

        QuantityMeasurementController controller =

                new QuantityMeasurementController(

                        service

                );

        // ==========================
        // Sample Length Quantities
        // ==========================

        Quantity<Unit> oneFeet =

                new Quantity<>(

                        1,

                        Unit.FEET

                );

        Quantity<Unit> twelveInch =

                new Quantity<>(

                        12,

                        Unit.INCH

                );

        // ==========================
        // Compare
        // ==========================

        System.out.println(

                "Compare : "

                        +

                        controller.compare(

                                oneFeet,

                                twelveInch

                        )

        );

        // ==========================
        // Convert
        // ==========================

        System.out.println(

                "Convert : "

                        +

                        controller.convert(

                                oneFeet,

                                Unit.INCH

                        )

        );

        // ==========================
        // Add
        // ==========================

        System.out.println(

                "Add : "

                        +

                        controller.add(

                                oneFeet,

                                twelveInch

                        )

        );

        // ==========================
        // Add with Target Unit
        // ==========================

        System.out.println(

                "Add (Inches) : "

                        +

                        controller.add(

                                oneFeet,

                                twelveInch,

                                Unit.INCH

                        )

        );

        // ==========================
        // Subtract
        // ==========================

        System.out.println(

                "Subtract : "

                        +

                        controller.subtract(

                                oneFeet,

                                twelveInch

                        )

        );

        // ==========================
        // Divide
        // ==========================

        System.out.println(

                "Divide : "

                        +

                        controller.divide(

                                new Quantity<>(

                                        24,

                                        Unit.INCH

                                ),

                                new Quantity<>(

                                        12,

                                        Unit.INCH

                                )

                        )

        );

        // ==========================
        // Repository History
        // ==========================

        System.out.println();

        System.out.println(

                "========= Repository History ========="

        );

        repository.findAll()

                .forEach(

                        System.out::println

                );

    }
}
