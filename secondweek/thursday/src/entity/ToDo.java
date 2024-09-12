package entity;

public class ToDo {
    private String taskToDo;
    private boolean isCompleted;

    public ToDo(String toDo) {
        this.taskToDo = toDo;
        this.isCompleted = false;
    }

    public String getTaskToDo() {
        return taskToDo;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted() {
        isCompleted = !isCompleted;
    }
}
