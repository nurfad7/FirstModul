package entity;

import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String userName;
    private String password;
    private List<ToDoList> myToDo;

    public User(String userName, String password) {
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }
}