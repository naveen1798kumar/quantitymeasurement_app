package quantitymeasurement;

import java.time.LocalDateTime;

public class QuantityMeasurementEntity {

    private Quantity<?> firstQuantity;

    private Quantity<?> secondQuantity;

    private String operation;

    private Object result;

    private LocalDateTime createdAt;

    public QuantityMeasurementEntity(

            Quantity<?> firstQuantity,

            Quantity<?> secondQuantity,

            String operation,

            Object result

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

    public Object getResult() {

        return result;

    }

    public void setResult(

            Object result

    ) {

        this.result = result;

    }

    public LocalDateTime getCreatedAt() {

        return createdAt;

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