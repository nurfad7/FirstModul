package main;

import feature.Booking;
import feature.Print;

public class Event extends Booking implements Print {

    @Override
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public boolean ticketIsBooked(String eventName, User user, int quantity) {
        long remainingTickets = countRemainingTicket(eventName);
        boolean isAvailable = remainingTickets >= quantity;
        boolean isBooked = false;
        if (isAvailable) {
            for(int i = 0; i < quantity; i++) {
                Ticket ticketToBook = tickets.stream()
                        .filter(t -> t.getEventName().equals(eventName) && !t.isBooked())
                        .findFirst()
                        .orElse(null);
                if (ticketToBook != null) {
                    ticketToBook.setBooked(true);
                    ticketToBook.setUser(user);
                    System.out.println("Unconfirmed ticket for user " + user.getName()
                            + " for event " + ticketToBook.getEventName());
                    printTicket(ticketToBook, user);
                    isBooked = true;
                } else {
                    System.out.println("No available tickets for event " + eventName);
                }
            }
        } else {
            System.out.println("Insufficient amount to book. \n" + remainingTickets
                    + " ticket(s) remaining for event " + eventName);
        }
        return !isBooked;
    }

    @Override
    public boolean ticketIsCanceled(String eventName, User user, int quantity) {
        boolean isCanceled = false;
        long ticketCount = countBookedTicket(eventName, user);
        boolean isAvailable = ticketCount >= quantity;
        int canceledCount = 0;
        if (isAvailable) {
            for(int i = 0; i < quantity; i++) {
                Ticket ticketToBook = tickets.stream()
                        .filter(t -> t.getEventName().equals(eventName) && t.isBooked() && t.getUser().equals(user))
                        .findFirst()
                        .orElse(null);
                if (ticketToBook != null) {
                    ticketToBook.setBooked(false);
                    ticketToBook.setUser(null);
                    isCanceled = true;

                    //after cancel change the id of ticket
                    ticketToBook.regenerateID();

                    canceledCount++;
                } else {
                    System.out.println("No available tickets to cancel for event " + eventName);
                }
            }
        } else {
            System.out.println("Insufficient amount to cancel. \n"
                    + ticketCount + " ticket(s) remaining for event " + eventName);
        }
        System.out.println(canceledCount + "/" + ticketCount + " was canceled");
        System.out.println("______________________________________________________");
        return !isCanceled;
    }

    @Override
    public void printTicket(Ticket ticket, User user) {
        System.out.println("______________________________________________________");
        System.out.println("Ticket Details:");
        System.out.println("Ticket ID: " + ticket.getId());
        System.out.println("Event: " + ticket.getEventName());
        System.out.println("Price: $" + ticket.getPrice());
        System.out.println("Booked by: " + user.getName());
    }

    @Override
    public long countRemainingTicket(String eventName) {
        return tickets.stream()
                .filter(t -> t.getEventName().equals(eventName) && !t.isBooked())
                .count();
    }

    @Override
    public long countBookedTicket(String eventName, User user) {
        return tickets.stream()
                .filter(t -> t.getEventName().equals(eventName) && t.isBooked() && t.getUser().equals(user))
                .count();
    }
}