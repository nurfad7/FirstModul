import main.Event;
import main.Ticket;
import main.User;
import tools.ScannerBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Event event = new Event();

        event.addTicket(new Ticket("Theater", 30.00));
        event.addTicket(new Ticket("Theater", 30.00));
        event.addTicket(new Ticket("Concert", 95.00));
        event.addTicket(new Ticket("Concert", 95.00));
        event.addTicket(new Ticket("Concert", 95.00));
        event.addTicket(new Ticket("Concert", 95.00));

        Scanner scanner = new Scanner(System.in);
        long theaterTicketAmount = event.countRemainingTicket("Theater");
        long concertTicketAmount = event.countRemainingTicket("Concert");
        System.out.println("Welcome to Lollo ticket book."
                            + "\nPlease choose which ticket to book."
                            + "\n1. Theater | " + (theaterTicketAmount == 0 ? "(Sold Out)" : theaterTicketAmount + " ticket(s) left")
                            + "\n2. Concert | " + (concertTicketAmount == 0 ? "(Sold Out)" : concertTicketAmount + " ticket(s) left"));
        boolean isProcessing = true;
        User user;
        while (isProcessing) {
            String eventNumber = ScannerBuilder.getStringInput(scanner,
                    "Type the number or 'x' to cancel: ");
            switch (eventNumber) {
                case "1":
                    user = new User(ScannerBuilder.getStringInput(scanner, "Enter your name: "),
                            ScannerBuilder.getEmailInput(scanner,"Enter your email: "));
                    event.bookTicket("Theater", user,
                            ScannerBuilder.getIntegerInput(scanner,"Enter the amount of ticket: "));
                    isProcessing = false;
                    break;
                case "2":
                    user = new User(ScannerBuilder.getStringInput(scanner, "Enter your name: "),
                            ScannerBuilder.getEmailInput(scanner,"Enter your email: "));
                    event.bookTicket("Concert", user,
                            ScannerBuilder.getIntegerInput(scanner,"Enter the amount of ticket: "));
                    isProcessing = false;
                    break;
                case "x":
                    isProcessing = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    System.out.println("Please choose which ticket to book."
                                + "\n1. Theatre \n2. Concert");
                    break;
            }
        }
    }
}