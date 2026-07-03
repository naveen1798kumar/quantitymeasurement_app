package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.unit.IMeasurable;
import com.app.quantitymeasurement.unit.TemperatureUnit;
import com.app.quantitymeasurement.unit.Unit;
import com.app.quantitymeasurement.unit.VolumeUnit;
import com.app.quantitymeasurement.unit.WeightUnit;

public final class UnitFactory {

    private UnitFactory() {

    }

    public static IMeasurable getUnit(

            String measurementType,

            String unitName

    ) {

        if (

                measurementType == null ||

                        unitName == null

        ) {

            throw new IllegalArgumentException(

                    "Measurement type and unit name cannot be null."

            );

        }

        return switch (

                measurementType.toUpperCase()

                ) {

            case "LENGTH" ->

                    Unit.valueOf(

                            unitName.toUpperCase()

                    );

            case "WEIGHT" ->

                    WeightUnit.valueOf(

                            unitName.toUpperCase()

                    );

            case "VOLUME" ->

                    VolumeUnit.valueOf(

                            unitName.toUpperCase()

                    );

            case "TEMPERATURE" ->

                    TemperatureUnit.valueOf(

                            unitName.toUpperCase()

                    );

            default ->

                    throw new IllegalArgumentException(

                            "Unsupported measurement type: "

                                    + measurementType

                    );

        };

    }

}