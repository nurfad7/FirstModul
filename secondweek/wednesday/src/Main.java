import main.Event;
import main.Menu;
import main.Ticket;
import main.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event event = new Event();

        event.addTicket(new Ticket("Theater", 30.00));
        event.addTicket(new Ticket("Theater", 30.00));
        event.addTicket(new Ticket("Concert", 95.00));
        event.addTicket(new Ticket("Concert", 95.00));
        event.addTicket(new Ticket("Concert", 95.00));
        event.addTicket(new Ticket("Concert", 95.00));

        System.out.println("Welcome to Lollo ticket book.");
        System.out.println("Please fill some information to access our service.");

        //User Identification
        User user = new User(ScannerBuilder.getStringInput(scanner, "Enter your name: "),
                ScannerBuilder.getEmailInput(scanner,"Enter your email: "));
        System.out.println("______________________________________________________");

        //App
        System.out.println("Hi " + user.getName() + "!");
        String userChosenMenu = null;
        while (userChosenMenu == null || !userChosenMenu.equalsIgnoreCase("exit")) {
            userChosenMenu = Menu.chooseMenu(scanner);
            switch (userChosenMenu) {
                case "1":
                    userChosenMenu = Menu.showAvailableEvents(event);
                    System.out.println("______________________________________________________");
                    break;
                case "2":
                    userChosenMenu = Menu.processBookingMenu(scanner, event, user);
                    System.out.println("______________________________________________________");
                    break;
                case "3":
                    userChosenMenu = Menu.cancelBookingMenu(scanner, event, user);
                    System.out.println("______________________________________________________");
                    break;
                case "exit":
                    System.out.println("Thank you, " + user.getName() + ". For using our service."
                                            + "\nHave a nice day. ^^");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }

        //Close the Scanner
        scanner.close();
    }
}