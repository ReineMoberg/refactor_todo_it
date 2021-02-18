package se.lexicon.group_Reine.data;


import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

import java.util.Collection;

public class TodoItemsImpl implements TodoItems {


    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int assigneeId) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
