package main;

import feature.Booking;
import feature.Print;

public class Event extends Booking implements Print {

    @Override
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public void bookTicket(String eventName, User user, int quantity) {
        long remainingTickets = countRemainingTicket(eventName);
        boolean isAvailable = remainingTickets >= quantity;
        if (isAvailable) {
            for(int i = 0; i < quantity; i++) {
                Ticket ticketToBook = tickets.stream()
                        .filter(t -> t.getEventName().equals(eventName) && !t.isBooked())
                        .findFirst()
                        .orElse(null);
                if (ticketToBook != null) {
                    ticketToBook.setBooked(true);
                    System.out.println("Confirmation confirmed for user " + user.getName() + " for event " + ticketToBook.getEventName());
                    printTicket(ticketToBook, user);
                } else {
                    System.out.println("No available tickets for event " + eventName);
                }
            }
        } else {
            System.out.println("Insufficient amount to book. \n" + remainingTickets + " ticket(s) remaining for event " + eventName);
        }
    }

    @Override
    public void printTicket(Ticket ticket, User user) {
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
}