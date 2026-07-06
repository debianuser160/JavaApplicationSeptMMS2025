public class PerfectNumbers
{
   public static void main(String[] args)
   {
      System.out.println("Perfect numbers between 1 and 1000:");

      for (int number = 1; number <= 1000; number++)
      {
         if (isPerfect(number))
         {
            System.out.print(number + " = 1");

            for (int factor = 2; factor < number; factor++)
            {
               if (number % factor == 0)
               {
                  System.out.print(" + " + factor);
               }
            }

            System.out.println();
         }
      }
   }

   public static boolean isPerfect(int number)
   {
      int sum = 0;

      for (int factor = 1; factor < number; factor++)
      {
         if (number % factor == 0)
         {
            sum = sum + factor;
         }
      }

      return sum == number;
   }
}
