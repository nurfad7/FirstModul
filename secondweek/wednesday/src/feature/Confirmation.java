package feature;

import main.User;

public interface Confirmation {
    boolean ticketIsBooked(String eventName, User user, int quantity);
    boolean ticketIsCanceled(String eventName, User user, int quantity);
    boolean validateTicket(String ticketId);
}