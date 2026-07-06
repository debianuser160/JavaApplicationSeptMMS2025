import java.util.Scanner;

public class FindTheMinimum
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter first number: ");
      double num1 = input.nextDouble();

      System.out.print("Enter second number: ");
      double num2 = input.nextDouble();

      System.out.print("Enter third number: ");
      double num3 = input.nextDouble();

      double smallest = minimum3(num1, num2, num3);

      System.out.printf("The smallest value is: %f%n", smallest);
   }

   public static double minimum3(double a, double b, double c)
   {
      double smallest = Math.min(a, b);
      smallest = Math.min(smallest, c);
      return smallest;
   }
}
