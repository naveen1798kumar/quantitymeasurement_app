package com.app.quantitymeasurement.unit;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS {

        @Override
        public double toBaseUnit(double value) {

            return value;

        }

        @Override
        public double fromBaseUnit(double value) {

            return value;

        }

    },

    FAHRENHEIT {

        @Override
        public double toBaseUnit(double value) {

            return (value - 32) * 5 / 9;

        }

        @Override
        public double fromBaseUnit(double value) {

            return (value * 9 / 5) + 32;

        }

    },

    KELVIN {

        @Override
        public double toBaseUnit(double value) {

            return value - 273.15;

        }

        @Override
        public double fromBaseUnit(double value) {

            return value + 273.15;

        }

    };

    SupportsArithmetic supportsArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {

        return false;

    }

    @Override
    public void validateOperationSupport(

            String operation

    ) {

        throw new UnsupportedOperationException(

                "Temperature does not support "

                        + operation

                        + " operation."

        );
    }

    @Override
    public double getConversionFactor() {

        return 1;

    }

    @Override
    public String getUnitName() {

        return name();

    }

//    @Override
//    public Class<?> getMeasurementType() {
//
//        return TemperatureUnit.class;
//
//    }

    @Override
    public String getMeasurementType() {

        return "TEMPERATURE";

    }
}