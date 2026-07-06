public class NumberSystemTable
{
   public static void main(String[] args)
   {
      System.out.printf("%-10s%-15s%-10s%-10s%n", "Decimal", "Binary", "Octal", "Hex");
      System.out.println("--------------------------------------------------");

      for (int decimal = 1; decimal <= 256; decimal++)
      {
         System.out.printf("%-10d%-15s%-10s%-10s%n",
            decimal,
            toBinary(decimal),
            toOctal(decimal),
            toHex(decimal));
      }
   }

   public static String toBinary(int number)
   {
      String result = "";

      if (number == 0)
      {
         return "0";
      }

      while (number > 0)
      {
         result = (number % 2) + result;
         number = number / 2;
      }

      return result;
   }

   public static String toOctal(int number)
   {
      String result = "";

      if (number == 0)
      {
         return "0";
      }

      while (number > 0)
      {
         result = (number % 8) + result;
         number = number / 8;
      }

      return result;
   }

   public static String toHex(int number)
   {
      String result = "";
      String hexDigits = "0123456789ABCDEF";

      if (number == 0)
      {
         return "0";
      }

      while (number > 0)
      {
         result = hexDigits.charAt(number % 16) + result;
         number = number / 16;
      }

      return result;
   }
}
