package se.lexicon.group_Reine.data;

import org.junit.Assert;
import org.junit.Test;

public class TodoSequencerTest {

    /*//two calls to id counter to verify it counts up
    @Test
    public void testNextTodoId (){
        TodoSequencer.reset();
        int expectedTodoId = 1;
        Assert.assertTrue(expectedTodoId == TodoSequencer.nextTodoId());
        expectedTodoId++;
        Assert.assertTrue(expectedTodoId == TodoSequencer.nextTodoId());
    }

    //call up-counting id counter a few times and then reset to zero
    @Test
    public void testReset() {
        int expectedTodoId = 1;
        int testCounter = 0;
        for (int i = 0; i < 3; i++) {
            testCounter = TodoSequencer.nextTodoId();
        }
        TodoSequencer.reset();
        Assert.assertTrue(expectedTodoId == PersonSequencer.nextPersonId());
    }*/
}
