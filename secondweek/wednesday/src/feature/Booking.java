package feature;

import main.Ticket;

import java.util.ArrayList;
import java.util.List;

public abstract class Booking implements Confirmation {
    protected List<Ticket> tickets = new ArrayList<>();

    public Booking() {
        // Initial setup or loading tickets can be done here
    }

    public abstract void addTicket(Ticket ticket);

    @Override
    public boolean validateTicket(String ticketId) {
        return tickets.stream().anyMatch(t -> t.getId().equals(ticketId) && !t.isBooked());
    }
}