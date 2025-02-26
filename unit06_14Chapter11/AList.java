package unit06_14Chapter11;

import java.util.Arrays;

import unit06_13Chapter10.ListInterface;

/**
   A class that implements a list of objects by using an array.
   Entries in a list have positions that begin with 1.
   Duplicate entries are allowed.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class AList<T> implements ListInterface<T>
{
	private T[] list;   // Array of list entries; ignore list[0]
	private int numberOfEntries;
   private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
   
	public AList()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
   
	public AList(int initialCapacity)
	{
      integrityOK = false;
      
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempList = (T[])new Object[initialCapacity + 1];
      list = tempList;
      numberOfEntries = 0;
      integrityOK = true;
	} // end constructor

   // Throws an exception if this object is not initialized.
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
   } // end checkIntegrity
   
   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose " +
                                         "capacity exeeds allowed " +
                                         "maximum of " + MAX_CAPACITY);
   } // end checkCapacity

	public void add(T newEntry)
	{
       checkIntegrity();
       list[numberOfEntries + 1] = newEntry;
       numberOfEntries++;
       ensureCapacity();
//     add(numberOfEntries + 1, newEntry);  // ALTERNATE CODE
	} // end add

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public void add(int newPosition, T newEntry)
   {
      checkIntegrity();
      // Assertion: The array list has room for another entry.
      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
      {
         if (newPosition <= numberOfEntries)
            makeRoom(newPosition);
         list[newPosition] = newEntry;
         numberOfEntries++;
         ensureCapacity(); // Ensure enough room for next add
      }
      else
         throw new IndexOutOfBoundsException(
                  "Given position of add's new entry is out of bounds.");
   } // end add

   private void makeRoom(int givenPosition)
   {
      int newIndex = givenPosition;
      int lastIndex = numberOfEntries;
      for (int index = lastIndex; index >= newIndex; index--)
         list[index + 1] = list[index];
   }  // end makeRoom

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public T remove(int givenPosition)
   {
      checkIntegrity();
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: The list is not empty
         T result = list[givenPosition]; // Get entry to be removed
         // Move subsequent entries towards entry to be removed,
         // unless it is last in list
         if (givenPosition < numberOfEntries)
            removeGap(givenPosition);
         list[numberOfEntries] = null;
         numberOfEntries--;
         return result; // Return reference to removed entry
      }
      else
         throw new IndexOutOfBoundsException(
                  "Illegal position given to remove operation.");
   } // end remove

   // Shifts entries that are beyond the entry to be removed to the
   // next lower position.
   // Precondition: 1 <= givenPosition < numberOfEntries;
   //               numberOfEntries is list's length before removal;
   //               checkIntegrity has been called.
   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   private void removeGap(int givenPosition)
   {
      int removedIndex = givenPosition;
      for (int index = removedIndex; index < numberOfEntries; index++)
         list[index] = list[index + 1];
   } // end removeGap

	public void clear()
	{ /* < Implementation deferred > */
	} // end clear

	public T replace(int givenPosition, T newEntry)
	{
      checkIntegrity();
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: The list is not empty
         T originalEntry = list[givenPosition];
         list[givenPosition] = newEntry;
         return originalEntry;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition) 
	{
      checkIntegrity();
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: The list is not empty
         return list[givenPosition];
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
   } // end getEntry

   public T[] toArray()
   {
		checkIntegrity();
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = list[index + 1];
      } // end for
      
      return result;
   } // end toArray
   
   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   public boolean contains(T anEntry)
   {
      checkIntegrity();
      boolean found = false;
      int index = 1;
      while (!found && (index <= numberOfEntries))
      {
         if (anEntry.equals(list[index]))
            found = true;
         index++;
      } // end while
      return found;
   } // end contains

	public int getLength()
	{
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty()
	{
		return numberOfEntries == 0; // Or getLength() == 0
	} // end isEmpty

   // Doubles the capacity of the array list if it is full.
   // Precondition: checkIntegrity has been called.
   private void ensureCapacity()
   {
      int capacity = list.length - 1;
      if (numberOfEntries >= capacity)
      {
         int newCapacity = 2 * capacity;
         checkCapacity(newCapacity); // Is capacity too big?
         list = Arrays.copyOf(list, newCapacity + 1);
      } // end if
   } // end ensureCapacity

} // end AList