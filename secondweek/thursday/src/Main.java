import entity.App;
import entity.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            App app = new App();
            boolean isClosed = false;
            // inside app
            while (!isClosed) {
                System.out.println("Hello, Welcome to To-Do List Console App.");
                String userName = app.getStringInput(scanner, "User Name: ");
                String password = app.getStringInput(scanner, "Password: ");
                User userActive = app.loginUser(userName, password);
                if (userActive == null) {
                    System.out.println("Wrong password.");
                    continue;
                }
                System.out.println("Hi, " + userName + "!");
                // menu with options to add a task, view tasks, delete a task, or log out
                String userAction = app.browseMenu(scanner, userActive);
                if (userAction.equals("logout")) {
                    continue;
                } else {
                    System.out.println("App was closed.");
                    isClosed = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}