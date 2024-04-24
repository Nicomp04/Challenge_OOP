package org.example;

import java.util.HashMap;
import java.util.Map;

public class CalculatorFactory {
    private Map<Class<? extends Call>, CallCostCalculator> calculators; //mapping for the calculators

    public CalculatorFactory() {
        this.calculators = new HashMap<>();
    }

    public void registerCalculator(Class<? extends Call> callClass, CallCostCalculator calculator) {
        calculators.put(callClass, calculator);
    }

    public CallCostCalculator getCalculator(Call call) {
        CallCostCalculator calculator = calculators.get(call.getClass());
        if (calculator == null) {
            throw new IllegalArgumentException("No calculator found for the provided call class");
        }
        return calculator;
    }
}
