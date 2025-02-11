package unit04_12Chapter09;

public class DisplayArrayDriver {
    
    public static void main(String[] args) {
        int[] randomNumbers = { 58, 61, 28, 49, 4, 83, 98 };
        displayArray(randomNumbers, 0, randomNumbers.length - 1);
    }

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public static void displayArray(int array[], int first, int last)
    {
    if (first == last)
        System.out.print(array[first] + " ");
    else 
    {
        int mid = (first + last) / 2;
        displayArray(array, first, mid);
        displayArray(array, mid + 1, last);
    } // end if
    } // end displayArray
}
