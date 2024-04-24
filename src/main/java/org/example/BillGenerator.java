package org.example;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class BillGenerator {
    public static Bill createBillForMonth(YearMonth targetMonth, List<Call> allCalls) {
        //Filtered calls for the specific month
        List<Call> callsForMonth = allCalls.stream()
                .filter(call -> {
                    YearMonth callMonth = YearMonth.from(call.getCallTime());
                    return callMonth.equals(targetMonth);
                })
                .collect(Collectors.toList());

        // If there is no calls, returns null
        if (callsForMonth.isEmpty()) {
            System.out.println("No calls found for " + targetMonth);
            return null;
        }

        // Create new bill starting with the monthly basic fee
        Bill bill = new Bill(20.0); // I presume the basic fee is 20

        // Add the calls made in that month
        for (Call call : callsForMonth) {
            bill.addCall(call);
        }

        // Register the calculators for the various calls
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        calculatorFactory.registerCalculator(LocalCall.class, new LocalCallCostCalculator());
        calculatorFactory.registerCalculator(NationalCall.class, new NationalCallCostCalculator());
        calculatorFactory.registerCalculator(InternationalCall.class, new InternationalCallCostCalculator());

        // Establish the calculator factory to make up the bills
        bill.setCalculatorFactory(calculatorFactory);

        System.out.println("Bill for " + targetMonth.getMonth());
        System.out.println("-------------------");

        // Generate Bill
        bill.generateBill();

        return bill;
    }
}