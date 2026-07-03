package com.app.quantitymeasurement.unit;

public enum WeightUnit implements IMeasurable {

    KILOGRAM(1),

    GRAM(0.001),

    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(

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

//    @Override
//    public Class<?> getMeasurementType() {
//
//        return WeightUnit.class;
//
//    }

    @Override
    public String getMeasurementType() {

        return "WEIGHT";

    }
}