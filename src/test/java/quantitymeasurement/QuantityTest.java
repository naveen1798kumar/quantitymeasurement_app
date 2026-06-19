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
}