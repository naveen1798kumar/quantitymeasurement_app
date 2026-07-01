package quantitymeasurement;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(

            IQuantityMeasurementService service

    ) {

        if (

                service == null

        ) {

            throw new IllegalArgumentException(

                    "Service cannot be null"

            );

        }

        this.service = service;
    }

    // ==========================
    // Convert
    // ==========================

    public <U extends IMeasurable> Quantity<U> convert(

            Quantity<U> quantity,

            U targetUnit

    ) {

        return service.convert(

                quantity,

                targetUnit

        );
    }

    // ==========================
    // Compare
    // ==========================

    public <U extends IMeasurable> boolean compare(

            Quantity<U> first,

            Quantity<U> second

    ) {

        return service.compare(

                first,

                second

        );
    }

    // ==========================
    // Add
    // ==========================

    public <U extends IMeasurable> Quantity<U> add(

            Quantity<U> first,

            Quantity<U> second

    ) {

        return service.add(

                first,

                second

        );
    }

    public <U extends IMeasurable> Quantity<U> add(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit

    ) {

        return service.add(

                first,

                second,

                targetUnit

        );
    }

    // ==========================
    // Subtract
    // ==========================

    public <U extends IMeasurable> Quantity<U> subtract(

            Quantity<U> first,

            Quantity<U> second

    ) {

        return service.subtract(

                first,

                second

        );
    }

    public <U extends IMeasurable> Quantity<U> subtract(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit

    ) {

        return service.subtract(

                first,

                second,

                targetUnit

        );
    }

    // ==========================
    // Divide
    // ==========================

    public <U extends IMeasurable> double divide(

            Quantity<U> first,

            Quantity<U> second

    ) {

        return service.divide(

                first,

                second

        );
    }
}