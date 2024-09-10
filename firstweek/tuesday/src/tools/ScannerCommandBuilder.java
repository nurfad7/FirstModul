package tools;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerCommandBuilder {
    public static String getStringFromUserInput(Scanner scanner, String description) {
        System.out.print(description);
        return scanner.nextLine();
    }

    public static int getIntegerFromUserInput(Scanner scanner, String description) {
        boolean isTypedCorrectly = false;
        int number = 0;
        do {
            System.out.print(description);
            try {
                number = scanner.nextInt();
                isTypedCorrectly = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please input number");
            }
        } while (!isTypedCorrectly);
        return number;
    }

    public static double getDoubleFromUserInput(Scanner scanner, String description) {
        boolean isTypedCorrectly = false;
        double number = 0;
        do {
            System.out.print(description);
            try {
                number = scanner.nextDouble();
                isTypedCorrectly = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please input number");
            }
        } while (!isTypedCorrectly);
        return number;
    }

    public static ArrayList<Integer> getIntegerArrayFromUserInput(Scanner scanner) {
        boolean isTypedCorrectly = false;
        System.out.print("Enter array length: ");
        int arrayLength = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        do {
            try {
                if(numbers.size() == arrayLength) {
                    isTypedCorrectly = true;
                    continue;
                }
                System.out.print("Enter number: ");
                numbers.add(scanner.nextInt());
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please input number");
            }
        } while (!isTypedCorrectly);
        return numbers;
    }
}
