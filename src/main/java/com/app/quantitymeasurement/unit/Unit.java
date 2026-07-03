package com.app.quantitymeasurement.unit;

public enum Unit implements IMeasurable {

    FEET(30.48),

    INCH(2.54),

    YARD(91.44),

    CENTIMETER(1);

    private final double conversionFactor;

    Unit(

            double conversionFactor

    ) {

        this.conversionFactor =

                conversionFactor;
    }

    @Override
    public double getConversionFactor() {

        return conversionFactor;
    }

    @Override
    public double toBaseUnit(

            double value

    ) {

        return value

                * conversionFactor;
    }

    @Override
    public double fromBaseUnit(

            double value

    ) {

        return value

                / conversionFactor;
    }

    @Override
    public String getUnitName() {

        return name();
    }

    // ==========================
    // UC14
    // ==========================

//    @Override
//    public SupportsArithmetic getArithmeticSupport() {
//
//        return () -> true;
//
//    }

    @Override
    public Class<?> getMeasurementType() {

        return Unit.class;

    }
}