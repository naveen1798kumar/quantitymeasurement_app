package quantitymeasurement;

import java.util.Objects;

public class Quantity {

    private final double value;

    private final Unit unit;

    private static final double EPSILON = 0.01;

    public Quantity(

            double value,

            Unit unit

    ) {

        if (unit == null) {

            throw new IllegalArgumentException(

                    "Unit cannot be null"

            );
        }

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(

                    "Invalid value"

            );
        }

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

                targetUnit.fromBaseUnit(

                        baseValue

                );

        return new Quantity(

                convertedValue,

                targetUnit

        );
    }


    // UC6

    public Quantity add(

            Quantity other

    ){
        return addInternal(
                other,
                unit
        );
    }

    public Quantity add(

            Quantity other,
            Unit targetUnit

    ){
        return addInternal(
                other,
                targetUnit
        );
    }

    private Quantity addInternal(

            Quantity other,

            Unit targetUnit

    ) {

        if (

                other == null

        ) {

            throw new IllegalArgumentException(

                    "Quantity cannot be null"

            );
        }

        if (

                targetUnit == null

        ) {

            throw new IllegalArgumentException(

                    "Target unit cannot be null"

            );
        }

        double firstValue =

                unit.toBaseUnit(

                        value

                );

        double secondValue =

                other.unit.toBaseUnit(

                        other.value

                );

        double total =

                firstValue

                        +

                        secondValue;

        double convertedResult =

                targetUnit.fromBaseUnit(

                        total

                );

        return new Quantity(

                convertedResult,

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

        if (this == object) {

            return true;
        }

        if (object == null ||

                getClass()

                        !=

                        object.getClass()

        ) {

            return false;
        }

        Quantity quantity =

                (Quantity) object;
//
//        return Double.compare(
//
//                unit.toBaseUnit(
//
//                        value
//
//                ),
//
//                quantity.unit.toBaseUnit(
//
//                        quantity.value
//
//                )
//
//        ) == 0;

        double firstValue =

                unit.toBaseUnit(

                        value

                );

        double secondValue =

                quantity.unit.toBaseUnit(

                        quantity.value

                );

        return Math.abs(

                firstValue

                        -

                        secondValue

        ) < EPSILON;
    }

    @Override

    public int hashCode() {

        return Objects.hash(

                Math.round(

                        unit.toBaseUnit(

                                value

                        )

                )
        );
    }

    @Override

    public String toString() {

        return value

                +

                " "

                +

                unit;
    }
}