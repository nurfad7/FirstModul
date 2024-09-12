package registration;

import entity.User;

public interface Notes {
    void addTask(User user, String id);
    void checkmarkTask(User user);
    void deleteTask(User user);
    void viewTask(User user);
}
