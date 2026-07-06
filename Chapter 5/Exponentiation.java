import java.util.Scanner;

public class Exponentiation
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the base (integer): ");
      int base = input.nextInt();

      System.out.print("Enter the exponent (positive integer): ");
      int exponent = input.nextInt();

      int result = integerPower(base, exponent);

      System.out.printf("%d raised to the power of %d is %d%n", base, exponent, result);
   }

   public static int integerPower(int base, int exponent)
   {
      int result = 1;

      for (int i = 1; i <= exponent; i++)
      {
         result = result * base;
      }

      return result;
   }
}
