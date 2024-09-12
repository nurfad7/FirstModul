import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hello");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}