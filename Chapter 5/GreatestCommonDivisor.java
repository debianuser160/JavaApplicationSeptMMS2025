import java.util.Scanner;

public class GreatestCommonDivisor
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter first integer: ");
      int num1 = input.nextInt();

      System.out.print("Enter second integer: ");
      int num2 = input.nextInt();

      int result = gcd(num1, num2);

      System.out.printf("The greatest common divisor of %d and %d is %d%n",
         num1, num2, result);
   }

   public static int gcd(int a, int b)
   {
      while (b != 0)
      {
         int remainder = a % b;
         a = b;
         b = remainder;
      }

      return a;
   }
}
