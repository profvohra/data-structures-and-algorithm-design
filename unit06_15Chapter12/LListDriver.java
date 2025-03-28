package unit06_15Chapter12;

import unit06_13Chapter10.ListInterface;
import unit06_13Chapter10.RoadRace;

public class LListDriver {

// Listing 12-2
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public static void main(String[] args)
{
   System.out.println("Create an empty list.");
   ListInterface<String> myList = new LList<String>();
   System.out.println("List should be empty; isEmpty returns " + 
                      myList.isEmpty() + ".");

   System.out.println("\nTesting add to end:");
   myList.add("15");
   myList.add("25");
   myList.add("35");
   myList.add("45");
   System.out.println("List should contain 15 25 35 45.");		
   RoadRace.displayList(myList);   
   System.out.println("List should not be empty; isEmpty() returns " + 
                      myList.isEmpty() + ".");
   System.out.println("\nTesting clear():");
   myList.clear();
   System.out.println("List should be empty; isEmpty returns " + 
                      myList.isEmpty() + ".");
}  // end main
/* 
 Create an empty list.
 List should be empty; isEmpty returns true.
 
 Testing add to end:
 List should contain 15 25 35 45.
 The list contains 4 entries, as follows:
 15 25 35 45
 List should not be empty; isEmpty() returns false.
 
 Testing clear():
 List should be empty; isEmpty returns true.
*/


}
