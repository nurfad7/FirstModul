package tools;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerBuilder {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static String getStringInput(Scanner scanner, String description) {
        System.out.print(description);
        return scanner.nextLine();
    }

    public static String getEmailInput(Scanner scanner, String description) {
        System.out.print(description);
        boolean isTypedCorrectly = false;
        String email;
        do {
            System.out.print(description);
            email = scanner.nextLine();
            if (email == null) {
                System.out.println("Email can't be empty");
            } else if (!EMAIL_PATTERN.matcher(email).matches()) {
                System.out.println("Please type a valid email");
            } else {
                isTypedCorrectly = true;
            }
        } while (!isTypedCorrectly);
        return email;
    }

    public static int getIntegerInput(Scanner scanner, String description) {
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

    public static double getDoubleInput(Scanner scanner, String description) {
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

    public static ArrayList<Integer> getIntegerArrayInput(Scanner scanner) {
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
