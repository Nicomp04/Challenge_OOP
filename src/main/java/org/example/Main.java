package org.example;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create monthly bill with a basic fee of $20
        Bill bill = new Bill(20.0);

        LocalDateTime calltime = LocalDateTime.of(2024, 4, 22, 18, 30);
        // Add some calls to the bill
        bill.addCall(new LocalCall(10, calltime)); // Local call for 10 minutes
        bill.addCall(new NationalCall(5, "Cordoba",calltime)); // National call for 5 minutes to Buenos Aires
        bill.addCall(new InternationalCall(8, "Brazil",calltime)); // International call for 8 minutes to the United States

        // Create a calculator factory and register calculators for different types of calls
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        calculatorFactory.registerCalculator(LocalCall.class, new LocalCallCostCalculator());
        calculatorFactory.registerCalculator(NationalCall.class, new NationalCallCostCalculator());
        calculatorFactory.registerCalculator(InternationalCall.class, new InternationalCallCostCalculator());

        // Set the calculator factory for the bill
        bill.setCalculatorFactory(calculatorFactory);

        // Generate bill
        bill.generateBill();
    }
}
