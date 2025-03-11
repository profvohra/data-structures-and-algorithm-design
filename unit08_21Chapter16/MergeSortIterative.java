package unit08_21Chapter16;

public class MergeSortIterative {

   // MERGE SORT
   
   public static <T extends Comparable<? super T>>
   void iterativeMergeSort(T[] a, int n)
   {
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempArray = (T[])new Comparable<?>[a.length]; // unchecked cast
      int beginLeftovers = n;
      
      for (int segmentLength = 1; segmentLength <= n/2; segmentLength = 2*segmentLength)
      {
         beginLeftovers = mergeSegmentPairs(a, tempArray, n, segmentLength);
         
         // Two full segments do not remain at end; the following are possibilites:
         //   a. one full segment and a partial second segment
         //   b. one full segment only
         //   c. one partial segment
         //   d. nothing is left at end
         int endSegment = beginLeftovers + segmentLength - 1;
         
         if (endSegment < n - 1)
            // Case a: one full segment and a partial second segment exist, so merge them
            merge(a, tempArray, beginLeftovers, endSegment, n-1);
         
         // else Cases b, c, or d: only one full or partial segment is left (leave it in place)
         //                        or nothing is left
      } // end for
      
      // merge the sorted leftovers, if any, with the rest of the sorted array
      
      if (beginLeftovers < n)
         merge(a, tempArray, 0, beginLeftovers-1, n-1);
   } // end iterativeMergeSort
   
   // Merges pairs of segments of a given length within an array
   // and returns the index after the last merged pair.
   private static <T extends Comparable<? super T>>
   int mergeSegmentPairs(T[] a, T[] tempArray, int n, int segmentLength)
   {
      int mergedPairLength = 2 * segmentLength; // Length of two merged segments
      int numberOfPairs = n / mergedPairLength;
      
      int beginSegment1 = 0;
      
      for (int count = 1; count <= numberOfPairs; count++)
      {
         int endSegment1 = beginSegment1 + segmentLength - 1;
         
         int beginSegment2 = endSegment1 + 1;
         int endSegment2 = beginSegment2 + segmentLength - 1;
         
         merge(a, tempArray, beginSegment1, endSegment1, endSegment2);
         
         beginSegment1 = endSegment2 + 1;
      } // end for
      
      return beginSegment1; // Return index of element after last merged pair
   }  // end mergeSegmentPairs
   
   private static <T extends Comparable<? super T>>
   void merge(T[] a, T[] tempArray, int first, int mid, int last)
   {
      // Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
      int beginHalf1 = first;
      int endHalf1 = mid;
      int beginHalf2 = mid + 1;
      int endHalf2 = last;
      
      // While both subarrays are not empty, copy the
      // smaller item into the temporary array
      int index = beginHalf1; // Next available location in tempArray
      for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
      {  // Invariant: tempArray[beginHalf1..index-1] is in order
         
         if (a[beginHalf1].compareTo(a[beginHalf2]) < 0)
         {
            tempArray[index] = a[beginHalf1];
            beginHalf1++;
         }
         else
         {
            tempArray[index] = a[beginHalf2];
            beginHalf2++;
         }  // end if
      }  // end for
      
      // Finish off the nonempty subarray
      
      // Finish off the first subarray, if necessary
      for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
         // Invariant: tempArray[beginHalf1..index-1] is in order
         tempArray[index] = a[beginHalf1];
      
      // Finish off the second subarray, if necessary
      for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
         // Invariant: tempa[beginHalf1..index-1] is in order
         tempArray[index] = a[beginHalf2];
      
      // Copy the result back into the original array
      for (index = first; index <= last; index++)
         a[index] = tempArray[index];
   }  // end merge
      // -------------------------------------------------------------------------------}
}