package se.lexicon.group_Reine.model;

public class Todo {

    //object specific variables
    private final int todoId;           //can only be initialized once
    private String description;
    private boolean done;
    private Person assignee;

    //constructor
    public Todo(int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    //setters and getters
    public int getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}
