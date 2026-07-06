import java.util.Scanner;

public class SquareOfAsterisks
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the side length of the square: ");
      int side = input.nextInt();

      squareOfAsterisks(side);
   }

   public static void squareOfAsterisks(int side)
   {
      for (int row = 1; row <= side; row++)
      {
         for (int col = 1; col <= side; col++)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   }
}
