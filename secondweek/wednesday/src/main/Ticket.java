package main;

import java.util.UUID;

public class Ticket {
    private String id;
    private String eventName;
    private double price;
    //private final int MAX_AMOUNT = 1000;
    private boolean booked;

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

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
