package quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ==========================
        // Repository Layer
        // ==========================

        IQuantityMeasurementRepository repository =

                new QuantityMeasurementCacheRepository();

        // ==========================
        // Service Layer
        // ==========================

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        repository

                );

        // ==========================
        // Controller Layer
        // ==========================

        QuantityMeasurementController controller =

                new QuantityMeasurementController(

                        service

                );

        // ==========================
        // Sample Length Quantities
        // ==========================

        Quantity<Unit> oneFeet =

                new Quantity<>(

                        1,

                        Unit.FEET

                );

        Quantity<Unit> twelveInch =

                new Quantity<>(

                        12,

                        Unit.INCH

                );

        // ==========================
        // Compare
        // ==========================

        System.out.println(

                "Compare : "

                        +

                        controller.compare(

                                oneFeet,

                                twelveInch

                        )

        );

        // ==========================
        // Convert
        // ==========================

        System.out.println(

                "Convert : "

                        +

                        controller.convert(

                                oneFeet,

                                Unit.INCH

                        )

        );

        // ==========================
        // Add
        // ==========================

        System.out.println(

                "Add : "

                        +

                        controller.add(

                                oneFeet,

                                twelveInch

                        )

        );

        // ==========================
        // Add with Target Unit
        // ==========================

        System.out.println(

                "Add (Inches) : "

                        +

                        controller.add(

                                oneFeet,

                                twelveInch,

                                Unit.INCH

                        )

        );

        // ==========================
        // Subtract
        // ==========================

        System.out.println(

                "Subtract : "

                        +

                        controller.subtract(

                                oneFeet,

                                twelveInch

                        )

        );

        // ==========================
        // Divide
        // ==========================

        System.out.println(

                "Divide : "

                        +

                        controller.divide(

                                new Quantity<>(

                                        24,

                                        Unit.INCH

                                ),

                                new Quantity<>(

                                        12,

                                        Unit.INCH

                                )

                        )

        );

        // ==========================
        // Repository History
        // ==========================

        System.out.println();

        System.out.println(

                "========= Repository History ========="

        );

        repository.findAll()

                .forEach(

                        System.out::println

                );

    }
}