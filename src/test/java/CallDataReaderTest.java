import org.example.Call;
import org.example.CallDataReader;
import org.example.InternationalCall;
import org.example.NationalCall;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CallDataReaderTest {
    @Test
    public void testReadCalls() {
        // Define a CSV file with sample call data
        String csvFile = "src/main/resources/sample_test.csv";

        // Create a CallDataReader instance
        CallDataReader reader = new CallDataReader(csvFile);

        // Read the calls from the CSV file
        List<Call> calls = reader.readCalls();

        // Verify that the correct number of calls are read
        assertEquals(3, calls.size());

        // Verify the details of each call
        assertEquals(10, calls.get(0).getDuration());
        assertEquals(LocalDateTime.of(2024, 4, 22, 18, 30), calls.get(0).getCallTime());

        assertEquals(5, calls.get(1).getDuration());
        assertEquals("Cordoba", ((NationalCall) calls.get(1)).getLocality());
        assertEquals(LocalDateTime.of(2024, 4, 23, 12, 0), calls.get(1).getCallTime());

        assertEquals(8, calls.get(2).getDuration());
        assertEquals("Brazil", ((InternationalCall) calls.get(2)).getCountry());
        assertEquals(LocalDateTime.of(2024, 4, 24, 16, 30), calls.get(2).getCallTime());
    }
}