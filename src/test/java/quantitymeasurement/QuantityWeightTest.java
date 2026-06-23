package quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    @Test

    void given1KgAnd1000Gram_ShouldReturnEqual() {

        Quantity<WeightUnit> kilogram =

                new Quantity<>(

                        1,

                        WeightUnit.KILOGRAM

                );

        Quantity<WeightUnit> gram =

                new Quantity<>(

                        1000,

                        WeightUnit.GRAM

                );

        assertEquals(

                kilogram,

                gram

        );
    }
}