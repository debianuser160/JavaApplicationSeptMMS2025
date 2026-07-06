import java.util.Scanner;

public class CircleArea
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the radius of the circle: ");
      double radius = input.nextDouble();

      double area = circleArea(radius);

      System.out.printf("The area of the circle is: %f%n", area);
   }

   public static double circleArea(double radius)
   {
      return Math.PI * radius * radius;
   }
}
