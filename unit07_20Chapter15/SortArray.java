package unit07_20Chapter15;

import java.util.Arrays;

/**
 * A class of static, iterative methods for sorting an array of
 * Comparable objects from smallest to largest.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class SortArray {
  /**
   * Sorts the first n objects in an array into ascending order.
   * 
   * @param a An array of Comparable objects.
   * @param n An integer > 0.
   */
  public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
    System.out.println("--- Selection Sort ---");
    for (int index = 0; index < n - 1; index++) {
      System.out.print(Arrays.toString(a) + " ");
      int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
      System.out.println("Select " + a[indexOfNextSmallest]);
      swap(a, index, indexOfNextSmallest);
      // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]
    } // end for
  } // end selectionSort

  // Finds the index of the smallest value in a portion of an array a.
  // Precondition: a.length > last >= first >= 0.
  // Returns the index of the smallest value among
  // a[first], a[first + 1], . . . , a[last].
  private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
    T min = a[first];
    int indexOfMin = first;
    for (int index = first + 1; index <= last; index++) {
      if (a[index].compareTo(min) < 0) {
        min = a[index];
        indexOfMin = index;
      } // end if
      // Assertion: min is the smallest of a[first] through a[index].
    } // end for

    return indexOfMin;
  } // end getIndexOfSmallest

  // Swaps the array entries a[i] and a[j].
  private static void swap(Object[] a, int i, int j) {
    Object temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  } // end swap

  // @author Frank M. Carrano, Timothy M. Henry
  // @version 5.0
  public static <T extends Comparable<? super T>>
  void insertionSort(T[] a, int first, int last)
  {
    System.out.println("--- Insertion Sort ---");
     for (int unsorted = first + 1; unsorted <= last; unsorted++)
     {   // Assertion: a[first] <= a[first + 1] <= ... <= a[unsorted - 1]
        
        T firstUnsorted = a[unsorted];
        
        insertInOrder(firstUnsorted, a, first, unsorted - 1);
     } // end for
  } // end insertionSort

  private static <T extends Comparable<? super T>>
  void insertInOrder(T anEntry, T[] a, int begin, int end)
  {
     int index = end;
     
     while ((index >= begin) && (anEntry.compareTo(a[index]) < 0))
     {
      System.out.print(Arrays.toString(a));
      System.out.println(" Insert " + anEntry);
      a[index + 1] = a[index]; // Make room
      a[index] = anEntry;
        index--;
     } // end for
     
     // Assertion: a[index + 1] is available
     a[index + 1] = anEntry;  // Insert
     System.out.print(Arrays.toString(a));
     System.out.println(" Insert " + anEntry);
   } // end insertInOrder

       /** Sorts equally spaced elements of an array into ascending order.
    @param a      An array of Comparable objects.
    @param first  An integer >= 0 that is the index of the first
                  array element to consider.
    @param last   An integer >= first and < a.length that is the
                  index of the last array element to consider.
    @param space  The difference between the indices of the
                  elements to sort. */
   public static <T extends Comparable<? super T>>
   void shellSort(T[] a, int first, int last)
   {
    System.out.println("--- Shell Sort ---");
    System.out.print(Arrays.toString(a));
    int n = last - first + 1; // Number of array entries
    System.out.print(" Size: " + n);
      int space = n / 2;
      System.out.print(" Space: " + space);
      while (space > 0)
      {
          for (int begin = first; begin < first + space; begin++)
         {
          /** This code is for printing purposes only */
          System.out.print(" Order: ");
          for (int i = begin; i < last + 1; i += space)
            System.out.print(a[i] + " ");
          System.out.println();
          /** This code is for printing purposes only */

            incrementalInsertionSort(a, begin, last, space);
            System.out.print(Arrays.toString(a));
          } // end for
         space = space / 2;
         System.out.print(" Space: " + space);
        } // end while
        System.out.println();
   } // end shellSort

   private static <T extends Comparable<? super T>>
   void incrementalInsertionSort(T[] a, int first, int last, int space)
   {
      int unsorted, index;
      
      for (unsorted = first + space; unsorted <= last;
           unsorted = unsorted + space)
      {
         T nextToInsert = a[unsorted];
         index = unsorted - space;
         while ((index >= first) && (nextToInsert.compareTo(a[index]) < 0))
         {
          a[index + space] = a[index];
            index = index - space;
         } // end while
         
         a[index + space] = nextToInsert;
      } // end for
   } // end incrementalInsertionSort

} // end SortArray