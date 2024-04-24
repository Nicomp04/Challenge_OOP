import org.example.InternationalCall;
import org.example.InternationalCallCostCalculator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class InternationalCostCallCalculatorTest {

    @Test
    public void testCalculateUSCost() {
        // Create an instance of InternationalCallCostCalculator
        InternationalCallCostCalculator calculator = new InternationalCallCostCalculator();

        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        // Create sample international calls
        InternationalCall callToUS = new InternationalCall(10, "United States",callTime);

        assertEquals(13.0, calculator.calculateCost(callToUS),0.001); // $1.30 per minute to US
    }

    @Test
    public void testCalculateMexicoCost() {
        // Create an instance of InternationalCallCostCalculator
        InternationalCallCostCalculator calculator = new InternationalCallCostCalculator();

        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        // Create sample international calls
        InternationalCall callToMexico = new InternationalCall(8, "Mexico",callTime);
        assertEquals(10.0, calculator.calculateCost(callToMexico),0.001); // $1.25 per minute to Mexico
    }

    @Test
    public void testCalculateBrazilCost() {
        // Create an instance of InternationalCallCostCalculator
        InternationalCallCostCalculator calculator = new InternationalCallCostCalculator();

        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        // Create sample international calls
        InternationalCall callToMexico = new InternationalCall(8, "Mexico",callTime);

        InternationalCall callToBrazil = new InternationalCall(5, "Brazil",callTime);

        assertEquals(4.0, calculator.calculateCost(callToBrazil),0.001); // $0.80 per minute to Brazil
    }

    @Test
    public void testCalculateCost() {
        // Create an instance of InternationalCallCostCalculator
        InternationalCallCostCalculator calculator = new InternationalCallCostCalculator();

        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        // Create sample international calls
        InternationalCall callToUS = new InternationalCall(10, "United States",callTime);
        InternationalCall callToMexico = new InternationalCall(8, "Mexico",callTime);
        InternationalCall callToBrazil = new InternationalCall(5, "Brazil",callTime);
        InternationalCall callToUK = new InternationalCall(12, "UK",callTime);
        InternationalCall callToSpain = new InternationalCall(15, "Spain",callTime);

        // Verify the cost calculation for each call
        assertEquals(13.0, calculator.calculateCost(callToUS),0.001); // $1.30 per minute to US
        assertEquals(10.0, calculator.calculateCost(callToMexico),0.001); // $1.25 per minute to Mexico
        assertEquals(4.0, calculator.calculateCost(callToBrazil),0.001); // $0.80 per minute to Brazil
        assertEquals(18.0, calculator.calculateCost(callToUK),0.001); // $1.50 per minute to UK
        assertEquals(21.75, calculator.calculateCost(callToSpain),0.001); // $1.45 per minute to Spain
    }
}
