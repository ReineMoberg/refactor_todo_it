package se.lexicon.group_Reine.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

public class TodoItemsImplTest {

    /*private TodoItemsImpl testTodoItemsImpl;    //create object from TodoItems class
    private PeopleImpl testPeopleImpl;          //create object from People class. is used in TodoItems object as assignee

    //initialize objects
    @Before
    public void setUp(){
        testTodoItemsImpl = new TodoItemsImpl();
        testPeopleImpl = new PeopleImpl();
    }

    //add two todoitems and check if both were added.
    //also check that correct assignee was added, first name only
    @Test
    public void testAddTodo() {
        int expectedId1 = 1;
        int expectedPersonId1 = 1;
        String expectedDescription1 = "Paint the house";
        boolean expectedDone1 = false;
        Person expectedAssignee1 = new Person(expectedPersonId1,"Arne","Andersson");
        int expectedId2 = 2;
        int expectedPersonId2 = 2;
        String expectedDescription2 = "Workout";
        boolean expectedDone2 = false;
        Person expectedAssignee2 = new Person(expectedPersonId2,"Anna","Karlsson");
        PersonSequencer.reset();
        TodoSequencer.reset();
        Todo testTodo1 = testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne","Andersson"));
        Assert.assertTrue(testTodo1.getTodoId() == expectedId1 && testTodo1.isDone() == expectedDone1 && testTodo1.getDescription().equalsIgnoreCase(expectedDescription1) && testTodo1.getAssignee().getFirstName().equalsIgnoreCase(expectedAssignee1.getFirstName()));
        Todo testTodo2 = testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna", "Karlsson"));
        Assert.assertTrue(testTodo2.getTodoId() == expectedId2 && testTodo2.isDone() == expectedDone2 && testTodo2.getDescription().equalsIgnoreCase(expectedDescription2) && testTodo2.getAssignee().getFirstName().equalsIgnoreCase(expectedAssignee2.getFirstName()));
    }

    //add two todoitems and check how many items are in array
    @Test
    public void testSize() {
        int expectedSize = 2;
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne","Andersson"));
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna", "Karlsson"));
        Assert.assertTrue(testTodoItemsImpl.size() == expectedSize);
    }

    //add three todoitems and check search for an item with a specific id
    @Test
    public void testFindById() {
        int searchId = 3;
        String expectedDescription = "Workout";
        String expectedFirstName = "Anna";
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne","Andersson"));
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn","Stensson"));
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna","Karlsson"));
        Todo foundTodo = testTodoItemsImpl.findById(searchId);
        Assert.assertTrue(foundTodo.getTodoId() == searchId && foundTodo.getDescription().equalsIgnoreCase(expectedDescription) && foundTodo.getAssignee().getFirstName().equalsIgnoreCase(expectedFirstName));
    }

    *//*add three todoitems, and same items to local array,
    to check if entire array of todoitems is returned and is correct.
    only descriptions are checked.*//*
    @Test
    public void testFindAll() {
        Todo[] testTodoItems2 = new Todo[3];
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne","Andersson"));
        testTodoItems2[0] = new Todo(1,"Paint the house");
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn","Stensson"));
        testTodoItems2[1] = new Todo(2,"Fix the car");
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna","Karlsson"));
        testTodoItems2[2] = new Todo(3,"Workout");
        Todo[] todos = testTodoItemsImpl.findAll();
        Assert.assertTrue(testTodoItems2[0].getDescription().equalsIgnoreCase(todos[0].getDescription()));
        Assert.assertTrue(testTodoItems2[1].getDescription().equalsIgnoreCase(todos[1].getDescription()));
        Assert.assertTrue(testTodoItems2[2].getDescription().equalsIgnoreCase(todos[2].getDescription()));
    }

    //add a todoitem and check that there are items in array.
    //then clear all todoitems and check that the array is empty
    @Test
    public void testClear() {
        int expectedSize = 0;
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn","Stensson"));
        Assert.assertTrue(testTodoItemsImpl.size() != expectedSize);
        testTodoItemsImpl.clear();
        Assert.assertTrue(testTodoItemsImpl.size() == expectedSize);
    }

    //add three todoitems and check search for items by done status.
    //then set one item, with id, status to done (true) and check again
    @Test
    public void testFindByDoneStatus() {
        Todo[] testItemsNotDone = new Todo[0];
        Todo[] testItemsDone = new Todo[0];
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne", "Andersson"));
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn", "Stensson"));
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna", "Karlsson"));
        testItemsNotDone = testTodoItemsImpl.findByDoneStatus(false);
        testItemsDone = testTodoItemsImpl.findByDoneStatus(true);
        Assert.assertTrue(testItemsNotDone.length == 3 && testItemsDone.length == 0);
        testItemsNotDone = new Todo[0];
        testItemsDone = new Todo[0];
        testTodoItemsImpl.setItemDone(3);
        testItemsNotDone = testTodoItemsImpl.findByDoneStatus(false);
        testItemsDone = testTodoItemsImpl.findByDoneStatus(true);
        Assert.assertTrue(testItemsNotDone.length == 2 && testItemsDone.length == 1);
    }

    //add four todoitems, where one person is assigned to two different todoitems.
    //check that one person has two items, and another person has one item. done with an assignee.
    //also, check first name of assignees
    @Test
    public void testFindByAssignee() {
        Todo[] testItemsForAnId1 = new Todo[0];
        Todo[] testItemsForAnId2 = new Todo[0];
        String expectedFirstName1 = "Anna";
        String expectedFirstName2 = "Linn";
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne", "Andersson"));
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn", "Stensson"));
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna", "Karlsson"));
        testTodoItemsImpl.addTodo("Working", testPeopleImpl.findById(3));
        testItemsForAnId1 = testTodoItemsImpl.findByAssignee(testPeopleImpl.findById(3));
        testItemsForAnId2 = testTodoItemsImpl.findByAssignee(testPeopleImpl.findById(2));
        Assert.assertTrue(testItemsForAnId1.length == 2 && testItemsForAnId2.length == 1);
        Assert.assertTrue(testItemsForAnId1[0].getAssignee().getFirstName().equalsIgnoreCase(expectedFirstName1));
        Assert.assertTrue(testItemsForAnId2[0].getAssignee().getFirstName().equalsIgnoreCase(expectedFirstName2));
    }

    //add four todoitems, where one person is assigned to two different todoitems.
    //check that one person has two items, and another person has one item. done with a persons id.
    //also, check first name of assignees
    @Test
    public void testFindByAssigneeId() {
        Todo[] testItemsForAnId1 = new Todo[0];
        Todo[] testItemsForAnId2 = new Todo[0];
        String expectedFirstName1 = "Anna";
        String expectedFirstName2 = "Arne";
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne", "Andersson"));
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn", "Stensson"));
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna", "Karlsson"));
        testTodoItemsImpl.addTodo("Working", testPeopleImpl.findById(3));
        testItemsForAnId1 = testTodoItemsImpl.findByAssignee(3);
        testItemsForAnId2 = testTodoItemsImpl.findByAssignee(1);
        Assert.assertTrue(testItemsForAnId1.length == 2 && testItemsForAnId2.length == 1);
        Assert.assertTrue(testItemsForAnId1[0].getAssignee().getFirstName().equalsIgnoreCase(expectedFirstName1));
        Assert.assertTrue(testItemsForAnId2[0].getAssignee().getFirstName().equalsIgnoreCase(expectedFirstName2));
    }

    //add three todoitems and check search unassigned items.
    //ex. set two without assignee, and one with
    @Test
    public void testFindUnassignedTodoItems() {
        Todo[] testNoAssignee = new Todo[0];
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne", "Andersson"));
        testTodoItemsImpl.addTodo("Fix the car");
        testTodoItemsImpl.addTodo("Workout");
        testNoAssignee = testTodoItemsImpl.findUnassignedTodoItems();
        Assert.assertTrue(testNoAssignee.length == 2);
    }

    //add three todoitems, two of them are also added to local item array.
    //remove one item and check that number of items (array size) are two.
    //check that correct todoitem, by id, was removed
    @Test
    public void testRemoveTodo() {
        Todo[] testTodoItems2 = new Todo[2];
        int expectedSize = 2;
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItemsImpl.addTodo("Paint the house", testPeopleImpl.addPerson("Arne", "Andersson"));
        testTodoItems2[0] = new Todo(1, "Paint the house");
        testTodoItemsImpl.addTodo("Fix the car", testPeopleImpl.addPerson("Linn", "Stensson"));
        //testTodoItems2[0] = new Todo(2,"Fix the car");
        testTodoItemsImpl.addTodo("Workout", testPeopleImpl.addPerson("Anna", "Karlsson"));
        testTodoItems2[1] = new Todo(3, "Workout");
        testTodoItemsImpl.removeTodo(2);
        Todo[] todos = testTodoItemsImpl.findAll();
        Assert.assertTrue(todos.length == expectedSize && testTodoItemsImpl.size() == expectedSize);
        Assert.assertTrue(testTodoItems2[0].getTodoId() == todos[0].getTodoId());
        Assert.assertTrue(testTodoItems2[1].getTodoId() == todos[1].getTodoId());
    }*/
}
