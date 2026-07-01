package quantitymeasurement;

public interface IQuantityMeasurementService {

    <U extends IMeasurable> Quantity<U> convert(

            Quantity<U> quantity,

            U targetUnit

    );

    <U extends IMeasurable> Quantity<U> add(

            Quantity<U> first,

            Quantity<U> second

    );

    <U extends IMeasurable> Quantity<U> add(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit

    );

    <U extends IMeasurable> Quantity<U> subtract(

            Quantity<U> first,

            Quantity<U> second

    );

    <U extends IMeasurable> Quantity<U> subtract(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit

    );

    <U extends IMeasurable> double divide(

            Quantity<U> first,

            Quantity<U> second

    );

    <U extends IMeasurable> boolean compare(

            Quantity<U> first,

            Quantity<U> second

    );

}