package excercise;

import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    private final Scanner scanner;

    public AverageCalculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void result() {
        System.out.println("Input numbers to calculate the average.");
        ArrayList<Integer> numbers = getIntegerArrayFromUserInput(scanner);
        printInputAndOutput(numbers.toString(),
                String.valueOf(calculateAverage(numbers)));
    }

    private ArrayList<Integer> getIntegerArrayFromUserInput(Scanner scanner) {
        boolean isQuit = false;
        ArrayList<Integer> numbers = new ArrayList<>();
        do {
            System.out.print("Enter a valid number or 'q' to finish: ");
            String userInput = scanner.nextLine();
            try {
                numbers.add(Integer.parseInt(userInput));
            } catch (NumberFormatException e) {
                if(userInput.equalsIgnoreCase("q")) {
                    isQuit = true;
                } else {
                    System.out.println("Invalid input.");
                }
            }
        } while (!isQuit);
        return numbers;
    }

    private int calculateAverage(ArrayList<Integer> numbers) {
        int average = 0;
        for(int number: numbers) {
            average += number;
        }
        return average/numbers.size();
    }

    private void printInputAndOutput(String input, String output) {
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
