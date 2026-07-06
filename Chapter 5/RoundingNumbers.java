import java.util.Scanner;

public class RoundingNumbers
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a double value (or 0 to quit): ");
      double x = input.nextDouble();

      while (x != 0)
      {
         double y = Math.floor(x + 0.5);

         System.out.printf("Original number: %.2f%n", x);
         System.out.printf("Rounded number: %.0f%n", y);

         System.out.print("Enter a double value (or 0 to quit): ");
         x = input.nextDouble();
      }
   }
}
