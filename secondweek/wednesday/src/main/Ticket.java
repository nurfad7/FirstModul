package main;

import java.util.UUID;

public class Ticket {
    private String id;
    private String eventName;
    private double price;
    private boolean booked;
    private User user;

    public Ticket(String eventName, double price) {
        this.id = UUID.randomUUID().toString();
        this.eventName = eventName;
        this.price = price;
        this.booked = false;
    }

    public String getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean isBooked) {
        this.booked = isBooked;
    }

    public void setUser(User user) {
        if(this.booked){
            this.user = user;
        }
    }

    public void regenerateID() {
        this.id = UUID.randomUUID().toString();
    }
}
