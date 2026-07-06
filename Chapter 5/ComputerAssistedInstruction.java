import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerAssistedInstruction
{
   private static final SecureRandom random = new SecureRandom();

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      askQuestion(input);
   }

   public static void askQuestion(Scanner input)
   {
      int num1 = 1 + random.nextInt(9);
      int num2 = 1 + random.nextInt(9);

      System.out.printf("How much is %d times %d? ", num1, num2);
      int answer = input.nextInt();

      while (answer != num1 * num2)
      {
         System.out.println("No. Please try again.");
         System.out.printf("How much is %d times %d? ", num1, num2);
         answer = input.nextInt();
      }

      System.out.println("Very good!");

      askQuestion(input);
   }
}
