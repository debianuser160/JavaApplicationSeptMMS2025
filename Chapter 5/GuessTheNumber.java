import java.security.SecureRandom;
import java.util.Scanner;

public class GuessTheNumber
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      SecureRandom random = new SecureRandom();

      int numberToGuess = 1 + random.nextInt(1000);

      System.out.println("Guess a number between 1 and 1000.");

      System.out.print("Enter your guess: ");
      int guess = input.nextInt();

      while (guess != numberToGuess)
      {
         if (guess > numberToGuess)
         {
            System.out.println("Too high. Try again.");
         }
         else
         {
            System.out.println("Too low. Try again.");
         }

         System.out.print("Enter your guess: ");
         guess = input.nextInt();
      }

      System.out.println("Congratulations. You guessed the number!");
   }
}
