package unit02_07Chapter05;

import java.util.Stack;

/**
 * A driver that demonstrates the class Stack.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class StackDriver {
    public static void main(String[] args) {
        System.out.println("Create a stack: ");
        Stack<Character> myStack = new Stack<>();
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nAdd to stack to get\n" +
                "A B C D X Y Z");
        myStack.push('A');
        myStack.push('B');
        myStack.push('C');
        myStack.push('D');
        myStack.push('X');
        myStack.push('Y');
        myStack.push('Z');
        System.out.println("\nisEmpty() returns " + myStack.isEmpty());

        System.out.println("\nTesting peek and pop:");
        while (!myStack.isEmpty()) {
            Character top = myStack.peek();
            System.out.println("\n" + top + " is at the top of the stack.");

            top = myStack.pop();
            System.out.println(top + " is removed from the stack.");
        } // end while

        System.out.print("\nThe stack should be empty: ");
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nAdd to stack to get\n" +
                "E F G H I J K\n");
        myStack.push('E');
        myStack.push('F');
        myStack.push('G');
        myStack.push('H');
        myStack.push('I');
        myStack.push('J');
        myStack.push('K');

        System.out.println("\nTesting clear:");
        myStack.clear();

        System.out.println("The stack should be empty: ");
        System.out.println("\nisEmpty() returns " + myStack.isEmpty());

        System.out.println("\n myStack.peek() returns ");
        try {
            System.out.println(myStack.peek());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("\n myStack.pop() returns ");
        try {
            System.out.println(myStack.pop());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("\n\nDone.");

    } // end main
} // end Driver
