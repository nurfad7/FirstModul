package main;

import feature.Booking;
import feature.Print;

public class Event extends Booking implements Print {

    @Override
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public void bookTicket(String eventName, User user) {
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

    @Override
    public void printTicket(Ticket ticket, User user) {
        System.out.println("Ticket Details:");
        System.out.println("Ticket ID: " + ticket.getId());
        System.out.println("Event: " + ticket.getEventName());
        System.out.println("Price: $" + ticket.getPrice());
        System.out.println("Booked by: " + user.getName());
    }
}