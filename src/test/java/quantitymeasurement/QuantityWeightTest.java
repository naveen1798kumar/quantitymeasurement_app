package quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    @Test

    void given1KgAnd1000Gram_ShouldReturnEqual() {

        QuantityWeight kilogram =

                new QuantityWeight(

                        1,

                        WeightUnit.KILOGRAM

                );

        QuantityWeight gram =

                new QuantityWeight(

                        1000,

                        WeightUnit.GRAM

                );

        assertEquals(

                kilogram,

                gram

        );
    }
}