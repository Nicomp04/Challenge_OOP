package org.example;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Read CSV
        CallDataReader reader = new CallDataReader("src/main/resources/Calls.csv");

        List<Call> allCalls = reader.readCalls();

        // Create bill for an exact month
        YearMonth targetMonth = YearMonth.of(2024, 4);
        BillGenerator.createBillForMonth(targetMonth, allCalls);
    }
}
