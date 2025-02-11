package unit04_12Chapter09;

public class CountDownDriver {
    
    public static void main(String[] args) {
        countDown(3);
    }

    /** Counts down from a given positive integer.
        @param integer  An integer > 0.
        @author Frank M. Carrano, Timothy M. Henry
        @version 5.0
    */
    public static void countDown(int integer)
    {
    System.out.println(integer);
    if (integer > 1)
        countDown(integer - 1);
    } // end countDown
}
