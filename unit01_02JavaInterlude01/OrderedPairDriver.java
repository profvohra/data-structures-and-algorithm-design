package unit01_02JavaInterlude01;

/** 
   A driver that demonstrates the class OrderedPair.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class OrderedPairDriver
{
	public static void main(String[] args) 
	{
		OrderedPair<String> fruit = new OrderedPair<>("apples", "oranges");
		System.out.println(fruit);
		fruit.changeOrder();
		System.out.println(fruit);

		OrderedPair<Integer> numbers = new OrderedPair<>(45, 89);
		System.out.println(numbers);
		numbers.changeOrder();
		System.out.println(numbers);
      
      System.out.println("\nDone.");
	} // end main
} // end Driver

/*
 (apples, oranges)
 (oranges, apples)
 (45, 89)
 (89, 45)
 
 Done.
*/
