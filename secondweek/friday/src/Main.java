import citizen.facility.Library;

public class Main {
    public static void main(String[] args) {
        Library purwadhikaLibrary = new Library();
        System.out.println("Library was just opened at 7 a.m.");
        System.out.println(purwadhikaLibrary.isClosed() ? "Library was just closed at 11 p.m." : "");
    }
}