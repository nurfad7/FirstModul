package main;

import java.util.Scanner;

public class Menu {
    public static String chooseMenu(Scanner scanner) {
        System.out.println("App: "
                            + "\n1. Check available events"
                            + "\n2. citizen.facility.Book ticket event"
                            + "\n3. Cancel Booking");
        return ScannerBuilder.getStringInput(scanner,
                "Type menu number or 'exit' to end our service: ");
    }

    public static String showAvailableEvents(Event event) {
        long theaterTicketAmount = event.countRemainingTicket("Theater");
        long concertTicketAmount = event.countRemainingTicket("Concert");
        System.out.println("Events available: "
                + "\n1. Theater | " + (theaterTicketAmount == 0 ? "(Sold Out)" : theaterTicketAmount + " ticket(s) left")
                + "\n2. Concert | " + (concertTicketAmount == 0 ? "(Sold Out)" : concertTicketAmount + " ticket(s) left"));
        return null;
    }

    public static String processBookingMenu(Scanner scanner, Event event, User user) {
        long theaterTicketAmount = event.countRemainingTicket("Theater");
        long concertTicketAmount = event.countRemainingTicket("Concert");
        boolean isProcessing = true;
        while (isProcessing) {
            System.out.println("Please choose which ticket to book."
                    + "\n1. Theater | " + (theaterTicketAmount == 0 ? "(Sold Out)" : theaterTicketAmount + " ticket(s) left")
                    + "\n2. Concert | " + (concertTicketAmount == 0 ? "(Sold Out)" : concertTicketAmount + " ticket(s) left"));
            String eventNumber = ScannerBuilder.getStringInput(scanner,
                    "Type the number or 'menu' to go back to menu: ");
            switch (eventNumber) {
                case "1":
                    isProcessing = event.ticketIsBooked("Theater", user,
                            ScannerBuilder.getIntegerInput(scanner, "Enter the amount of ticket: "));
                    break;
                case "2":
                    isProcessing = event.ticketIsBooked("Concert", user,
                            ScannerBuilder.getIntegerInput(scanner, "Enter the amount of ticket: "));
                    break;
                case "menu":
                    isProcessing = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        return null;
    }

    public static String cancelBookingMenu(Scanner scanner, Event event, User user) {
        long theaterTicketAmount = event.countBookedTicket("Theater", user);
        long concertTicketAmount = event.countBookedTicket("Concert", user);
        if(theaterTicketAmount == 0 && concertTicketAmount == 0) {
            System.out.println("You haven't book anything.");
            return "";
        }
        boolean isProcessing = true;
        while (isProcessing) {
            System.out.println("Please choose which event ticket to cancel."
                    + (theaterTicketAmount == 0 ? "" : "\n1. Theater | You booked " + theaterTicketAmount + " ticket(s)")
                    + (concertTicketAmount == 0 ? "" : "\n2. Concert | You booked " + concertTicketAmount + " ticket(s)"));
            String eventNumber = ScannerBuilder.getStringInput(scanner,
                    "Type the number or 'menu' to back to menu: ");
            switch (eventNumber) {
                case "1":
                    if (theaterTicketAmount == 0) {
                        System.out.println("Invalid input.");
                    } else {
                        isProcessing = event.ticketIsCanceled("Theater", user,
                                ScannerBuilder.getIntegerInput(scanner, "Enter the amount of ticket to cancel: "));
                    }
                    break;
                case "2":
                    if (concertTicketAmount == 0) {
                        System.out.println("Invalid input.");
                    } else {
                        isProcessing = event.ticketIsCanceled("Concert", user,
                                ScannerBuilder.getIntegerInput(scanner, "Enter the amount of ticket to cancel: "));
                    }
                    break;
                case "menu":
                    isProcessing = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        return null;
    }
}
