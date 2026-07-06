import java.security.SecureRandom;
import java.util.Scanner;

public class CAIDifficultyLevels
{
   private static final SecureRandom random = new SecureRandom();

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter difficulty level (1, 2, 3, etc.): ");
      int difficulty = input.nextInt();

      int totalQuestions = 0;
      int correctAnswers = 0;

      while (totalQuestions < 10)
      {
         if (askQuestion(input, difficulty))
         {
            displayCorrectResponse();
            correctAnswers++;
         }
         else
         {
            displayIncorrectResponse();
         }

         totalQuestions++;
      }

      double percentage = (double) correctAnswers / 10 * 100;

      System.out.printf("You got %d out of 10 correct (%.1f%%).%n",
         correctAnswers, percentage);

      if (percentage < 75)
      {
         System.out.println("Please ask your teacher for extra help.");
      }
      else
      {
         System.out.println("Congratulations, you are ready to go to the next level!");
      }
   }

   public static boolean askQuestion(Scanner input, int difficulty)
   {
      int max = (int) Math.pow(10, difficulty) - 1;
      if (max < 1)
      {
         max = 9;
      }

      int num1 = 1 + random.nextInt(max);
      int num2 = 1 + random.nextInt(max);

      System.out.printf("How much is %d times %d? ", num1, num2);
      int answer = input.nextInt();

      while (answer != num1 * num2)
      {
         displayIncorrectResponse();
         System.out.printf("How much is %d times %d? ", num1, num2);
         answer = input.nextInt();
      }

      return true;
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
