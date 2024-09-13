package citizen.facility;

import registration.Register;
import registration.Validation;

import java.time.Month;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Library extends Register implements Validation {
    private Map<String, Material> materials = new HashMap<>();
    private static final Map<String, String> MATERIAL_CODE = Map.of(
            "book", "A01",
            "dvd","B04",
            "magazine","C02",
            "scientific journal","D03");

    public boolean isClosed() {
        try (Scanner scanner = new Scanner(System.in)) {
            addMaterialToLibrary();
            boolean isClosed = false;
            // inside app
            while (!isClosed) {
                System.out.println("Hello, welcome to Purwadhika library.");
                String userName = getStringInput(scanner, "User Name: ");
                String password = getStringInput(scanner, "Password: ");
                User userActive = loginUser(userName, password);
                if (userActive == null) {
                    System.out.println("Wrong password.");
                    continue;
                }
                System.out.println("Hi, " + userName + "!");
                // menu with options to add a task, view tasks, delete a task, or log out
                String userAction = browseMenu(scanner, userActive);
                if (userAction.equals("logout")) {
                    continue;
                } else {
                    System.out.println("Library web was closed.");
                    isClosed = true;
                }
            }
            System.out.println("__________________________________________");
        } catch (Exception e) {
            System.out.println("There's a problem with the library's system"
                    + e.getMessage());
        }
        return true;
    }

    public User loginUser(String userName, String password) {
        Map<String, User> userStatus = validateUser(userName, password);
        if (userStatus == null) {
            return null;
        } else if(userStatus.containsKey("new")) {
            addUser(new User(userName, password));
            return loginUser(userName, password);
        } else {
            return userStatus.get("registered");
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    public String getStringInput(Scanner scanner, String description) {
        System.out.print(description);
        return scanner.nextLine();
    }

    public int getIntegerInput(Scanner scanner, String description) {
        boolean isTypedCorrectly = false;
        int number = 0;
        do {
            System.out.print(description);
            try {
                number = scanner.nextInt();
                isTypedCorrectly = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please input number");
            }
        } while (!isTypedCorrectly);
        return number;
    }

    public String browseMenu(Scanner scanner, User user) {
        boolean isClosed = false;
        while (!isClosed) {
            System.out.println("Choose your action: "
                    + "\n1. Search Materials"
                    + "\n2. Borrow Materials"
                    + "\n3. Return Materials");
            String userAction = getStringInput(scanner,
                    "Enter number 'logout' to logout: ");
            switch (userAction) {
                case "1":
                    searchMaterial();
                    break;
                case "2":
                    borrowMaterial(user, scanner);
                    break;
                case "3":
                    returnMaterial(user, scanner);
                    break;
                case "logout":
                    System.out.println("You have been logged out");
                    System.out.println("______________________________________________");
                    isClosed = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        return "logout";
    }

    private void addMaterialToLibrary() {
        addMaterialToShelf("book", new Book("Communicating with Data", 2021, "Carl Allchin"));
        addMaterialToShelf("book", new Book("Kubernetes Security and Observability", 2023, "Brendan Creane and Amit Gupta"));
        addMaterialToShelf("book", new Book("Women of Color in Tech: A Blueprint for Inspiring and Mentoring the Next Generation of Technology Innovators", 2020, "Susanne Tedrick"));
        addMaterialToShelf("book", new Book("Technology & Society: Second Edition", 2021, "Deborah G. Johnson and Jameson M. Wetmore"));
        addMaterialToShelf("book", new Book("Everyday Chaos: Technology, Complexity, and How We’re Thriving in a New World of Possibility", 2019, "David Weinberger"));

        addMaterialToShelf("dvd", new DVD("Children of Men", 2006, "Dystopian"));
        addMaterialToShelf("dvd", new DVD("Starship Troopers", 1997, "Military"));
        addMaterialToShelf("dvd", new DVD("Memento", 2000, "Psychological"));

        addMaterialToShelf("magazine", new Magazine("Forbes", 2024, Month.SEPTEMBER));
        addMaterialToShelf("magazine", new Magazine("Forbes", 2024, Month.AUGUST));
        addMaterialToShelf("magazine", new Magazine("Forbes", 2024, Month.JULY));

        addMaterialToShelf("scientific journal", new ScientificJournal("Identification of the ATP Binding Site of the F1-ATPase", 2011, "William A. B. Hirst, Andrew S. W. Smith, and Caroline A. Wilson", "Biological Chemistry", "0021-9258"));
        addMaterialToShelf("scientific journal", new ScientificJournal("The landscape of cancer genes and mutational processes", 2015, "Chris Sander, Peter J. Campbell, et al.", "Nature", "0028-0836"));
        addMaterialToShelf("scientific journal", new ScientificJournal("Single-cell transcriptomics reveals a dynamic niche for the developmental regulation of macrophage polarization", 2019, "Amy J. Parsons, Rachael E. Johnson, et al.", "Cell", "0092-8674"));
    }

    private void addMaterialToShelf(String type, Material material) {
        if(!MATERIAL_CODE.containsKey(type)){
            System.out.println("The type of material is unrecognized by the system");
        } else {
            materials.put(type, material);
        }
    }

    public void searchMaterial() {};
    public void borrowMaterial(User user, Scanner scanner) {};
    public void returnMaterial(User user, Scanner scanner) {};
}
