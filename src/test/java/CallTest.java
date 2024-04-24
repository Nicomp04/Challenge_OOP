import org.example.Call;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class CallTest {

    @Test
    public void testGetDuration() {
        // Create a call with duration of 10 minutes
        LocalDateTime callTime = LocalDateTime.now();
        Call call = new Call(10, callTime);

        // Verify that the duration is as expected
        assertEquals(10, call.getDuration());
    }

    @Test
    public void testGetCallTime() {
        // Create a call with a specific date and time
        LocalDateTime callTime = LocalDateTime.of(2024, 4, 23, 15, 30);
        Call call = new Call(5, callTime);

        // Verify that the call's date and time are as expected
        assertEquals(callTime, call.getCallTime());
    }
}
