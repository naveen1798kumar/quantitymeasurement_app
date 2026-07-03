package com.app.quantitymeasurement.integration;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementDatabaseRepositoryTest {

    private IQuantityMeasurementRepository repository;

    @BeforeEach
    void setUp() {

        repository = new QuantityMeasurementDatabaseRepository();

        repository.clear();

    }

    @Test
    void givenEmptyRepository_whenFindAll_thenShouldReturnEmptyList() {

        List<QuantityMeasurementEntity> entities = repository.findAll();

        assertTrue(entities.isEmpty());

    }

}