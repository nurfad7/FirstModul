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
            "journal","D03");

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

    public String browseMenu(Scanner scanner, User user) {
        boolean isClosed = false;
        while (!isClosed) {
            System.out.println("Choose your action: "
                    + "\n1. View Materials"
                    + "\n2. Borrow Materials"
                    + "\n3. Return Materials");
            String userAction = getStringInput(scanner,
                    "Enter number or 'logout' to log out: ");
            switch (userAction) {
                case "1":
                    viewMaterial(scanner, user);
                    break;
                case "2":
                    borrowMaterial(scanner, user);
                    break;
                case "3":
                    returnMaterial(scanner, user);
                    break;
                case "logout":
                    System.out.println("You have been logged out");
                    isClosed = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
            System.out.println("______________________________________________");
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

        addMaterialToShelf("journal", new ScientificJournal("Identification of the ATP Binding Site of the F1-ATPase", 2011, "William A. B. Hirst, Andrew S. W. Smith, and Caroline A. Wilson", "Biological Chemistry", "0021-9258"));
        addMaterialToShelf("journal", new ScientificJournal("The landscape of cancer genes and mutational processes", 2015, "Chris Sander, Peter J. Campbell, et al.", "Nature", "0028-0836"));
        addMaterialToShelf("journal", new ScientificJournal("Single-cell transcriptomics reveals a dynamic niche for the developmental regulation of macrophage polarization", 2019, "Amy J. Parsons, Rachael E. Johnson, et al.", "Cell", "0092-8674"));
    }

    private void addMaterialToShelf(String type, Material material) {
        if(!MATERIAL_CODE.containsKey(type)){
            System.out.println("The type of material is unrecognized by the system");
        } else {
            materials.put(MATERIAL_CODE.get(type) + (materials.size() + 1), material);
        }
    }

    private void viewMaterial(Scanner scanner, User user) {
        boolean materialMenuIsClosed = false;
        while (!materialMenuIsClosed) {
            String userAction = getStringInput(scanner,
                    "Enter type of material"
                            + "\nor material number/ID"
                            + "\nor 'menu' to come back to main menu."
                            + "\n____________"
                            + "\n| Book  \t |"
                            + "\n| Magazine |"
                            + "\n| Journal  |"
                            + "\n| DVD \t   |"
                            + "\n____________"
                            + "\nType here: ").toLowerCase();
            if (userAction.equalsIgnoreCase("menu")) {
                System.out.println("______________________________________________");
                materialMenuIsClosed = true;
            } else {
                getMaterial(scanner, user, userAction);
            }
        }
    };

    private void borrowMaterial(Scanner scanner, User user) {
        String userInput = getStringInput(scanner, "Type the material ID to borrow or 'cancel' to cancel: ").toUpperCase();
        if(userInput.equalsIgnoreCase("cancel")){
            System.out.println("______________________________________________");
        } else if (materials.containsKey(userInput)) {
            if (materials.get(userInput).setIsBorrowed(user)) {
                user.getUserMaterials().put(userInput, materials.get(userInput));
                System.out.println("Material is successfully borrowed");
                System.out.println("______________________________________________");
            }
        } else {
            System.out.println("No material found");
            System.out.println("______________________________________________");
        }
    };

    private void returnMaterial(Scanner scanner, User user) {
        if (user.getUserMaterials().isEmpty()) {
            System.out.println("You haven't borrow anything");
            System.out.println("______________________________________________");
        } else {
            getMaterial(user.getUserMaterials());
            String userInput = getStringInput(scanner, "Type the material ID to return or 'cancel' to cancel: ").toUpperCase();
            if(userInput.equalsIgnoreCase("cancel")){
                System.out.println("______________________________________________");
            } else if (materials.containsKey(userInput)) {
                if (materials.get(userInput).setIsBorrowed(user)) {
                    user.getUserMaterials().put(userInput, materials.remove(userInput));
                    System.out.println("Material is successfully returned");
                    System.out.println("______________________________________________");
                }
            } else {
                System.out.println("No material found");
                System.out.println("______________________________________________");
            }
        }
    };

    private void getMaterial(Scanner scanner, User user, String type) {
        Map<String, Material> materialToDisplay = new HashMap<>();
        if (MATERIAL_CODE.containsKey(type)) {
            for(String key : materials.keySet()) {
                if (key.contains(MATERIAL_CODE.get(type))) {
                    materialToDisplay.put(key, materials.get(key));
                }
            }
        } else {
            if(materials.containsKey(type.toUpperCase())) {
                materialToDisplay.put(type, materials.get(type.toUpperCase()));
            }
        }
        if (materialToDisplay.isEmpty()) {
            System.out.println("No material found");
        } else if (materialToDisplay.size() == 1) {
            materials.get(type.toUpperCase()).getDetailInfo();
        } else {
            for(String key : materialToDisplay.keySet()) {
                System.out.print("ID: " + key);
                materialToDisplay.get(key).getShortInfo();
            }
        }
        System.out.println("______________________________________________");
    }

    private void getMaterial(Map<String, Material> materialToDisplay) {
        for(String key : materialToDisplay.keySet()) {
            System.out.print("ID: " + key);
            materialToDisplay.get(key).getShortInfo();
        }
        System.out.println("______________________________________________");
    }
}
