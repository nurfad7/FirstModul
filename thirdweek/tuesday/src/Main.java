import structure.DataStructure;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DataStructure.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}