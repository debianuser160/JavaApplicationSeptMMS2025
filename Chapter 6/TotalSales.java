import java.util.Scanner;

public class TotalSales {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] sales = new double[5][4];

        System.out.println("Enter sales data (salesperson 1-4, product 1-5, dollar value).");
        System.out.println("Enter -1 for salesperson to quit.");

        while (true) {
            System.out.print("Enter salesperson number (1-4): ");
            int person = input.nextInt();
            if (person == -1) break;

            System.out.print("Enter product number (1-5): ");
            int product = input.nextInt();

            System.out.print("Enter dollar value: ");
            double value = input.nextDouble();

            if (person >= 1 && person <= 4 && product >= 1 && product <= 5) {
                sales[product - 1][person - 1] += value;
            } else {
                System.out.println("Invalid input.");
            }
        }

        double[] productTotals = new double[5];
        double[] personTotals = new double[4];
        double grandTotal = 0;

        System.out.println("\n\t\tSalesperson 1\tSalesperson 2\tSalesperson 3\tSalesperson 4\tProduct Total");
        for (int p = 0; p < 5; p++) {
            System.out.print("Product " + (p + 1) + "\t");
            for (int sp = 0; sp < 4; sp++) {
                System.out.printf("\t$%.2f\t", sales[p][sp]);
                productTotals[p] += sales[p][sp];
                personTotals[sp] += sales[p][sp];
            }
            System.out.printf("\t$%.2f\n", productTotals[p]);
            grandTotal += productTotals[p];
        }

        System.out.print("Person Total\t");
        for (int sp = 0; sp < 4; sp++) {
            System.out.printf("\t$%.2f\t", personTotals[sp]);
        }
        System.out.printf("\t$%.2f\n", grandTotal);
    }
}
