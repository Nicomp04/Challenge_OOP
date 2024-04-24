package org.example;

import java.util.HashMap;
import java.util.Map;

public class NationalCallCostCalculator implements CallCostCalculator {
    private final Map<String, Double> localityCosts;

    public NationalCallCostCalculator() {
        this.localityCosts = new HashMap<>();

        localityCosts.put("Buenos Aires", 0.30);
        localityCosts.put("Cordoba", 0.25);
        localityCosts.put("Santa fe",0.25);
        localityCosts.put("Santa Cruz", 0.50);
        localityCosts.put("Chubut", 0.45);
        localityCosts.put("Catamarca",0.35);
        localityCosts.put("Salta", 0.30);
        localityCosts.put("Jujuy", 0.30);
        localityCosts.put("Corrientes",0.25);
        //I've chosen a map in order to manage the different prices and more. It may also use a database or file (JSON) to read each price
    }
    @Override
    public double calculateCost(Call call) {
        NationalCall nationalCall = (NationalCall) call;
        String locality = nationalCall.getLocality();

        Double costPerMinute = localityCosts.getOrDefault(locality, 0.20); // default price

        return call.getDuration() * costPerMinute;
    }
}
