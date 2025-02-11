package unit04_12Chapter09;

import unit03_10Chapter07.QueueInterface;
import unit03_11Chapter08.EmptyQueueException;

/**
   A class that implements a queue of objects by using
   a chain of linked nodes that has both head and tail references.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class LinkedQueue<T> implements QueueInterface<T>
{
   private Node firstNode; // References node at front of queue
   private Node lastNode;  // References node at back of queue
  	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor

//  < Implementations of the queue operations go here. >
//  . . .

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public void enqueue(T newEntry)
    {
    Node newNode = new Node(newEntry, null);

    if (isEmpty())
        firstNode = newNode;
    else
        lastNode.setNextNode(newNode);
        
    lastNode = newNode;
    } // end enqueue

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T getFront()
    {
    if (isEmpty())
        throw new EmptyQueueException();
    else
        return firstNode.getData();
    } // end getFront

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T dequeue()
    {
    T front = getFront();  // Might throw EmptyQueueException
    // Assertion: firstNode != null
    firstNode.setData(null);
    firstNode = firstNode.getNextNode();

    if (firstNode == null)
        lastNode = null;

    return front;
    } // end dequeue

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public boolean isEmpty()
    {
    return (firstNode == null) && (lastNode == null);
    } // end isEmpty

    public void clear()
    {
    firstNode = null;
    lastNode = null;
    } // end clear

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public void display()
   {
      displayChain(firstNode);
   } // end display

   private void displayChain(Node nodeOne) 
   {
      if (nodeOne != null)
      {
         System.out.println(nodeOne.getData()); // Display data in first node
         displayChain(nodeOne.getNextNode());   // Display rest of chain
      } // end if
   } // end displayChain

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public void displayBackward()
   {
      displayChainBackward(firstNode);
   } // end displayBackward

   private void displayChainBackward(Node nodeOne) 
   {
      if (nodeOne != null)
      {
         displayChainBackward(nodeOne.getNextNode());
         System.out.println(nodeOne.getData());
      } // end if
   } // end displayChainBackward

	private class Node
	{
		private T    data; // Entry in queue
		private Node next; // Link to next node
      
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor
		
		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor
      
		private T getData()
		{
			return data;
		} // end getData
      
		private void setData(T newData)
		{
			data = newData;
		} // end setData
      
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LinkedQueue