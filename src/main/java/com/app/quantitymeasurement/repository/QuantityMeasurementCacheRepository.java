package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    private final List<QuantityMeasurementEntity> cache;

    public QuantityMeasurementCacheRepository() {

        this.cache = new ArrayList<>();

    }

    @Override
    public void save(

            QuantityMeasurementEntity entity

    ) {

        if (

                entity == null

        ) {

            throw new IllegalArgumentException(

                    "Entity cannot be null"

            );

        }

        cache.add(

                entity

        );
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        return Collections.unmodifiableList(

                cache

        );

    }

    @Override
    public void clear() {

        cache.clear();

    }

    public int size() {

        return cache.size();

    }

}