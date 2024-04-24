package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CallDataReader {
    private final String csvFile;

    public CallDataReader(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<Call> readCalls() {
        List<Call> calls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Ignore first line which have the headers
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Call call = createCallFromData(data);
                if (call != null) {
                    calls.add(call);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calls;
    }

    private Call createCallFromData(String[] data) {
        try {
            int duration = Integer.parseInt(data[0]);
            String type = data[1];
            String locality = data[2];
            String country = data[3];
            String date = data[4];
            String time = data[5];
            LocalDateTime callTime = LocalDateTime.parse(date + " " + time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            switch (type) {
                case "Local":
                    return new LocalCall(duration, callTime);
                case "National":
                    return new NationalCall(duration, locality, callTime);
                case "International":
                    return new InternationalCall(duration, country, callTime);
                default:
                    System.err.println("Unknown type: " + type);
                    return null;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("line reading fail: " + String.join(", ", data));
            return null;
        }
    }
}
