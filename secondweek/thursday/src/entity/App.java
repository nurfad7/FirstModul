package entity;

import registration.Notes;
import registration.Register;

import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class App extends Register implements Notes {

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
                    viewTask(user);
                    checkmarkTask(user,
                            getIntegerInput(scanner, "Enter number to check/uncheck: "));
                    break;
                case "4":
                    viewTask(user);
                    deleteTask(scanner, user,
                            getIntegerInput(scanner, "Enter number to delete: "));
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

    @Override
    public Map<Integer, ToDo> addToDoList(ToDo toDo, int newIndex) {
        Map<Integer, ToDo> toDoMap = new HashMap<>();
        toDoMap.put(newIndex, toDo);
        return toDoMap;
    }

    @Override
    public void addTask(User user, String taskToDo) {
        int newIndex = user.getMyToDo().size() + 1;
        user.getMyToDo().putAll(
                addToDoList(new ToDo(taskToDo), newIndex));
        System.out.println("task added.");
        System.out.println("______________________________________________");
    }

    @Override
    public void checkmarkTask(User user, int index) {
        user.getMyToDo().get(index).setIsCompleted();
    }

    @Override
    public void deleteTask(Scanner scanner, User user, int index) {
        scanner.nextLine();
        String confirm = getStringInput(scanner, "Are you sure, you want to delete: \nTask '"
                + user.getMyToDo().get(index).getTaskToDo() + " ("
                + (user.getMyToDo().get(index).getIsCompleted() ? "v" : "x" )
                + ")'? \nEnter 'yes' to confirm or anything else to cancel: ");
        if (confirm.equalsIgnoreCase("yes")) {
            user.getMyToDo().remove(index);
        }
    }

    @Override
    public void viewTask(User user) {
        System.out.println("______________" + user.getUserName() + "'s To Do List______________");
        for(Integer key : user.getMyToDo().keySet()) {
            ToDo toDo = user.getMyToDo().get(key);
            System.out.println(key + ". " + toDo.getTaskToDo()
                    + " \t (" + (toDo.getIsCompleted() ? "v" : "x" )  + ")");
        }
        System.out.println("______________________________________________");
    }
}
