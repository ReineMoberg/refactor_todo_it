package se.lexicon.group_Reine.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Todo {

    private int todoId;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private int assigneeId;

    public Todo() {
    }

    public Todo(String title, String description, LocalDate deadline, boolean done, int assigneeId) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public Todo(String title, String description, Date deadlineMySqlFormat, boolean done, int assigneeId) {
        this.title = title;
        this.description = description;
        this.deadline = deadlineMySqlFormat.toLocalDate();
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public Todo(int todoId, String title, String description, LocalDate deadline, boolean done, int assigneeId) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public Todo(int todoId, String title, String description, Date deadlineMySqlFormat, boolean done, int assigneeId) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadline = deadlineMySqlFormat.toLocalDate();
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public void setDeadlineFromMySqlFormat(Date deadlineMySqlFormat) {
        deadline = deadlineMySqlFormat.toLocalDate();
    }

    public Date getDeadlineToMySqlFormat(){
        return Date.valueOf(deadline);
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return todoId == todo.todoId && done == todo.done && assigneeId == todo.assigneeId && Objects.equals(title, todo.title) && Objects.equals(description, todo.description) && Objects.equals(deadline, todo.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, title, description, deadline, done, assigneeId);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assigneeId=" + assigneeId +
                '}';
    }
}
