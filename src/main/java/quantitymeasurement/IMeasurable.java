package quantitymeasurement;

public interface IMeasurable {

    double getConversionFactor();

    double toBaseUnit(

            double value

    );

    double fromBaseUnit(

            double value

    );

    String getUnitName();
}