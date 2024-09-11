package feature;

import main.User;

public interface Confirmation {
    void bookTicket(String eventName, User user);
    boolean validateTicket(String ticketId);
}
