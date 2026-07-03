package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.Quantity;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.unit.IMeasurable;
import com.app.quantitymeasurement.util.ConnectionPool;
import com.app.quantitymeasurement.util.DatabaseInitializer;
import com.app.quantitymeasurement.util.UnitFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    public QuantityMeasurementDatabaseRepository() {

        DatabaseInitializer.initializeDatabase();

    }

    @Override
    public void save(

            QuantityMeasurementEntity entity

    ) {

        if (

                entity == null

        ) {

            throw new IllegalArgumentException(

                    "Entity cannot be null."

            );

        }

        final String sql =

                """
                INSERT INTO quantity_measurements
                (
                    first_value,
                    first_unit,
                    first_measurement_type,
                    second_value,
                    second_unit,
                    second_measurement_type,
                    operation,
                    result
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (

                Connection connection =

                        ConnectionPool.getConnection();

                PreparedStatement statement =

                        connection.prepareStatement(

                                sql

                        )

        ) {

            // ==========================
            // First Quantity
            // ==========================

            statement.setDouble(

                    1,

                    entity.getFirstQuantity()

                            .getValue()

            );

            statement.setString(

                    2,

                    entity.getFirstQuantity()

                            .getUnit()

                            .getUnitName()

            );

            statement.setString(

                    3,
                    entity.getFirstQuantity()
                            .getUnit()
                            .getMeasurementType()

            );

            // ==========================
            // Second Quantity
            // ==========================

            if (

                    entity.getSecondQuantity() != null

            ) {

                statement.setDouble(

                        4,

                        entity.getSecondQuantity()

                                .getValue()

                );

                statement.setString(

                        5,

                        entity.getSecondQuantity()

                                .getUnit()

                                .getUnitName()

                );

                statement.setString(

                        6,
                        entity.getSecondQuantity()
                                .getUnit()
                                .getMeasurementType()
                );

            }

            else {

                statement.setNull(

                        4,

                        Types.DOUBLE

                );

                statement.setNull(

                        5,

                        Types.VARCHAR

                );

                statement.setNull(

                        6,

                        Types.VARCHAR

                );

            }

            // ==========================
            // Operation
            // ==========================

            statement.setString(

                    7,

                    entity.getOperation()

            );

            // ==========================
            // Result
            // ==========================

            statement.setString(

                    8,

                    entity.getResult()

            );

            statement.executeUpdate();

        }

        catch (

                SQLException exception

        ) {

            throw new DatabaseException(

                    "Failed to save quantity measurement.",

                    exception

            );

        }

    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        final String sql =

                "SELECT * FROM quantity_measurements ORDER BY id";

        List<QuantityMeasurementEntity> entities =

                new ArrayList<>();

        try (

                Connection connection =

                        ConnectionPool.getConnection();

                PreparedStatement statement =

                        connection.prepareStatement(

                                sql

                        );

                ResultSet resultSet =

                        statement.executeQuery()

        ) {

            while (

                    resultSet.next()

            ) {

                entities.add(

                        mapEntity(

                                resultSet

                        )

                );

            }

            return entities;

        }

        catch (

                SQLException exception

        ) {

            throw new DatabaseException(

                    "Failed to retrieve quantity measurements.",

                    exception

            );

        }

    }

    @Override
    public void clear() {

        final String sql =

                "DELETE FROM quantity_measurements";

        try (

                Connection connection =

                        ConnectionPool.getConnection();

                PreparedStatement statement =

                        connection.prepareStatement(

                                sql

                        )

        ) {

            statement.executeUpdate();

        }

        catch (

                SQLException exception

        ) {

            throw new DatabaseException(

                    "Failed to clear repository.",

                    exception

            );

        }

    }

//    Build Quantity

    private Quantity<?> buildQuantity(

            double value,

            String unitName,

            String measurementType

    ) {

        if (

                unitName == null ||

                        measurementType == null

        ) {

            return null;

        }

        IMeasurable unit =

                UnitFactory.getUnit(

                        measurementType,

                        unitName

                );

        return new Quantity<>(

                value,

                unit

        );

    }

//    map entity

    private QuantityMeasurementEntity mapEntity(

            ResultSet resultSet

    ) throws SQLException {

        Quantity<?> firstQuantity =

                buildQuantity(

                        resultSet.getDouble(

                                "first_value"

                        ),

                        resultSet.getString(

                                "first_unit"

                        ),

                        resultSet.getString(

                                "first_measurement_type"

                        )

                );

        Quantity<?> secondQuantity =

                buildQuantity(

                        resultSet.getDouble(

                                "second_value"

                        ),

                        resultSet.getString(

                                "second_unit"

                        ),

                        resultSet.getString(

                                "second_measurement_type"

                        )

                );

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        firstQuantity,

                        secondQuantity,

                        resultSet.getString(

                                "operation"

                        ),

                        resultSet.getString(

                                "result"

                        )

                );

        entity.setId(

                resultSet.getLong(

                        "id"

                )

        );

        Timestamp timestamp =

                resultSet.getTimestamp(

                        "created_at"

                );

        if (

                timestamp != null

        ) {

            entity.setCreatedAt(

                    timestamp.toLocalDateTime()

            );

        }

        return entity;

    }

}