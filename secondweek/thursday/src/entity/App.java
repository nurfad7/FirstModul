package entity;

import registration.Notes;
import registration.Register;

import java.util.Map;
import java.util.Scanner;

public class App extends Register implements Notes {

    public User loginUser(String userName, String password) {
        Map<String, User> userStatus = validateUser(userName, password);
        if(userStatus.containsKey("new")) {
            addUser(new User(userName, password));
            return this.loginUser(userName, password);
        } else return userStatus.getOrDefault("registered", null);
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
        // menu with options to add a task, view tasks, delete a task, or log out
        boolean isClosed = false;
        while (!isClosed) {
            System.out.println("Here's what you can do with this app: "
                    + "\n1. View task"
                    + "\n2. Add task"
                    + "\n3. Checkmark task"
                    + "\n4. Delete task");
            String userAction = getStringInput(scanner,
                    "Enter number of menu or 'logout' to logout: ");
            switch (userAction) {
                case "1":
                    viewTask(user);
                    break;
                case "2":
                    addTask(user,
                            getStringInput(scanner, "Type the task: "));
                    break;
                case "3":
                    checkmarkTask(user);
                    break;
                case "4":
                    deleteTask(user);
                    break;
                case "logout":
                    System.out.println("You have been logged out");
                    isClosed = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        return "logout";
    }

    @Override
    public void addTask(User user, String taskToDo) {

    }

    @Override
    public void checkmarkTask(User user) {

    }

    @Override
    public void deleteTask(User user) {

    }

    @Override
    public void viewTask(User user) {

    }
}
