package quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    // UC1
    @Test
    void given0FeetAnd0Feet_ShouldReturnEqual() {

        Quantity<Unit> first =
                new Quantity<>(
                        0,
                        Unit.FEET
                );

        Quantity<Unit> second =
                new Quantity<>(
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

        Quantity<Unit> first =
                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> second =
                new Quantity<>(
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

        Quantity<Unit> quantity =
                new Quantity<>(
                        1,
                        Unit.FEET
                );

        assertNotNull(
                quantity
        );
    }

    @Test
    void givenSameReference_ShouldReturnTrue() {

        Quantity<Unit> first =
                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> second =
                first;

        assertSame(
                first,
                second
        );
    }

    @Test
    void givenDifferentValue_ShouldReturnFalse() {

        Quantity<Unit> first =
                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> second =
                new Quantity<>(
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

        Quantity<Unit> feet =
                new Quantity<>(
                        0,
                        Unit.FEET
                );

        Quantity<Unit> inch =
                new Quantity<>(
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

        Quantity<Unit> feet =
                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> inch =
                new Quantity<>(
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

        Quantity<Unit> feet =
                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> inch =
                new Quantity<>(
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

        Quantity<Unit> feet =
                new Quantity<>(
                        3,
                        Unit.FEET
                );

        Quantity<Unit> yard =
                new Quantity<>(
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

        Quantity<Unit> centimeter =
                new Quantity<>(
                        100,
                        Unit.CENTIMETER
                );

        Quantity<Unit> inch =
                new Quantity<>(
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

        Quantity<Unit> centimeter =
                new Quantity<>(
                        30.48,
                        Unit.CENTIMETER
                );

        Quantity<Unit> feet =
                new Quantity<>(
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

        Quantity<Unit> yard =
                new Quantity<>(
                        1,
                        Unit.YARD
                );

        Quantity<Unit> inch =
                new Quantity<>(
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

        Quantity<Unit> feet =

                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> actual =

                feet.convertTo(
                        Unit.INCH
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> inch =

                new Quantity<>(
                        24,
                        Unit.INCH
                );

        Quantity<Unit> actual =

                inch.convertTo(
                        Unit.FEET
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> yard =

                new Quantity<>(
                        1,
                        Unit.YARD
                );

        Quantity<Unit> actual =

                yard.convertTo(
                        Unit.INCH
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> inch =

                new Quantity<>(
                        36,
                        Unit.INCH
                );

        Quantity<Unit> actual =

                inch.convertTo(
                        Unit.YARD
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> centimeter =

                new Quantity<>(
                        30.48,
                        Unit.CENTIMETER
                );

        Quantity<Unit> actual =

                centimeter.convertTo(
                        Unit.FEET
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> feet =

                new Quantity<>(
                        6,
                        Unit.FEET
                );

        Quantity<Unit> actual =

                feet.convertTo(
                        Unit.YARD
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> feet =

                new Quantity<>(
                        0,
                        Unit.FEET
                );

        Quantity<Unit> actual =

                feet.convertTo(
                        Unit.INCH
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> feet =

                new Quantity<>(
                        -1,
                        Unit.FEET
                );

        Quantity<Unit> actual =

                feet.convertTo(
                        Unit.INCH
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> feet =

                new Quantity<>(
                        1,
                        Unit.FEET
                );

        Quantity<Unit> actual =

                feet.convertTo(
                        Unit.FEET
                );

        Quantity<Unit> expected =

                new Quantity<>(
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

        Quantity<Unit> feet =

                new Quantity<>(
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

    @Test

    void addFeetPlusFeet() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        1,

                        Unit.FEET

                );

        Quantity<Unit> q2 =

                new Quantity<>(

                        2,

                        Unit.FEET

                );

        Quantity<Unit> expected =

                new Quantity<>(

                        3,

                        Unit.FEET

                );

        assertEquals(

                expected,

                q1.add(q2)

        );
    }

    @Test

    void addFeetPlusInches() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        1,

                        Unit.FEET

                );

        Quantity<Unit> q2 =

                new Quantity<>(

                        12,

                        Unit.INCH

                );

        Quantity<Unit> expected =

                new Quantity<>(

                        2,

                        Unit.FEET

                );

        assertEquals(

                expected,

                q1.add(q2)

        );
    }

    @Test

    void addInchesPlusFeet() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        12,

                        Unit.INCH

                );

        Quantity<Unit> q2 =

                new Quantity<>(

                        1,

                        Unit.FEET

                );

        Quantity<Unit> expected =

                new Quantity<>(

                        24,

                        Unit.INCH

                );

        assertEquals(

                expected,

                q1.add(q2)

        );
    }

    @Test

    void addYardPlusFeet() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        1,

                        Unit.YARD

                );

        Quantity<Unit> q2 =

                new Quantity<>(

                        3,

                        Unit.FEET

                );

        Quantity<Unit> expected =

                new Quantity<>(

                        2,

                        Unit.YARD

                );

        assertEquals(

                expected,

                q1.add(q2)

        );
    }

    @Test

    void addCentimeterPlusInch() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        2.54,

                        Unit.CENTIMETER

                );

        Quantity<Unit> q2 =

                new Quantity<>(

                        1,

                        Unit.INCH

                );

        Quantity<Unit> expected =

                new Quantity<>(

                        5.08,

                        Unit.CENTIMETER

                );

        assertEquals(

                expected,

                q1.add(q2)

        );
    }

    @Test

    void addZero() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        5,

                        Unit.FEET

                );

        Quantity<Unit> q2 =

                new Quantity<>(

                        0,

                        Unit.INCH

                );

        Quantity<Unit> expected =

                new Quantity<>(

                        5,

                        Unit.FEET

                );

        assertEquals(

                expected,

                q1.add(q2)

        );
    }

    @Test

    void addNullQuantity() {

        Quantity<Unit> q1 =

                new Quantity<>(

                        1,

                        Unit.FEET

                );

        assertThrows(

                IllegalArgumentException.class,

                () -> q1.add(null)

        );
    }

//    UC 7 Test Case

    @Test

    void testAddition_ExplicitTargetUnit_Feet() {

        Quantity<Unit> result =

                new Quantity<>(
                        1,
                        Unit.FEET
                )

                        .add(

                                new Quantity<>(
                                        12,
                                        Unit.INCH
                                ),

                                Unit.FEET
                        );

        assertEquals(

                new Quantity<>(
                        2,
                        Unit.FEET
                ),

                result
        );
    }


    @Test

    void testAddition_ExplicitTargetUnit_Inches() {

        Quantity<Unit> result =

                new Quantity<>(
                        1,
                        Unit.FEET
                )

                        .add(

                                new Quantity<>(
                                        12,
                                        Unit.INCH
                                ),

                                Unit.INCH
                        );

        assertEquals(

                new Quantity<>(
                        24,
                        Unit.INCH
                ),

                result
        );
    }


    @Test

    void testAddition_ExplicitTargetUnit_Yards() {

        Quantity<Unit> result =

                new Quantity<>(
                        1,
                        Unit.FEET
                )

                        .add(

                                new Quantity<>(
                                        12,
                                        Unit.INCH
                                ),

                                Unit.YARD
                        );

        assertEquals(

                new Quantity<>(
                        0.6666667,
                        Unit.YARD
                ),

                result
        );
    }


    @Test

    void testAddition_ExplicitTargetUnit_Centimeters() {

        Quantity<Unit> result =

                new Quantity<>(
                        1,
                        Unit.INCH
                )

                        .add(

                                new Quantity<>(
                                        1,
                                        Unit.INCH
                                ),

                                Unit.CENTIMETER
                        );

        assertEquals(

                new Quantity<>(
                        5.08,
                        Unit.CENTIMETER
                ),

                result
        );
    }


    @Test

    void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        assertThrows(

                IllegalArgumentException.class,

                () ->

                        new Quantity<>(
                                1,
                                Unit.FEET
                        )

                                .add(

                                        new Quantity<>(
                                                12,
                                                Unit.INCH
                                        ),

                                        null
                                )

        );
    }

//    UC 8 Test Case

    @Test

    void testFeetBaseConversion() {

        assertEquals(

                30.48,

                Unit.FEET.toBaseUnit(

                        1

                )

        );
    }

    @Test

    void testInchBaseConversion() {

        assertEquals(

                30.48,

                Unit.INCH.toBaseUnit(

                        12

                )

        );
    }

    @Test

    void testYardBaseConversion() {

        assertEquals(

                91.44,

                Unit.YARD.toBaseUnit(

                        1

                )

        );
    }

    @Test

    void testCentimeterBaseConversion() {

        assertEquals(

                30.48,

                Unit.CENTIMETER.toBaseUnit(

                        30.48

                )

        );
    }

    @Test

    void testBaseToFeet() {

        assertEquals(

                2,

                Unit.FEET.fromBaseUnit(

                        60.96

                )

        );
    }

    @Test

    void testBaseToInches() {

        assertEquals(

                12,

                Unit.INCH.fromBaseUnit(

                        30.48

                )

        );
    }

    @Test

    void testBaseToYards() {

        assertEquals(

                1,

                Unit.YARD.fromBaseUnit(

                        91.44

                )

        );
    }
}