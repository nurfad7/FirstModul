package feature;

import main.Ticket;

import java.util.ArrayList;
import java.util.List;

public abstract class Booking implements Confirmation {
    protected List<Ticket> tickets = new ArrayList<>();

    public abstract void addTicket(Ticket ticket);

    @Override
    public boolean validateTicket(String ticketId) {
        return tickets.stream().anyMatch(t -> t.getId().equals(ticketId) && !t.isBooked());
    }

    public abstract long countRemainingTicket(String eventName);
}