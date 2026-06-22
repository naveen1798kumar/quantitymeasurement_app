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

    public Quantity convertTo(

            Unit targetUnit

    ) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(

                    "Target unit cannot be null"

            );
        }

        double baseValue =

                unit.toBaseUnit(
                        value
                );

        double convertedValue =

                baseValue

                        /

                        targetUnit.getConversionFactor();

        return new Quantity(

                convertedValue,

                targetUnit

        );
    }

    public double getValue() {

        return value;
    }

    public Unit getUnit() {

        return unit;
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

    @Override
    public String toString() {

        return value + " " + unit;
    }

}