package com.app.quantitymeasurement.unit;

public interface IMeasurable {

    double getConversionFactor();

    double toBaseUnit(double value);

    double fromBaseUnit(double value);

    String getUnitName();

    // UC14

    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {

        return supportsArithmetic.isSupported();

    }

    default void validateOperationSupport(

            String operation

    ) {

        if (

                !supportsArithmetic()

        ) {

            throw new UnsupportedOperationException(

                    operation

                            +

                            " operation is not supported for "

                            +

                            getUnitName()

            );
        }
    }

//    default Class<?> getMeasurementType() {
//
//        return getClass();
//
//    }

    String getMeasurementType();
}