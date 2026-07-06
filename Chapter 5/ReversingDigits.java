import java.util.Scanner;

public class ReversingDigits
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter an integer: ");
      int number = input.nextInt();

      int reversed = reverseDigits(number);

      System.out.printf("Original number: %d%n", number);
      System.out.printf("Reversed number: %d%n", reversed);
   }

   public static int reverseDigits(int number)
   {
      int reversed = 0;

      while (number != 0)
      {
         int lastDigit = number % 10;
         reversed = reversed * 10 + lastDigit;
         number = number / 10;
      }

      return reversed;
   }
}
