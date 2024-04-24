package org.example;

import java.time.LocalDateTime;

public class NationalCall extends Call {
    private String locality;

    public NationalCall(int duration, String locality, LocalDateTime calltime) {
        super(duration, calltime);
        this.locality = locality;
    }

    public String getLocality() {
        return locality;
    }
}
