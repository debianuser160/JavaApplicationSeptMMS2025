import java.security.SecureRandom;
import java.util.Scanner;

public class GuessTheNumberModification
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      SecureRandom random = new SecureRandom();

      int numberToGuess = 1 + random.nextInt(1000);
      int numberOfGuesses = 0;

      System.out.println("Guess a number between 1 and 1000.");

      System.out.print("Enter your guess: ");
      int guess = input.nextInt();
      numberOfGuesses++;

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
         numberOfGuesses++;
      }

      System.out.println("Congratulations. You guessed the number!");
      System.out.printf("Number of guesses: %d%n", numberOfGuesses);

      if (numberOfGuesses < 10)
      {
         System.out.println("Either you know the secret or you got lucky!");
      }
      else if (numberOfGuesses == 10)
      {
         System.out.println("Aha! You know the secret!");
      }
      else
      {
         System.out.println("You should be able to do better!");
      }
   }
}
