package quantitymeasurement;

import java.util.Objects;

public class QuantityWeight {

    private static final double EPSILON = 0.01;

    private final double value;

    private final WeightUnit unit;

    public QuantityWeight(

            double value,

            WeightUnit unit

    ) {

        if (

                unit == null

        ) {

            throw new IllegalArgumentException(

                    "Unit cannot be null"

            );
        }

        if (

                !Double.isFinite(

                        value

                )

        ) {

            throw new IllegalArgumentException(

                    "Invalid value"

            );
        }

        this.value = value;

        this.unit = unit;
    }


    public QuantityWeight convertTo(

            WeightUnit targetUnit

    ) {

        if (

                targetUnit == null

        ) {

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

        return new QuantityWeight(

                convertedValue,

                targetUnit

        );
    }


    public QuantityWeight add(

            QuantityWeight other

    ) {

        return addInternal(

                other,

                unit

        );
    }


    public QuantityWeight add(

            QuantityWeight other,

            WeightUnit targetUnit

    ) {

        return addInternal(

                other,

                targetUnit

        );
    }


    private QuantityWeight addInternal(

            QuantityWeight other,

            WeightUnit targetUnit

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

        double result =

                targetUnit.fromBaseUnit(

                        total

                );

        return new QuantityWeight(

                result,

                targetUnit

        );
    }


    @Override

    public boolean equals(

            Object object

    ) {

        if (

                this == object

        ) {

            return true;
        }

        if (

                object == null ||

                        getClass()

                                !=

                                object.getClass()

        ) {

            return false;
        }

        QuantityWeight quantity =

                (QuantityWeight) object;

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