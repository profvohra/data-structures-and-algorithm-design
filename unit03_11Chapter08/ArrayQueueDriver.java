package unit03_11Chapter08;

import unit03_10Chapter07.QueueInterface;

/**
* A driver that demonstrates the class ArrayQueue.
*
* @author Frank M. Carrano
* @author Timothy M. Henry
* @version 5.0
*/
public class ArrayQueueDriver {
    public static void main(String[] args) {
        System.out.println("Create a queue: ");
        QueueInterface<Integer> myQueue = new ArrayQueue<>();
        System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n\n");
 
 
        System.out.println("Add to queue to get\n" +
                "15 35 25\n");
        myQueue.enqueue(15);
        myQueue.enqueue(35);
        myQueue.enqueue(25);
 
 
        while (!myQueue.isEmpty()) {
            Integer front = myQueue.getFront();
            System.out.println(front + " is at the front of the queue.");
 
 
            front = myQueue.dequeue();
            System.out.println(front + " is removed from the front of the queue.\n");
        } // end while
 
        System.out.print("\n\nThe queue should be empty: ");
       System.out.println("isEmpty() returns " + myQueue.isEmpty() + "\n");


       System.out.println("The next call to getFront will throw an exception." + "\n");
       try {
           System.out.println("myQueue.getFront() returns " + myQueue.getFront());
       } catch (Exception e) {
           System.out.println("Exception: " + e);
       }
       System.out.println("The next call to dequeue will throw an exception." + "\n");
       try {
           System.out.println("myQueue.dequeue() returns " + myQueue.dequeue() + "\n");
       } catch (Exception e) {
           System.out.println("Exception: " + e);
       }
       System.out.println("\n\nDone.");


   } // end main
} // end ArrayQueueDriver

 