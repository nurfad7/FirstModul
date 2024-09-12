package registration;

import entity.User;

import java.util.Scanner;

public interface Notes {
    void addTask(User user, String text);
    void checkmarkTask(User user, int index);
    void deleteTask(Scanner scanner, User user, int index);
    void viewTask(User user);
}
