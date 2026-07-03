package com.app.quantitymeasurement.unit;

public enum VolumeUnit implements IMeasurable {

    LITRE(1),

    MILLILITRE(0.001),

    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(

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

        return VolumeUnit.class;

    }
}