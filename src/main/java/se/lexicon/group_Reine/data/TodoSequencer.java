package se.lexicon.group_Reine.data;

public class TodoSequencer {

    private static int todoId;              //variable created when program starts

    //class method for generating a new id number
    public static int nextTodoId(){
        todoId++;
        return todoId;
    }

    //class method for resetting id number
    public static void reset(){
        todoId = 0;
    }
}
