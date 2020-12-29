package se.lexicon.group_Reine.data;

public class PersonSequencer {

    private static int personId;        //variable created when program starts

    //class method for generating a new id number
    public static int nextPersonId(){
        personId++;
        return personId;
    }

    //class method for resetting id number
    public static void reset(){
        personId = 0;
    }

}
