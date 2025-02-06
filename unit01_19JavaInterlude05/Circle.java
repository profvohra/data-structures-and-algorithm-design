package unit01_19JavaInterlude05;
/**
   A class that represents a circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Circle implements Comparable<Circle>
{
   private double radius;

   // Definitions of constructors and methods are here.
   // . . .

   public Circle(double radius) {
      this.radius = radius;
   }

   public int compareTo(Circle other)
   {
      int result;
      if (this.radius == other.radius)
         result = 0;
      else if (this.radius < other.radius)
         result = -1;
      else 
         result = 1;

      return result;
   } // compareTo
} // end Circle