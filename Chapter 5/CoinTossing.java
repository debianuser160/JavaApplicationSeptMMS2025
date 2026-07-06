import java.security.SecureRandom;
import java.util.Scanner;

public class CoinTossing
{
   enum Coin { HEADS, TAILS }

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int headsCount = 0;
      int tailsCount = 0;
      int choice;

      do
      {
         System.out.println();
         System.out.println("1. Toss Coin");
         System.out.println("2. Display Results");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");
         choice = input.nextInt();

         if (choice == 1)
         {
            Coin result = flip();

            if (result == Coin.HEADS)
            {
               System.out.println("The coin landed on HEADS!");
               headsCount++;
            }
            else
            {
               System.out.println("The coin landed on TAILS!");
               tailsCount++;
            }
         }
         else if (choice == 2)
         {
            System.out.printf("HEADS: %d times%n", headsCount);
            System.out.printf("TAILS: %d times%n", tailsCount);
         }

      } while (choice != 3);
   }

   public static Coin flip()
   {
      SecureRandom random = new SecureRandom();

      if (random.nextInt(2) == 0)
      {
         return Coin.HEADS;
      }
      else
      {
         return Coin.TAILS;
      }
   }
}
