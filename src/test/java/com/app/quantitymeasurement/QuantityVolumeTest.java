package com.app.quantitymeasurement;
import com.app.quantitymeasurement.entity.Quantity;
import com.app.quantitymeasurement.unit.TemperatureUnit;
import com.app.quantitymeasurement.unit.Unit;
import com.app.quantitymeasurement.unit.VolumeUnit;
import com.app.quantitymeasurement.unit.WeightUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityVolumeTest {

    @Test

    void given1LitreAnd1000Millilitre_ShouldReturnEqual() {

        Quantity<VolumeUnit> litre =

                new Quantity<>(

                        1,

                        VolumeUnit.LITRE

                );

        Quantity<VolumeUnit> millilitre =

                new Quantity<>(

                        1000,

                        VolumeUnit.MILLILITRE

                );

        assertEquals(

                litre,

                millilitre

        );
    }


    @Test

    void given1GallonAnd3Point78541Litre_ShouldReturnEqual() {

        Quantity<VolumeUnit> gallon =

                new Quantity<>(

                        1,

                        VolumeUnit.GALLON

                );

        Quantity<VolumeUnit> litre =

                new Quantity<>(

                        3.78541,

                        VolumeUnit.LITRE

                );

        assertEquals(

                gallon,

                litre

        );
    }


    @Test

    void given1Litre_WhenConvertedToMillilitre() {

        Quantity<VolumeUnit> litre =

                new Quantity<>(

                        1,

                        VolumeUnit.LITRE

                );

        Quantity<VolumeUnit> expected =

                new Quantity<>(

                        1000,

                        VolumeUnit.MILLILITRE

                );

        assertEquals(

                expected,

                litre.convertTo(

                        VolumeUnit.MILLILITRE

                )

        );
    }


    @Test

    void given1LitrePlus1000Millilitre_ShouldReturn2Litre() {

        Quantity<VolumeUnit> first =

                new Quantity<>(

                        1,

                        VolumeUnit.LITRE

                );

        Quantity<VolumeUnit> second =

                new Quantity<>(

                        1000,

                        VolumeUnit.MILLILITRE

                );

        Quantity<VolumeUnit> expected =

                new Quantity<>(

                        2,

                        VolumeUnit.LITRE

                );

        assertEquals(

                expected,

                first.add(

                        second

                )

        );
    }


    @Test

    void given1LitrePlus1000Millilitre_InMillilitre() {

        Quantity<VolumeUnit> first =

                new Quantity<>(

                        1,

                        VolumeUnit.LITRE

                );

        Quantity<VolumeUnit> second =

                new Quantity<>(

                        1000,

                        VolumeUnit.MILLILITRE

                );

        Quantity<VolumeUnit> expected =

                new Quantity<>(

                        2000,

                        VolumeUnit.MILLILITRE

                );

        assertEquals(

                expected,

                first.add(

                        second,

                        VolumeUnit.MILLILITRE

                )

        );
    }
}