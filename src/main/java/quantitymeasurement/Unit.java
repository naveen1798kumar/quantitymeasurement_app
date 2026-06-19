package quantitymeasurement;

public enum Unit {

    FEET(12),

    INCH(1),

    YARD(36);

    private final double conversionFactor;

    Unit(double conversionFactor) {

        this.conversionFactor =
                conversionFactor;
    }

    public double toBaseUnit(
            double value
    ) {

        return value
                * conversionFactor;
    }
}