import org.example.*;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorFactoryTest {
    @Test
    public void testRegisterCalculator() {
        // Crear una fábrica de calculadoras
        CalculatorFactory calculatorFactory = new CalculatorFactory();

        // Crear una calculadora ficticia
        CallCostCalculator dummyCalculator = new CallCostCalculator() {
            @Override
            public double calculateCost(Call call) {
                return 0.0;
            }
        };

        // Registrar la calculadora ficticia para una clase de llamada
        calculatorFactory.registerCalculator(LocalCall.class, dummyCalculator);

        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        CallCostCalculator retrievedCalculator = calculatorFactory.getCalculator(new LocalCall(0,callTime));
        assertNotNull(retrievedCalculator);
        assertEquals(dummyCalculator, retrievedCalculator);
    }

    @Test
    public void testGetCalculator() {
        CalculatorFactory calculatorFactory = new CalculatorFactory();

        CallCostCalculator localCalculator = new CallCostCalculator() {
            @Override
            public double calculateCost(Call call) {
                return 0.20;
            }
        };
        CallCostCalculator nationalCalculator = new CallCostCalculator() {
            @Override
            public double calculateCost(Call call) {
                return 0.30;
            }
        };
        CallCostCalculator internationalCalculator = new CallCostCalculator() {
            @Override
            public double calculateCost(Call call) {
                return 0.50;
            }
        };

        calculatorFactory.registerCalculator(LocalCall.class, localCalculator);
        calculatorFactory.registerCalculator(NationalCall.class, nationalCalculator);
        calculatorFactory.registerCalculator(InternationalCall.class, internationalCalculator);

        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        assertEquals(localCalculator, calculatorFactory.getCalculator(new LocalCall(0,callTime)));
        assertEquals(nationalCalculator, calculatorFactory.getCalculator(new NationalCall(0, "Buenos Aires",callTime)));
        assertEquals(internationalCalculator, calculatorFactory.getCalculator(new InternationalCall(0, "United States",callTime)));
    }
}
