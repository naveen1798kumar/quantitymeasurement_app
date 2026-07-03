package com.app.quantitymeasurement.entity;

import java.time.LocalDateTime;

public class QuantityMeasurementEntity {

    private Quantity<?> firstQuantity;

    private Quantity<?> secondQuantity;

    private String operation;

    private String result;

    private Long id;

    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    };

    public void setId(Long id){
        this.id = id;
    };

    public QuantityMeasurementEntity(

            Quantity<?> firstQuantity,

            Quantity<?> secondQuantity,

            String operation,

            String result

    ) {

        this.firstQuantity = firstQuantity;
        this.secondQuantity = secondQuantity;
        this.operation = operation;
        this.result = result;
        this.createdAt = LocalDateTime.now();

    }

    public Quantity<?> getFirstQuantity() {

        return firstQuantity;

    }

    public void setFirstQuantity(

            Quantity<?> firstQuantity

    ) {

        this.firstQuantity = firstQuantity;

    }

    public Quantity<?> getSecondQuantity() {

        return secondQuantity;

    }

    public void setSecondQuantity(

            Quantity<?> secondQuantity

    ) {

        this.secondQuantity = secondQuantity;

    }

    public String getOperation() {

        return operation;

    }

    public void setOperation(

            String operation

    ) {

        this.operation = operation;

    }

    public String getResult() {

        return result;

    }

    public void setResult(

            String result

    ) {

        this.result = result;

    }

    public LocalDateTime getCreatedAt() {

        return createdAt;

    }

    public void setCreatedAt(

            LocalDateTime createdAt

    ) {

        this.createdAt = createdAt;

    }

    @Override

    public String toString() {

        return "QuantityMeasurementEntity{" +

                "firstQuantity=" + firstQuantity +

                ", secondQuantity=" + secondQuantity +

                ", operation='" + operation + '\'' +

                ", result=" + result +

                ", createdAt=" + createdAt +

                '}';

    }



}