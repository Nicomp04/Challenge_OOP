package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private double basicFee;
    private double total;
    private List<Call> calls;
    private CalculatorFactory calculatorFactory;

    public Bill(double basicFee) {
        this.basicFee = basicFee;
        this.calls = new ArrayList<>();
    }

    public void setCalculatorFactory(CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
    }

    public void addCall(Call call) {
        calls.add(call);
    }

    public void generateBill() {
        double totalBill = basicFee;

        // Calculate call costs using the specific strategy
        for (Call call : calls) {
            CallCostCalculator calculator = calculatorFactory.getCalculator(call); //Generate each calculator for the different types of calls
            totalBill += calculator.calculateCost(call);
        }

        this.total = totalBill;

        System.out.println("Monthly bill:");
        System.out.println("Basic fee: $" + basicFee);
        System.out.println("Total in calls: $" + (total - basicFee));
        System.out.println("Total to pay: $" + total);
    }

    public double getTotal() {return this.total;}
}
