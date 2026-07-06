import java.util.Scanner;

public class EvenOrOdd
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter an integer (or 0 to quit): ");
      int number = input.nextInt();

      while (number != 0)
      {
         if (isEven(number))
         {
            System.out.printf("%d is even%n", number);
         }
         else
         {
            System.out.printf("%d is odd%n", number);
         }

         System.out.print("Enter an integer (or 0 to quit): ");
         number = input.nextInt();
      }
   }

   public static boolean isEven(int number)
   {
      return number % 2 == 0;
   }
}
