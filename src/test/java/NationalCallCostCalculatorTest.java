import org.example.NationalCall;
import org.example.NationalCallCostCalculator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class NationalCallCostCalculatorTest {

    @Test
    public void testCalculateCostForBuenosAires() {
        NationalCallCostCalculator calculator = new NationalCallCostCalculator();
        LocalDateTime callTime = LocalDateTime.of(2024, 4, 22, 18, 30);
        NationalCall callToBuenosAires = new NationalCall(10, "Buenos Aires", callTime);
        assertEquals(3.0, calculator.calculateCost(callToBuenosAires),0.001); // $0.30 per minute to Buenos Aires
    }

    @Test
    public void testCalculateCostForCordoba() {
        NationalCallCostCalculator calculator = new NationalCallCostCalculator();
        LocalDateTime callTime = LocalDateTime.of(2024, 4, 22, 18, 30);
        NationalCall callToCordoba = new NationalCall(8, "Cordoba", callTime);
        assertEquals(2.0, calculator.calculateCost(callToCordoba), 0.001); // $0.25 per minute to Cordoba
    }

}
