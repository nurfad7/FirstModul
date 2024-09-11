import main.Event;
import main.Ticket;
import main.User;

public class Main {
    public static void main(String[] args) {
        Event event = new Event();

        Ticket ticket1 = new Ticket("Theatre", 30.00);
        Ticket ticket2 = new Ticket("Concert", 95.00);

        event.addTicket(ticket1);
        event.addTicket(ticket2);

        User user1 = new User("Jiyan", "jiyan@example.com");
        User user2 = new User("Calcharo", "calcharo@example.com");

        event.bookTicket("Concert", user1);
        event.bookTicket("Theatre", user2);
        event.bookTicket("Concert", user2); //book the same event again
    }
}