import java.util.Scanner;

public class SeparatingDigits
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter an integer between 1 and 99999: ");
      int number = input.nextInt();

      displayDigits(number);
   }

   public static int integerQuotient(int a, int b)
   {
      return a / b;
   }

   public static int integerRemainder(int a, int b)
   {
      return a % b;
   }

   public static void displayDigits(int number)
   {
      int divisor = 1;

      while (number / divisor >= 10)
      {
         divisor = divisor * 10;
      }

      while (divisor > 0)
      {
         int digit = integerQuotient(number, divisor);
         System.out.printf("%d  ", digit);
         number = integerRemainder(number, divisor);
         divisor = integerQuotient(divisor, 10);
      }

      System.out.println();
   }
}
