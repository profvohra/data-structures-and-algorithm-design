package unit04_12Chapter09;

public class DisplayArrayADTDriver {
    
    public static void main(String[] args) {
        
        ArrayStack<Character> myStack = new ArrayStack<>();
        myStack.push('A');
        myStack.push('B');
        myStack.push('C');
        myStack.push('D');
        myStack.push('X');
        myStack.push('Y');
        myStack.push('Z');

        System.out.println("\nTesting ArrayStack display:");
        myStack.display();

        ArrayQueue<Integer> myQueue = new ArrayQueue<>(); 
 
        myQueue.enqueue(15);
        myQueue.enqueue(35);
        myQueue.enqueue(25);
        myQueue.enqueue(65);
        myQueue.enqueue(45);

        System.out.println("\nTesting ArrayQueue display:");
        myQueue.display();

    }
}
