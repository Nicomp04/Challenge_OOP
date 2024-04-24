import org.example.Call;
import org.example.LocalCall;
import org.example.LocalCallCostCalculator;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class LocalCallCostCalculatorTest {

    @Test
    public void testCalculateCostDuringBusinessHoursOnWeekdays() {
        LocalCallCostCalculator calculator = new LocalCallCostCalculator();
        LocalDateTime businessHourWeekdayCallTime = LocalDateTime.of(2024, Month.APRIL, 23, 10, 0);
        Call businessHourWeekdayCall = new LocalCall(10, businessHourWeekdayCallTime);
        assertEquals(2.0, calculator.calculateCost(businessHourWeekdayCall),0.001); // 10 minutes * $0.20 per minute = $2.0
    }

    @Test
    public void testCalculateCostOutsideBusinessHoursOnWeekdays() {
        LocalCallCostCalculator calculator = new LocalCallCostCalculator();
        LocalDateTime outsideBusinessHourWeekdayCallTime = LocalDateTime.of(2024, Month.APRIL, 23, 20, 30);
        Call outsideBusinessHourWeekdayCall = new LocalCall(10, outsideBusinessHourWeekdayCallTime);
        assertEquals(1.0, calculator.calculateCost(outsideBusinessHourWeekdayCall),0.001); // 10 minutes * $0.10 per minute = $1.0
    }

    @Test
    public void testCalculateCostDuringBusinessHoursOnWeekends() {
        LocalCallCostCalculator calculator = new LocalCallCostCalculator();
        LocalDateTime businessHourWeekendCallTime = LocalDateTime.of(2024, Month.APRIL, 27, 12, 0);
        Call businessHourWeekendCall = new LocalCall(10, businessHourWeekendCallTime);
        assertEquals(2.0, calculator.calculateCost(businessHourWeekendCall),0.001); // 10 minutes * $0.20 per minute = $2.0
    }

    @Test
    public void testCalculateCostOutsideBusinessHoursOnWeekends() {
        LocalCallCostCalculator calculator = new LocalCallCostCalculator();
        LocalDateTime outsideBusinessHourWeekendCallTime = LocalDateTime.of(2024, Month.APRIL, 28, 22, 0);
        Call outsideBusinessHourWeekendCall = new LocalCall(10, outsideBusinessHourWeekendCallTime);
        assertEquals(1.0, calculator.calculateCost(outsideBusinessHourWeekendCall),0.001); // 10 minutes * $0.10 per minute = $1.0
    }
}
