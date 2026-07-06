import java.util.Scanner;

public class SquareOfAnyCharacter
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the side length of the square: ");
      int side = input.nextInt();

      System.out.print("Enter the character to fill the square: ");
      char fill = input.next().charAt(0);

      squareOfCharacters(side, fill);
   }

   public static void squareOfCharacters(int side, char fillCharacter)
   {
      for (int row = 1; row <= side; row++)
      {
         for (int col = 1; col <= side; col++)
         {
            System.out.print(fillCharacter);
         }
         System.out.println();
      }
   }
}
