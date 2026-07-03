package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.unit.IMeasurable;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.entity.Quantity;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(

            IQuantityMeasurementRepository repository

    ) {

        if (repository == null) {

            throw new IllegalArgumentException(

                    "Repository cannot be null"

            );
        }

        this.repository = repository;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> convert(

            Quantity<U> quantity,

            U targetUnit

    ) {

        if (quantity == null) {

            throw new IllegalArgumentException(

                    "Quantity cannot be null"

            );
        }

        Quantity<U> result =

                quantity.convertTo(

                        targetUnit

                );

        repository.save(

                new QuantityMeasurementEntity(

                        quantity,

                        null,

                        "CONVERT",

                        result.toString()

                )

        );

        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> add(

            Quantity<U> first,

            Quantity<U> second

    ) {

        validate(

                first,

                second

        );

        Quantity<U> result =

                first.add(

                        second

                );

        repository.save(

                new QuantityMeasurementEntity(

                        first,

                        second,

                        "ADD",

                        result.toString()

                )

        );

        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> add(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit

    ) {

        validate(

                first,

                second

        );

        Quantity<U> result =

                first.add(

                        second,

                        targetUnit

                );

        repository.save(

                new QuantityMeasurementEntity(

                        first,

                        second,

                        "ADD",

                        result.toString()

                )

        );

        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> subtract(

            Quantity<U> first,

            Quantity<U> second

    ) {

        validate(

                first,

                second

        );

        Quantity<U> result =

                first.subtract(

                        second

                );

        repository.save(

                new QuantityMeasurementEntity(

                        first,

                        second,

                        "SUBTRACT",

                        result.toString()

                )

        );

        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> subtract(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit

    ) {

        validate(

                first,

                second

        );

        Quantity<U> result =

                first.subtract(

                        second,

                        targetUnit

                );

        repository.save(

                new QuantityMeasurementEntity(

                        first,

                        second,

                        "SUBTRACT",

                        result.toString()

                )

        );

        return result;
    }

    @Override
    public <U extends IMeasurable> double divide(

            Quantity<U> first,

            Quantity<U> second

    ) {

        validate(

                first,

                second

        );

        double result =

                first.divide(

                        second

                );

        repository.save(

                new QuantityMeasurementEntity(

                        first,

                        second,

                        "DIVIDE",

                        String.valueOf(result)

                )

        );

        return result;
    }

    @Override
    public <U extends IMeasurable> boolean compare(

            Quantity<U> first,

            Quantity<U> second

    ) {

        validate(

                first,

                second

        );

        boolean result =

                first.equals(

                        second

                );

        repository.save(

                new QuantityMeasurementEntity(

                        first,

                        second,

                        "COMPARE",

                        String.valueOf(result)

                )

        );

        return result;
    }

    private <U extends IMeasurable> void validate(

            Quantity<U> first,

            Quantity<U> second

    ) {

        if (first == null) {

            throw new IllegalArgumentException(

                    "First quantity cannot be null"

            );
        }

        if (second == null) {

            throw new IllegalArgumentException(

                    "Second quantity cannot be null"

            );
        }
    }
}