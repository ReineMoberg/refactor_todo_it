package se.lexicon.group_Reine.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

public class TodoItemsTest {

    private TodoItems testTodoItems;    //create object from TodoItems class
    private People testPeople;          //create object from People class. is used in TodoItems object as assignee

    //initialize objects
    @Before
    public void setUp(){
        testTodoItems = new TodoItems();
        testPeople = new People();
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
        Todo testTodo1 = testTodoItems.addTodo("Paint the house",testPeople.addPerson("Arne","Andersson"));
        Assert.assertTrue(testTodo1.getTodoId() == expectedId1 && testTodo1.isDone() == expectedDone1 && testTodo1.getDescription().equalsIgnoreCase(expectedDescription1) && testTodo1.getAssignee().getFirstName().equalsIgnoreCase(expectedAssignee1.getFirstName()));
        Todo testTodo2 = testTodoItems.addTodo("Workout", testPeople.addPerson("Anna", "Karlsson"));
        Assert.assertTrue(testTodo2.getTodoId() == expectedId2 && testTodo2.isDone() == expectedDone2 && testTodo2.getDescription().equalsIgnoreCase(expectedDescription2) && testTodo2.getAssignee().getFirstName().equalsIgnoreCase(expectedAssignee2.getFirstName()));
    }

    //add two todoitems and check how many items are in array
    @Test
    public void testSize() {
        int expectedSize = 2;
        testTodoItems.addTodo("Paint the house",testPeople.addPerson("Arne","Andersson"));
        testTodoItems.addTodo("Workout", testPeople.addPerson("Anna", "Karlsson"));
        Assert.assertTrue(testTodoItems.size() == expectedSize);
    }

    //add three todoitems and check search for an item with a specific id
    @Test
    public void testFindById() {
        int searchId = 3;
        String expectedDescription = "Workout";
        String expectedFirstName = "Anna";
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItems.addTodo("Paint the house",testPeople.addPerson("Arne","Andersson"));
        testTodoItems.addTodo("Fix the car",testPeople.addPerson("Linn","Stensson"));
        testTodoItems.addTodo("Workout",testPeople.addPerson("Anna","Karlsson"));
        Todo foundTodo = testTodoItems.findById(searchId);
        Assert.assertTrue(foundTodo.getTodoId() == searchId && foundTodo.getDescription().equalsIgnoreCase(expectedDescription) && foundTodo.getAssignee().getFirstName().equalsIgnoreCase(expectedFirstName));
    }

    /*add three todoitems, and same items to local array,
    to check if entire array of todoitems is returned and is correct.
    only descriptions are checked.*/
    @Test
    public void testFindAll() {
        Todo[] testTodoItems2 = new Todo[3];
        PersonSequencer.reset();
        TodoSequencer.reset();
        testTodoItems.addTodo("Paint the house",testPeople.addPerson("Arne","Andersson"));
        testTodoItems2[0] = new Todo(1,"Paint the house");
        testTodoItems.addTodo("Fix the car",testPeople.addPerson("Linn","Stensson"));
        testTodoItems2[1] = new Todo(2,"Fix the car");
        testTodoItems.addTodo("Workout",testPeople.addPerson("Anna","Karlsson"));
        testTodoItems2[2] = new Todo(3,"Workout");
        Todo[] todos = testTodoItems.findAll();
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
        testTodoItems.addTodo("Fix the car",testPeople.addPerson("Linn","Stensson"));
        Assert.assertTrue(testTodoItems.size() != expectedSize);
        testTodoItems.clear();
        Assert.assertTrue(testTodoItems.size() == expectedSize);
    }

}
