package org.example;

import java.util.HashMap;
import java.util.Map;

public class InternationalCallCostCalculator implements CallCostCalculator {
    private final Map<String, Double> countryCosts;

    public InternationalCallCostCalculator() {
        this.countryCosts = new HashMap<>();

        countryCosts.put("United States", 1.30);
        countryCosts.put("Mexico", 1.25);
        countryCosts.put("Brazil",0.8);
        countryCosts.put("UK", 1.50);
        countryCosts.put("Spain", 1.45);
        //I've chosen a map in order to manage the different prices and more. It may also use a database or file (JSON) to read each price
    }

    @Override
    public double calculateCost(Call call) {
        String country = ((InternationalCall) call).getCountry();
        int duration = call.getDuration();

        Double costPerMinute = countryCosts.getOrDefault(country, 1.00); // default price

        return duration * costPerMinute;
    }
}
