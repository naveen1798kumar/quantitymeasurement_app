package quantitymeasurement;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

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


    // ================= UC5 =================

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


    // ================= UC13 =================

    private enum ArithmeticOperation {

        ADD(

                (a, b)

                        ->

                        a + b

        ),

        SUBTRACT(

                (a, b)

                        ->

                        a - b

        ),

        DIVIDE(

                (a, b) -> {

                    if (

                            b == 0

                    ) {

                        throw new ArithmeticException(

                                "Cannot divide by zero"

                        );
                    }

                    return a / b;
                }

        );

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(

                DoubleBinaryOperator operation

        ) {

            this.operation = operation;
        }

        public double compute(

                double a,

                double b

        ) {

            return operation.applyAsDouble(

                    a,

                    b

            );
        }
    }


    private void validateArithmeticOperands(

            Quantity<U> other,

            U targetUnit,

            boolean targetUnitRequired

    ) {

        if (

                other == null

        ) {

            throw new IllegalArgumentException(

                    "Quantity cannot be null"

            );
        }

        if (

                unit.getClass()

                        !=

                        other.unit.getClass()

        ) {

            throw new IllegalArgumentException(

                    "Different categories are not allowed"

            );
        }

        if (

                targetUnitRequired

                        &&

                        targetUnit == null

        ) {

            throw new IllegalArgumentException(

                    "Target unit cannot be null"

            );
        }

        if (

                !Double.isFinite(

                        value

                )

                        ||

                        !Double.isFinite(

                                other.value

                        )

        ) {

            throw new IllegalArgumentException(

                    "Invalid value"

            );
        }
    }


    private double performBaseArithmetic(

            Quantity<U> other,

            ArithmeticOperation operation

    ) {

        double firstValue =

                unit.toBaseUnit(

                        value

                );

        double secondValue =

                other.unit.toBaseUnit(

                        other.value

                );

        return operation.compute(

                firstValue,

                secondValue

        );
    }

    // ================= UC6 =================

    public Quantity<U> add(

            Quantity<U> other

    ) {

        return add(

                other,

                unit

        );
    }


    public Quantity<U> add(

            Quantity<U> other,

            U targetUnit

    ) {

        validateArithmeticOperands(

                other,

                targetUnit,

                true

        );

        double result =

                performBaseArithmetic(

                        other,

                        ArithmeticOperation.ADD

                );

        double converted =

                targetUnit.fromBaseUnit(

                        result

                );

        return new Quantity<>(

                converted,
                targetUnit

        );
    }


    // ================= UC12 =================

    public Quantity<U> subtract(

            Quantity<U> other

    ) {

        return subtract(

                other,

                unit

        );
    }


    public Quantity<U> subtract(

            Quantity<U> other,

            U targetUnit

    ) {

        validateArithmeticOperands(

                other,

                targetUnit,

                true

        );

        double result =

                performBaseArithmetic(

                        other,

                        ArithmeticOperation.SUBTRACT

                );

        double converted =

                targetUnit.fromBaseUnit(

                        result

                );

        return new Quantity<>(

                converted,
                targetUnit

        );
    }


    // ================= UC12 =================

    public double divide(

            Quantity<U> other

    ) {

        validateArithmeticOperands(

                other,

                null,

                false

        );

        return performBaseArithmetic(

                other,

                ArithmeticOperation.DIVIDE

        );
    }


    // ================= Getters =================

    public double getValue() {

        return value;
    }

    public U getUnit() {

        return unit;
    }


    // ================= Equals =================

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

                object == null

                        ||

                        getClass()

                                !=

                                object.getClass()

        ) {

            return false;
        }

        Quantity<?> quantity =

                (Quantity<?>) object;

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


    // ================= Hashcode =================

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


    // ================= ToString =================

    @Override

    public String toString() {

        return value

                +

                " "

                +

                unit;
    }
}