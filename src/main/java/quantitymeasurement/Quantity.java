package quantitymeasurement;

import java.util.Objects;

public class Quantity {
    private double value;
    private Unit unit;

    public Quantity(double value,
    Unit unit
    ) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;

        if(getClass()
                !=object.getClass()
        ){
            return false;
        }

        Quantity quantity = (Quantity) object;
        return Double.compare(quantity.value, value) == 0
                &&
                unit == quantity.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
