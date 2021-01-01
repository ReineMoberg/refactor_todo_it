package se.lexicon.group_Reine.data;

import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TodoItems {

    private static Todo[] items = new Todo[0];    //item object array created when program starts

    //return the number of items in, or length of, array
    public int size() {
        return Array.getLength(items);
    }

    //return all items in the array
    public Todo[] findAll(){
        return items;
    }

    //return the item who has a certain ID
    public Todo findById (int todoId){
        Todo foundItem = new Todo(todoId,"");      //local variable with id parameter
        for (Todo todo : items){                            //search through items object array
            if(todo.getTodoId() == todoId){
                foundItem = todo;                           //when item found, stop search
                break;
            }
        }
        return foundItem;
    }

    //add todoitem to array with a new ID, then return the item that was added.
    public Todo addTodo (String description){
        Todo itemToAdd = new Todo(TodoSequencer.nextTodoId(),description);
        itemToAdd.setDone(false);
        Todo[] newTodoArray = Arrays.copyOf(items,items.length + 1);
        newTodoArray[newTodoArray.length - 1] = itemToAdd;
        items = newTodoArray;
        return itemToAdd;
    }

    //add todoitem to array with a new ID, with assignee, then return the item that was added.
    public Todo addTodo (String description, Person assignee){
        Todo itemToAdd = new Todo(TodoSequencer.nextTodoId(),description);
        itemToAdd.setAssignee(assignee);
        itemToAdd.setDone(false);
        Todo[] newTodoArray = Arrays.copyOf(items,items.length + 1);
        newTodoArray[newTodoArray.length - 1] = itemToAdd;
        items = newTodoArray;
        return itemToAdd;
    }

    //clear all items in array
    public void clear(){
        items = new Todo[0];
    }
}
