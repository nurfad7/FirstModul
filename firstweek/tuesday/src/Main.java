import java.util.Scanner;

import excercise.AverageCalculator;
import excercise.CSVReader;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CSVReader csvReader = new CSVReader(scanner);
            csvReader.result();
            AverageCalculator averageCalculator = new AverageCalculator(scanner);
            averageCalculator.result();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}