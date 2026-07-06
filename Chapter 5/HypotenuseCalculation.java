import java.util.Scanner;

public class HypotenuseCalculation
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the length of side 1: ");
      double side1 = input.nextDouble();

      System.out.print("Enter the length of side 2: ");
      double side2 = input.nextDouble();

      double hyp = hypotenuse(side1, side2);

      System.out.printf("The hypotenuse is: %f%n", hyp);
   }

   public static double hypotenuse(double side1, double side2)
   {
      return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
   }
}
