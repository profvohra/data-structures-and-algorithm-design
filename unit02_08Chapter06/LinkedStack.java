package unit02_08Chapter06;

import java.util.EmptyStackException;

import unit02_07Chapter05.StackInterface;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor
  
//  < Implementations of the stack operations go here. >
//  . . .

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public void push(T newEntry)
   {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
   } // end push

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public T peek()
   {
      if (isEmpty())
         throw new EmptyStackException();
      else
         return topNode.getData();
   } // end peek

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public T pop()
   {
      T top = peek();  // Might throw EmptyStackException

      // Assertion: topNode != null
      topNode = topNode.getNextNode();

      return top;
   } // end pop

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public boolean isEmpty()
   {
      return topNode == null;
   } // end isEmpty

   public void clear()
   {
      topNode = null;
   } // end clear

	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
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
      
      
      @SuppressWarnings("unused")
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      @SuppressWarnings("unused")
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedStack