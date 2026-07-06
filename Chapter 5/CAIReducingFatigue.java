import java.security.SecureRandom;
import java.util.Scanner;

public class CAIReducingFatigue
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
         displayIncorrectResponse();
         System.out.printf("How much is %d times %d? ", num1, num2);
         answer = input.nextInt();
      }

      displayCorrectResponse();

      askQuestion(input);
   }

   public static void displayCorrectResponse()
   {
      int choice = 1 + random.nextInt(4);

      switch (choice)
      {
         case 1:
            System.out.println("Very good!");
            break;
         case 2:
            System.out.println("Excellent!");
            break;
         case 3:
            System.out.println("Nice work!");
            break;
         case 4:
            System.out.println("Keep up the good work!");
            break;
      }
   }

   public static void displayIncorrectResponse()
   {
      int choice = 1 + random.nextInt(4);

      switch (choice)
      {
         case 1:
            System.out.println("No. Please try again.");
            break;
         case 2:
            System.out.println("Wrong. Try once more.");
            break;
         case 3:
            System.out.println("Don't give up!");
            break;
         case 4:
            System.out.println("Keep trying.");
            break;
      }
   }
}
