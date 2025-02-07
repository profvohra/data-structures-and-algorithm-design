package unit03_10Chapter07;

import java.util.PriorityQueue;
import java.util.Queue;


/**
* A driver that demonstrates the class PriorityQueue.
*
* @author Frank M. Carrano
* @author Timothy M. Henry
* @version 5.0
*/
public class PriorityQueueDriver {
 public static void main(String[] args) {
   System.out.println("Create a queue: ");
   Queue<Integer> myQueue = new PriorityQueue<>();
   System.out.println("\n\nisEmpty() returns " + myQueue.isEmpty() + "\n");


   System.out.println("Add to queue to get\n" +
       "38 72 56 91 45 63\n");
   myQueue.offer(38);
   myQueue.offer(72);
   myQueue.offer(56);
   myQueue.offer(91);
   myQueue.offer(45);
   myQueue.offer(63);


   System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n");

   System.out.println("\n\nTesting peek and poll:\n");
   while (!myQueue.isEmpty()) {
     Integer front = myQueue.peek();
     System.out.println(front + " is at the front of the queue.");


     front = myQueue.poll();
     System.out.println(front + " is removed from the front of the queue.\n");
   } // end while


   System.out.print("\nThe queue should be empty: ");
   System.out.println("isEmpty() returns " + myQueue.isEmpty() + "\n\n");


   System.out.println("\n\nDone.");


 } // end main
} // end NumbersDriver

