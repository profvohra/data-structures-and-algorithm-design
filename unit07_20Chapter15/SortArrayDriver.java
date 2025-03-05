package unit07_20Chapter15;

import java.util.Arrays;

public class SortArrayDriver {
  
  public static void main(String[] args) {
    
    Integer[] numbers = {15, 8, 10, 2, 5};
    System.out.println("Initial Array: " + Arrays.toString(numbers));
    SortArray.selectionSort(numbers, numbers.length);
    System.out.println("Selection Sorted Array: " + Arrays.toString(numbers));

    System.out.println();
    Integer[] moreNumbers = {2, 5, 8, 3, 9, 4, 1};
    System.out.println("Initial Array: " + Arrays.toString(moreNumbers));
    SortArray.insertionSort(moreNumbers, 0, moreNumbers.length - 1);
    System.out.println("Insertion Sorted Array: " + Arrays.toString(moreNumbers));

    System.out.println();
    Integer[] evenMoreNumbers = {10, 16, 11, 4, 15, 3, 9, 6, 1, 17, 8, 12, 7};
    System.out.println("Initial Array: " + Arrays.toString(evenMoreNumbers) + " of size " + evenMoreNumbers.length);
    SortArray.shellSort(evenMoreNumbers, 0, evenMoreNumbers.length - 1);
    System.out.println("Shell Sorted Array: " + Arrays.toString(evenMoreNumbers));
  }
}
