package se.lexicon.group_Reine.data;

import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    //set a specific todoitem is done
    public void setItemDone(int todoId) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getTodoId() == todoId) {
                items[i].setDone(true);
                break;
            }
        }
    }

    //return all items that are ether done or not done
    public Todo[] findByDoneStatus(boolean doneStatus) {
        Todo[] itemsDoneOrNot = new Todo[0];
        for (Todo todo : items) {
            if (todo.isDone() == doneStatus) {
                Todo[] tempArray = Arrays.copyOf(itemsDoneOrNot, itemsDoneOrNot.length + 1);
                tempArray[tempArray.length - 1] = todo;
                itemsDoneOrNot = tempArray;
            }
        }
        return itemsDoneOrNot;
    }

    //return all items that are assigned to a certain person ID
    public Todo[] findByAssignee(int personId) {
        Todo[] assigneeItems = new Todo[0];
        for (Todo todo : items) {
            if (todo.getAssignee().getPersonID() == personId) {
                Todo[] tempArray = Arrays.copyOf(assigneeItems, assigneeItems.length + 1);
                tempArray[tempArray.length - 1] = todo;
                assigneeItems = tempArray;
            }
        }
        return assigneeItems;
    }

    //return all items that are assigned to a certain assignee
    public Todo[] findByAssignee(Person assignee){
        Todo[] assigneeItems = new Todo[0];
        for (Todo todo : items) {
            if (todo.getAssignee().getPersonID() == assignee.getPersonID()) {
                Todo[] tempArray = Arrays.copyOf(assigneeItems, assigneeItems.length + 1);
                tempArray[tempArray.length - 1] = todo;
                assigneeItems = tempArray;
            }
        }
        return assigneeItems;
    }

    //return all items that does not have an assignee
    public Todo[] findUnassignedTodoItems() {
        Todo[] unassignedItems = new Todo[0];
        for (Todo todo : items) {
            if (todo.getAssignee() == null) {
                Todo[] tempArray = Arrays.copyOf(unassignedItems, unassignedItems.length + 1);
                tempArray[tempArray.length - 1] = todo;
                unassignedItems = tempArray;
            }
        }
        return unassignedItems;
    }

    //remove todoitem from item array by id
    public void removeTodo(int todoId) {
        Todo[] newTodoArray = new Todo[items.length - 1];
        int findIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getTodoId() == todoId) {
                findIndex = i;
                break;
            }
        }
        int newArrayIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (i == findIndex) {
                continue;
            }
            newTodoArray[newArrayIndex] = items[i];
            newArrayIndex++;
        }
        items = newTodoArray;
    }


}
