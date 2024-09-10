import java.util.Scanner;

import exercise.AverageCalculator;
import exercise.CSVReader;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AverageCalculator averageCalculator = new AverageCalculator(scanner);
            averageCalculator.result();
            CSVReader csvReader = new CSVReader();
            csvReader.result();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}