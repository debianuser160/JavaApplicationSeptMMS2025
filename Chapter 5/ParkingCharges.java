import java.util.Scanner;

public class ParkingCharges
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      double totalReceipts = 0.0;

      System.out.print("Enter hours parked (or -1 to quit): ");
      double hours = input.nextDouble();

      while (hours != -1)
      {
         double charge = calculateCharges(hours);
         totalReceipts = totalReceipts + charge;

         System.out.printf("Current charge: $%.2f%n", charge);
         System.out.printf("Total receipts: $%.2f%n", totalReceipts);

         System.out.print("Enter hours parked (or -1 to quit): ");
         hours = input.nextDouble();
      }
   }

   public static double calculateCharges(double hours)
   {
      double charge = 2.00;

      if (hours > 3.0)
      {
         charge = charge + 0.50 * Math.ceil(hours - 3.0);
      }

      if (charge > 10.00)
      {
         charge = 10.00;
      }

      return charge;
   }
}
