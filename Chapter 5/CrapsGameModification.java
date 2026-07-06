import java.security.SecureRandom;
import java.util.Scanner;

public class CrapsGameModification
{
   private static final SecureRandom randomNumbers = new SecureRandom();

   private enum Status { CONTINUE, WON, LOST }

   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;
   private static final int SEVEN = 7;
   private static final int YO_LEVEN = 11;
   private static final int BOX_CARS = 12;

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      int bankBalance = 1000;

      System.out.println("Welcome to the Craps Game!");
      System.out.printf("Your starting bank balance is $%d%n", bankBalance);

      while (bankBalance > 0)
      {
         System.out.print("Enter your wager: ");
         int wager = input.nextInt();

         while (wager > bankBalance)
         {
            System.out.print("Wager cannot exceed your bank balance. Enter again: ");
            wager = input.nextInt();
         }

         displayChatter();

         int myPoint = 0;
         Status gameStatus;

         int sumOfDice = rollDice();

         switch (sumOfDice)
         {
            case SEVEN:
            case YO_LEVEN:
               gameStatus = Status.WON;
               break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
               gameStatus = Status.LOST;
               break;
            default:
               gameStatus = Status.CONTINUE;
               myPoint = sumOfDice;
               System.out.printf("Point is %d%n", myPoint);
               break;
         }

         while (gameStatus == Status.CONTINUE)
         {
            sumOfDice = rollDice();

            if (sumOfDice == myPoint)
            {
               gameStatus = Status.WON;
            }
            else if (sumOfDice == SEVEN)
            {
               gameStatus = Status.LOST;
            }
         }

         if (gameStatus == Status.WON)
         {
            System.out.println("Player wins!");
            bankBalance = bankBalance + wager;
            System.out.printf("New bank balance: $%d%n", bankBalance);
         }
         else
         {
            System.out.println("Player loses.");
            bankBalance = bankBalance - wager;
            System.out.printf("New bank balance: $%d%n", bankBalance);

            if (bankBalance == 0)
            {
               System.out.println("Sorry. You busted!");
               break;
            }
         }
      }
   }

   public static int rollDice()
   {
      int die1 = 1 + randomNumbers.nextInt(6);
      int die2 = 1 + randomNumbers.nextInt(6);

      int sum = die1 + die2;

      System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

      return sum;
   }

   public static void displayChatter()
   {
      int message = 1 + randomNumbers.nextInt(4);

      switch (message)
      {
         case 1:
            System.out.println("Oh, you're going for broke, huh?");
            break;
         case 2:
            System.out.println("Aw c'mon, take a chance!");
            break;
         case 3:
            System.out.println("You're up big. Now's the time to cash in your chips!");
            break;
         case 4:
            System.out.println("Let's see what luck brings you!");
            break;
      }
   }
}
