package org.example;

import java.time.DayOfWeek;

public class LocalCallCostCalculator implements CallCostCalculator {
    @Override
    public double calculateCost(Call call) {
        // Assuming the cost for local calls is $0.20 per minute during business hours (8 AM to 8 PM) on weekdays
        // and $0.10 per minute for the rest of the time including weekends
        int duration = call.getDuration();
        double costPerMinute = (isBusinessHours(call) && isWeekday(call)) ? 0.20 : 0.10;

        return duration * costPerMinute;
    }

    private boolean isBusinessHours(Call call) {
        int hour = call.getCallTime().getHour();

        return 8 <= hour && hour < 20; // 19:59 is max
    }

    private boolean isWeekday(Call call) {
            DayOfWeek dayOfWeek = call.getCallTime().getDayOfWeek();
            return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

}
