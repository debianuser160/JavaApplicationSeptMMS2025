import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter hours worked: ");
        int hours = input.nextInt();

        System.out.print("Enter hourly rate: ");
        float rate = input.nextFloat();
		

        double gross = hours * rate;
        double tax = gross * 0.12;
        double net = gross - tax;

        System.out.println("\n--- Pay Slip ---");
        System.out.printf("Employee: %s%n",name);
        System.out.printf("Gross Salary: $%.2f%n",gross);
        System.out.printf("Tax (12%%): $%.2f%n",tax);
        System.out.printf("Net Salary: $%.2f",net);

    }
}
