package org.example;

import java.time.LocalDateTime;

public class InternationalCall extends Call {
    private String country;

    public InternationalCall(int duration, String country, LocalDateTime calltime) {
        super(duration,calltime);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}