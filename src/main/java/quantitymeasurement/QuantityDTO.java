package quantitymeasurement;

public class QuantityDTO {

    private double value;

    private IMeasurableUnit unit;

    public QuantityDTO(
            double value,
            IMeasurableUnit unit
    ) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(
            double value
    ) {
        this.value = value;
    }

    public IMeasurableUnit getUnit() {
        return unit;
    }

    public void setUnit(
            IMeasurableUnit unit
    ) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "QuantityDTO{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    /*
     * DTO Interface
     */
    public interface IMeasurableUnit {

        String getMeasurementType();

        String getUnitName();

    }

    /*
     * Length Units
     */
    public enum LengthUnit implements IMeasurableUnit {

        FEET,
        INCH,
        YARD,
        CENTIMETER;

        @Override
        public String getMeasurementType() {
            return "LENGTH";
        }

        @Override
        public String getUnitName() {
            return name();
        }
    }

    /*
     * Weight Units
     */
    public enum WeightUnit implements IMeasurableUnit {

        KILOGRAM,
        GRAM,
        POUND;

        @Override
        public String getMeasurementType() {
            return "WEIGHT";
        }

        @Override
        public String getUnitName() {
            return name();
        }
    }

    /*
     * Volume Units
     */
    public enum VolumeUnit implements IMeasurableUnit {

        LITRE,
        MILLILITRE,
        GALLON;

        @Override
        public String getMeasurementType() {
            return "VOLUME";
        }

        @Override
        public String getUnitName() {
            return name();
        }
    }

    /*
     * Temperature Units
     */
    public enum TemperatureUnit implements IMeasurableUnit {

        CELSIUS,
        FAHRENHEIT,
        KELVIN;

        @Override
        public String getMeasurementType() {
            return "TEMPERATURE";
        }

        @Override
        public String getUnitName() {
            return name();
        }
    }
}