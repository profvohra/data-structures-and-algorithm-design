package unit03_11Chapter08;

import unit03_10Chapter07.QueueInterface;

/**
* A driver that demonstrates the class LinkedQueue.
*
* @author Frank M. Carrano
* @author Timothy M. Henry
* @version 5.0
*/
public class LinkedQueueDriver {
    public static void main(String[] args) {
        System.out.println("Create a queue: ");
        QueueInterface<Integer> myQueue = new LinkedQueue<>();
        System.out.println("\n\nisEmpty() returns " + myQueue.isEmpty() + "\n");
 
 
        System.out.println("Add to queue to get\n" +
                "42 83 57\n");
        myQueue.enqueue(42);
        myQueue.enqueue(83);
        myQueue.enqueue(57);
 
 
        System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n");
    
        System.out.println("\n\nTesting getFront and dequeue:\n");
        while (!myQueue.isEmpty()) {
            Integer front = myQueue.getFront();
            System.out.println(front + " is at the front of the queue.");
 
 
            front = myQueue.dequeue();
            System.out.println(front + " is removed from the front of the queue.\n");
       } // end while


       System.out.println("\nisEmpty() returns " + myQueue.isEmpty() + "\n\n");
       System.out.println("\n\nDone.");


   } // end main
} // end NumbersDriver
