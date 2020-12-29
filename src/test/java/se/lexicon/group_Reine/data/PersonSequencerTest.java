package se.lexicon.group_Reine.data;

import org.junit.Test;
import org.junit.Assert;

import java.sql.SQLOutput;

public class PersonSequencerTest {

    //two calls to id counter to verify it counts up
    @Test
    public void testNextPersonId (){
        PersonSequencer.reset();
        int expectedPersonId = 1;
        Assert.assertTrue(expectedPersonId == PersonSequencer.nextPersonId());
        expectedPersonId++;
        Assert.assertTrue(expectedPersonId == PersonSequencer.nextPersonId());
    }

    //call up-counting id counter a few times and then reset to zero
    @Test
    public void testReset() {
        int expectedPersonId = 1;
        int testCounter = 0;
        for (int i = 0; i < 3; i++) {
            testCounter = PersonSequencer.nextPersonId();
        }
        PersonSequencer.reset();
        Assert.assertTrue(expectedPersonId == PersonSequencer.nextPersonId());
    }
}
