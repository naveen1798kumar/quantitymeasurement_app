package quantitymeasurement;

import java.util.Objects;

public class Quantity {

    private final double value;

    private final Unit unit;

    public Quantity(
            double value,

            Unit unit
    ) {

        this.value = value;

        this.unit = unit;
    }

    @Override
    public boolean equals(
            Object object
    ) {

        // Same reference

        if (this == object) {

            return true;
        }

        // Null check

        if (object == null) {

            return false;
        }

        // Type check

        if (getClass() != object.getClass()) {

            return false;
        }

        Quantity quantity =
                (Quantity) object;

        // Compare after conversion

        return Double.compare(

                unit.toBaseUnit(
                        value
                ),

                quantity.unit.toBaseUnit(
                        quantity.value
                )

        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(

                unit.toBaseUnit(
                        value
                )

        );
    }
}