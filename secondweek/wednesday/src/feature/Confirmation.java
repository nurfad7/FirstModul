package feature;

import main.User;

public interface Confirmation {
    void bookTicket(String eventName, User user, int quantity);
    boolean validateTicket(String ticketId);
}