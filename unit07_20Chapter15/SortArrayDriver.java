package unit07_20Chapter15;

import java.util.Arrays;

public class SortArrayDriver {
  
  public static void main(String[] args) {
    
    Integer[] numbers = {15, 8, 10, 2, 5};
    SortArray.selectionSort(numbers, numbers.length);
    System.out.println(Arrays.toString(numbers));
    System.out.println();

    Integer[] moreNumbers = {2, 5, 8, 3, 9, 4, 1};
    SortArray.insertionSort(moreNumbers, 0, moreNumbers.length - 1);
    System.out.println();

    Integer[] evenMoreNumbers = {10, 16, 11, 4, 15, 3, 9, 6, 1, 17, 8, 12, 7};
    SortArray.shellSort(evenMoreNumbers, 0, evenMoreNumbers.length - 1);
  }
}
