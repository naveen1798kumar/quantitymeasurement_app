package com.app.quantitymeasurement;

import com.app.quantitymeasurement.entity.Quantity;
import com.app.quantitymeasurement.unit.TemperatureUnit;
import com.app.quantitymeasurement.unit.Unit;
import com.app.quantitymeasurement.unit.VolumeUnit;
import com.app.quantitymeasurement.unit.WeightUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTemperatureTest {

    // ===========================
    // Equality
    // ===========================

    @Test
    void given0CelsiusAnd32Fahrenheit_ShouldReturnEqual() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32,
                        TemperatureUnit.FAHRENHEIT
                );

        assertEquals(
                celsius,
                fahrenheit
        );
    }

    @Test
    void given100CelsiusAnd212Fahrenheit_ShouldReturnEqual() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        100,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        212,
                        TemperatureUnit.FAHRENHEIT
                );

        assertEquals(
                celsius,
                fahrenheit
        );
    }

    @Test
    void given0CelsiusAnd273Point15Kelvin_ShouldReturnEqual() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        assertEquals(
                celsius,
                kelvin
        );
    }

    @Test
    void given32FahrenheitAnd273Point15Kelvin_ShouldReturnEqual() {

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32,
                        TemperatureUnit.FAHRENHEIT
                );

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        assertEquals(
                fahrenheit,
                kelvin
        );
    }

    // ===========================
    // Conversion
    // ===========================

    @Test
    void given0Celsius_WhenConvertedToFahrenheit_ShouldReturn32Fahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> expected =
                new Quantity<>(
                        32,
                        TemperatureUnit.FAHRENHEIT
                );

        assertEquals(
                expected,
                celsius.convertTo(
                        TemperatureUnit.FAHRENHEIT
                )
        );
    }

    @Test
    void given212Fahrenheit_WhenConvertedToCelsius_ShouldReturn100Celsius() {

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        212,
                        TemperatureUnit.FAHRENHEIT
                );

        Quantity<TemperatureUnit> expected =
                new Quantity<>(
                        100,
                        TemperatureUnit.CELSIUS
                );

        assertEquals(
                expected,
                fahrenheit.convertTo(
                        TemperatureUnit.CELSIUS
                )
        );
    }

    @Test
    void given0Celsius_WhenConvertedToKelvin_ShouldReturn273Point15Kelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> expected =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        assertEquals(
                expected,
                celsius.convertTo(
                        TemperatureUnit.KELVIN
                )
        );
    }

    @Test
    void given273Point15Kelvin_WhenConvertedToCelsius_ShouldReturn0Celsius() {

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        Quantity<TemperatureUnit> expected =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        assertEquals(
                expected,
                kelvin.convertTo(
                        TemperatureUnit.CELSIUS
                )
        );
    }

    // ===========================
    // Unsupported Arithmetic
    // ===========================

    @Test
    void givenTemperature_WhenAdded_ShouldThrowException() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        20,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        10,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> first.add(second)
        );
    }

    @Test
    void givenTemperature_WhenSubtracted_ShouldThrowException() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        20,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        10,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> first.subtract(second)
        );
    }

    @Test
    void givenTemperature_WhenDivided_ShouldThrowException() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        20,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        10,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> first.divide(second)
        );
    }

    // ===========================
    // Different Categories
    // ===========================

    @Test
    void givenTemperatureAndLength_ShouldReturnNotEqual() {

        Quantity<TemperatureUnit> temperature =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<Unit> length =
                new Quantity<>(
                        0,
                        Unit.CENTIMETER
                );

        assertNotEquals(
                temperature,
                length
        );
    }

    @Test
    void givenTemperatureAndWeight_ShouldReturnNotEqual() {

        Quantity<TemperatureUnit> temperature =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        0,
                        WeightUnit.KILOGRAM
                );

        assertNotEquals(
                temperature,
                weight
        );
    }

    @Test
    void givenTemperatureAndVolume_ShouldReturnNotEqual() {

        Quantity<TemperatureUnit> temperature =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        0,
                        VolumeUnit.LITRE
                );

        assertNotEquals(
                temperature,
                volume
        );
    }
}