package quantitymeasurement;

public enum Unit implements IMeasurable{

    FEET(30.48),

    INCH(2.54),

    YARD(91.44),

    CENTIMETER(1);

    private final double conversionFactor;

    Unit(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit(

            double value

    ) {

        return value

                * conversionFactor;
    }

    public double fromBaseUnit(

            double value

    ) {

        return value

                / conversionFactor;
    }

    public double getConversionFactor() {

        return conversionFactor;
    }

    @Override

    public String getUnitName() {

        return name();
    }
}