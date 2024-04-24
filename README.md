# Call Billing System

This is a simple call billing system that generates monthly bills based on different types of phone calls (local, national, and international).

## Requirements

- Java 8 or higher
- Maven

## Usage

1. Clone the repository:

    ```bash
    git clone https://github.com/nicomp04/Challenge_OOP.git
    ```

2. Navigate to the project directory:

    ```bash
    cd Challenge_OOP
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the main program:

    ```bash
    java -jar target/Challenge_OOP.jar
    ```

## Data Format

The system accepts call data in CSV format. Each line in the CSV file represents a call and has the following fields:

1. **Duration**: Duration of the call in minutes (integer).
2. **Type**: Type of call (`Local`, `National`, or `International`).
3. **Locality**: Locality for national calls or country for international calls.
4. **Date**: Date of the call in `YYYY-MM-DD` format.
5. **Time**: Time of the call in `HH:MM` format.

Example:

```csv
10,Local,,2024-04-22,18:30
5,National,Buenos Aires,2024-04-22,19:45
8,International,United States,2024-04-23,08:15
 ```


## Design Overview

The project is structured as follows:

- `src/main/java/org/example/`: Contains the source code.
- `src/test/java/org/example/`: Contains the unit tests.

### Classes

- `Bill`: Represents a monthly bill for phone calls.
- `Call`: Represents a phone call with duration and call time.
- `LocalCall`, `NationalCall`, `InternationalCall`: Subclasses of `Call` representing different types of calls.
- `CallCostCalculator`: Interface for calculating the cost of a call.
- `LocalCallCostCalculator`, `NationalCallCostCalculator`, `InternationalCallCostCalculator`: Implementations of `CallCostCalculator` for different types of calls.
- `CalculatorFactory`: Factory class for retrieving the appropriate `CallCostCalculator` based on the type of call.
