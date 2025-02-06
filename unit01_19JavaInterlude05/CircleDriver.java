package unit01_19JavaInterlude05;

/** 
   A driver that demonstrates the class Circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class CircleDriver
{
	public static void main(String[] args) 
	{
		Circle c1 = new Circle(5.0);
		Circle c2 = new Circle(5.0);
		Circle c3 = new Circle(9.0);
		
		System.out.println("c1 and c2 are equal:");
		System.out.println("c1.compareTo(c2): " + c1.compareTo(c2));
		System.out.println();
		                    
		System.out.println("c1 and c3 are not equal:");
		System.out.println("c1 < c3: ");
		System.out.println("c1.compareTo(c3): " + c1.compareTo(c3));
		System.out.println();
      
      System.out.println("\nDone.");
 	} // end main
	
} // end Driver

/*
 c1 and c2 are equal:
 c1.equals(c2): true
 c1.compareTo(c2): 0
 
 c1 and c3 are not equal:
 c1.equals(c3): false
 c1 < c3:
 c1.compareTo(c3): -1
 
 Done.
 
*/