package org.example;

import java.time.LocalDateTime;

public class LocalCall extends Call {
    public LocalCall(int duration, LocalDateTime callTime) {
        super(duration, callTime);
    }
}