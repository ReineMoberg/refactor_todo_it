package se.lexicon.group_Reine.data;

import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

import java.util.Collection;

public interface TodoItems {

    Todo create(Todo todo);
    Collection<Todo> findAll();
    Todo findById(int id);
    Collection<Todo> findByDoneStatus(boolean done);
    Collection<Todo> findByAssignee(int assigneeId);
    Collection<Todo> findByAssignee(Person assignee);
    Collection<Todo> findByUnassignedTodoItems();
    Todo updateTodo(Todo todo);
    boolean deleteById(int id);

}
