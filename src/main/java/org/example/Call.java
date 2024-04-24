package org.example;

import java.time.LocalDateTime;

public class Call {
    private int duration; // Duration of call
    private LocalDateTime callTime; // date and hour

    public Call(int duration, LocalDateTime callTime) {
        this.duration = duration;
        this.callTime = callTime;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getCallTime(){return callTime;}
}
