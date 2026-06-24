package quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;

    private final U unit;

    private static final double EPSILON = 0.01;

    public Quantity(

            double value,

            U unit

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

    public Quantity<U> convertTo(

            U targetUnit

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

        return new Quantity<>(

                convertedValue,

                targetUnit

        );
    }


    // UC6

    public Quantity<U> add(

            Quantity<U> other

    ){
        return addInternal(
                other,
                unit
        );
    }

    public Quantity<U> add(

            Quantity<U> other,
            U targetUnit

    ){
        return addInternal(
                other,
                targetUnit
        );
    }

    private Quantity<U> addInternal(

            Quantity<U> other,

            U targetUnit

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

        return new Quantity<>(

                convertedResult,

                targetUnit

        );
    }


//    UC 12 Subtract usecase
public Quantity<U> subtract(

        Quantity<U> other

){

    return subtractInternal(

            other,

            unit

    );
}


    public Quantity<U> subtract(

            Quantity<U> other,

            U targetUnit

    ){

        return subtractInternal(

                other,

                targetUnit

        );
    }

    private Quantity<U> subtractInternal(

            Quantity<U> other,

            U targetUnit

    ){

        if (

                other == null

        ){

            throw new IllegalArgumentException(

                    "Quantity cannot be null"

            );
        }

        if (

                targetUnit == null

        ){

            throw new IllegalArgumentException(

                    "Target unit cannot be null"

            );
        }


        if (

                unit.getClass()

                        !=

                        other.unit.getClass()

        ){

            throw new IllegalArgumentException(

                    "Different categories cannot be subtracted"

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


        double result =

                firstValue

                        -

                        secondValue;


        double convertedResult =

                targetUnit.fromBaseUnit(

                        result

                );


        convertedResult =

                Math.round(

                        convertedResult

                                * 100

                )

                        / 100.0;


        return new Quantity<>(

                convertedResult,

                targetUnit

        );
    }

//    UC12 Division

    public double divide(

            Quantity<U> other

    ){

        if (

                other == null

        ){

            throw new IllegalArgumentException(

                    "Quantity cannot be null"

            );
        }


        if (

                unit.getClass()

                        !=

                        other.unit.getClass()

        ){

            throw new IllegalArgumentException(

                    "Different categories cannot be divided"

            );
        }


        double divisor =

                other.unit.toBaseUnit(

                        other.value

                );


        if (

                divisor == 0

        ){

            throw new ArithmeticException(

                    "Cannot divide by zero"

            );
        }


        double dividend =

                unit.toBaseUnit(

                        value

                );


        return dividend

                /

                divisor;
    }

    public double getValue() {

        return value;
    }

    public U getUnit() {

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
                getClass() != object.getClass()
        ) {

            return false;
        }

        Quantity<?> quantity =

                (Quantity<?>) object;
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


        if (

                unit.getClass()

                        !=

                        quantity.unit.getClass()

        ) {

            return false;
        }

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