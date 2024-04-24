import org.example.*;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class BillTest {

    @Test
    public void testGenerateBill() {
        // Crear una factura con un abono básico de $20
        Bill bill = new Bill(20.0);

        // Agregar algunas llamadas a la factura
        LocalDateTime callTime =  LocalDateTime.of(2024, 4, 22, 18, 30);

        bill.addCall(new LocalCall(10,callTime)); // Llamada local de 10 minutos
        bill.addCall(new NationalCall(5, "Buenos Aires",callTime)); // Llamada nacional de 5 minutos a Buenos Aires
        bill.addCall(new InternationalCall(8, "United States",callTime)); // Llamada internacional de 8 minutos a Estados Unidos

        // Crear una fábrica de calculadoras y registrar calculadoras para diferentes tipos de llamadas
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        calculatorFactory.registerCalculator(LocalCall.class, new LocalCallCostCalculator());
        calculatorFactory.registerCalculator(NationalCall.class, new NationalCallCostCalculator());
        calculatorFactory.registerCalculator(InternationalCall.class, new InternationalCallCostCalculator());

        // Establecer la fábrica de calculadoras para la factura
        bill.setCalculatorFactory(calculatorFactory);

        // Generar la factura
        bill.generateBill();

        // Verificar el costo total de la factura
        double expectedTotal = 20.0 + 2.0 + 1.5 + 10.4 ; // Abono básico + costo de llamadas locales + costo de llamadas nacionales + costo de llamadas internacionales
        assertEquals(expectedTotal, bill.getTotal(), 0.001);
    }
}
