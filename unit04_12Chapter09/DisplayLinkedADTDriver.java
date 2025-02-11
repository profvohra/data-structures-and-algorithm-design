package unit04_12Chapter09;

public class DisplayLinkedADTDriver {
    
    public static void main(String[] args) {
     
        LinkedStack<Character> myStack = new LinkedStack<>();
        myStack.push('A');
        myStack.push('B');
        myStack.push('C');
        myStack.push('D');
        myStack.push('X');
        myStack.push('Y');
        myStack.push('Z');

        System.out.println("\nTesting LinkedStack display:");
        myStack.display();
        System.out.println("\nTesting LinkedStack displayBackward:");
        myStack.displayBackward();

        LinkedQueue<Integer> myQueue = new LinkedQueue<>(); 
 
        myQueue.enqueue(15);
        myQueue.enqueue(35);
        myQueue.enqueue(25);
        myQueue.enqueue(65);
        myQueue.enqueue(45);

        System.out.println("\nTesting LinkedQueue display:");
        myQueue.display();
        System.out.println("\nTesting LinkedQueue displayBackward:");
        myQueue.displayBackward();
    }
}
