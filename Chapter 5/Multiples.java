import java.util.Scanner;

public class Multiples
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the first integer (or 0 to quit): ");
      int first = input.nextInt();

      while (first != 0)
      {
         System.out.print("Enter the second integer: ");
         int second = input.nextInt();

         if (isMultiple(first, second))
         {
            System.out.printf("%d is a multiple of %d%n", second, first);
         }
         else
         {
            System.out.printf("%d is not a multiple of %d%n", second, first);
         }

         System.out.print("Enter the first integer (or 0 to quit): ");
         first = input.nextInt();
      }
   }

   public static boolean isMultiple(int first, int second)
   {
      return second % first == 0;
   }
}
