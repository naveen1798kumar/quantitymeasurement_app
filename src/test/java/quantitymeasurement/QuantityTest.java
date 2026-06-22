package quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    // UC1
    @Test
    void given0FeetAnd0Feet_ShouldReturnEqual() {

        Quantity first =
                new Quantity(
                        0,
                        Unit.FEET
                );

        Quantity second =
                new Quantity(
                        0,
                        Unit.FEET
                );

        assertEquals(
                first,
                second
        );
    }

    @Test
    void given1FeetAnd1Feet_ShouldReturnEqual() {

        Quantity first =
                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity second =
                new Quantity(
                        1,
                        Unit.FEET
                );

        assertEquals(
                first,
                second
        );
    }

    @Test
    void givenNull_ShouldReturnFalse() {

        Quantity quantity =
                new Quantity(
                        1,
                        Unit.FEET
                );

        assertNotEquals(
                quantity,
                null
        );
    }

    @Test
    void givenSameReference_ShouldReturnTrue() {

        Quantity first =
                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity second =
                first;

        assertSame(
                first,
                second
        );
    }

    @Test
    void givenDifferentValue_ShouldReturnFalse() {

        Quantity first =
                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity second =
                new Quantity(
                        2,
                        Unit.FEET
                );

        assertNotEquals(
                first,
                second
        );
    }

    // UC2
    @Test
    void given0FeetAnd0Inch_ShouldReturnEqual() {

        Quantity feet =
                new Quantity(
                        0,
                        Unit.FEET
                );

        Quantity inch =
                new Quantity(
                        0,
                        Unit.INCH
                );

        assertEquals(
                feet,
                inch
        );
    }

    @Test
    void given1FeetAnd12Inch_ShouldReturnEqual() {

        Quantity feet =
                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity inch =
                new Quantity(
                        12,
                        Unit.INCH
                );

        assertEquals(
                feet,
                inch
        );
    }

    @Test
    void given1FeetAnd1Inch_ShouldReturnFalse() {

        Quantity feet =
                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity inch =
                new Quantity(
                        1,
                        Unit.INCH
                );

        assertNotEquals(
                feet,
                inch
        );
    }

    @Test
    void given3FeetAnd1Yard_ShouldReturnEqual() {

        Quantity feet =
                new Quantity(
                        3,
                        Unit.FEET
                );

        Quantity yard =
                new Quantity(
                        1,
                        Unit.YARD
                );

        assertEquals(
                feet,
                yard
        );
    }

    @Test

    void given100CmAnd39Point3701Inch_ShouldReturnEqual() {

        Quantity centimeter =
                new Quantity(
                        100,
                        Unit.CENTIMETER
                );

        Quantity inch =
                new Quantity(
                        39.3701,
                        Unit.INCH
                );

        assertEquals(
                centimeter,
                inch
        );
    }

    @Test
    void given30Point48CmAnd1Feet_ShouldReturnEqual() {

        Quantity centimeter =
                new Quantity(
                        30.48,
                        Unit.CENTIMETER
                );

        Quantity feet =
                new Quantity(
                        1,
                        Unit.FEET
                );

        assertEquals(
                centimeter,
                feet
        );
    }

    @Test
    void given1YardAnd36Inch_ShouldReturnEqual() {

        Quantity yard =
                new Quantity(
                        1,
                        Unit.YARD
                );

        Quantity inch =
                new Quantity(
                        36,
                        Unit.INCH
                );

        assertEquals(
                yard,
                inch
        );
    }

    @Test
    void given1Feet_WhenConvertedToInch_ShouldReturn12Inch() {

        Quantity feet =

                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity actual =

                feet.convertTo(
                        Unit.INCH
                );

        Quantity expected =

                new Quantity(
                        12,
                        Unit.INCH
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given24Inch_WhenConvertedToFeet_ShouldReturn2Feet() {

        Quantity inch =

                new Quantity(
                        24,
                        Unit.INCH
                );

        Quantity actual =

                inch.convertTo(
                        Unit.FEET
                );

        Quantity expected =

                new Quantity(
                        2,
                        Unit.FEET
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given1Yard_WhenConvertedToInch_ShouldReturn36Inch() {

        Quantity yard =

                new Quantity(
                        1,
                        Unit.YARD
                );

        Quantity actual =

                yard.convertTo(
                        Unit.INCH
                );

        Quantity expected =

                new Quantity(
                        36,
                        Unit.INCH
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given36Inch_WhenConvertedToYard_ShouldReturn1Yard() {

        Quantity inch =

                new Quantity(
                        36,
                        Unit.INCH
                );

        Quantity actual =

                inch.convertTo(
                        Unit.YARD
                );

        Quantity expected =

                new Quantity(
                        1,
                        Unit.YARD
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given30Point48Cm_WhenConvertedToFeet_ShouldReturn1Feet() {

        Quantity centimeter =

                new Quantity(
                        30.48,
                        Unit.CENTIMETER
                );

        Quantity actual =

                centimeter.convertTo(
                        Unit.FEET
                );

        Quantity expected =

                new Quantity(
                        1,
                        Unit.FEET
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given6Feet_WhenConvertedToYard_ShouldReturn2Yard() {

        Quantity feet =

                new Quantity(
                        6,
                        Unit.FEET
                );

        Quantity actual =

                feet.convertTo(
                        Unit.YARD
                );

        Quantity expected =

                new Quantity(
                        2,
                        Unit.YARD
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given0Feet_WhenConvertedToInch_ShouldReturn0Inch() {

        Quantity feet =

                new Quantity(
                        0,
                        Unit.FEET
                );

        Quantity actual =

                feet.convertTo(
                        Unit.INCH
                );

        Quantity expected =

                new Quantity(
                        0,
                        Unit.INCH
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void givenMinus1Feet_WhenConvertedToInch_ShouldReturnMinus12Inch() {

        Quantity feet =

                new Quantity(
                        -1,
                        Unit.FEET
                );

        Quantity actual =

                feet.convertTo(
                        Unit.INCH
                );

        Quantity expected =

                new Quantity(
                        -12,
                        Unit.INCH
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void given1Feet_WhenConvertedToFeet_ShouldReturn1Feet() {

        Quantity feet =

                new Quantity(
                        1,
                        Unit.FEET
                );

        Quantity actual =

                feet.convertTo(
                        Unit.FEET
                );

        Quantity expected =

                new Quantity(
                        1,
                        Unit.FEET
                );

        assertEquals(
                expected,
                actual
        );
    }

    @Test
    void givenNullTargetUnit_ShouldThrowException() {

        Quantity feet =

                new Quantity(
                        1,
                        Unit.FEET
                );

        assertThrows(

                IllegalArgumentException.class,

                () -> feet.convertTo(
                        null
                )
        );
    }
}