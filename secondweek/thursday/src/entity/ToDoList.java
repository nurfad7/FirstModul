package entity;

import java.util.UUID;

public class ToDoList {
    private String id;
    private String taskToDo;
    private boolean isCompleted;

    public ToDoList(String toDo) {
        this.id = UUID.randomUUID().toString();
        this.taskToDo = toDo;
        this.isCompleted = false;
    }
}
