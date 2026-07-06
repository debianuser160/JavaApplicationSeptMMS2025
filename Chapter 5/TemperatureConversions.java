import java.util.Scanner;

public class TemperatureConversions
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.println("Choose an option:");
      System.out.println("1. Convert Fahrenheit to Celsius");
      System.out.println("2. Convert Celsius to Fahrenheit");
      System.out.print("Enter 1 or 2: ");
      int choice = input.nextInt();

      if (choice == 1)
      {
         System.out.print("Enter temperature in Fahrenheit: ");
         double fahrenheit = input.nextDouble();
         double celsiusResult = celsius(fahrenheit);
         System.out.printf("%.1f degrees Fahrenheit = %.1f degrees Celsius%n",
            fahrenheit, celsiusResult);
      }
      else if (choice == 2)
      {
         System.out.print("Enter temperature in Celsius: ");
         double celsiusValue = input.nextDouble();
         double fahrenheitResult = fahrenheit(celsiusValue);
         System.out.printf("%.1f degrees Celsius = %.1f degrees Fahrenheit%n",
            celsiusValue, fahrenheitResult);
      }
      else
      {
         System.out.println("Invalid choice.");
      }
   }

   public static double celsius(double fahrenheit)
   {
      return 5.0 / 9.0 * (fahrenheit - 32);
   }

   public static double fahrenheit(double celsius)
   {
      return 9.0 / 5.0 * celsius + 32;
   }
}
