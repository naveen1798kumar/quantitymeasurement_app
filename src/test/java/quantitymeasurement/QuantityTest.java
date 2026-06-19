package quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

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

        assertNotNull(
                quantity
        );
    }

    @Test
    void givenSameReference_ShouldReturnTrue() {

        Quantity quantity =
                new Quantity(
                        1,
                        Unit.FEET
                );

        assertSame(
                quantity,
                quantity
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
}