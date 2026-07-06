import java.util.Scanner;

public class SalesCommissions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] counters = new int[9];

        System.out.print("Enter number of salespeople: ");
        int numSalespeople = input.nextInt();

        for (int i = 0; i < numSalespeople; i++) {
            System.out.print("Enter gross sales for salesperson " + (i + 1) + ": ");
            double grossSales = input.nextDouble();
            int salary = (int) (200 + grossSales * 0.09);

            if (salary >= 1000) {
                counters[8]++;
            } else if (salary >= 200) {
                int index = (salary - 200) / 100;
                counters[index]++;
            }
        }

        System.out.println("\nSalary Range\t\tCount");
        System.out.println("$200-299\t\t" + counters[0]);
        System.out.println("$300-399\t\t" + counters[1]);
        System.out.println("$400-499\t\t" + counters[2]);
        System.out.println("$500-599\t\t" + counters[3]);
        System.out.println("$600-699\t\t" + counters[4]);
        System.out.println("$700-799\t\t" + counters[5]);
        System.out.println("$800-899\t\t" + counters[6]);
        System.out.println("$900-999\t\t" + counters[7]);
        System.out.println("$1000 and over\t\t" + counters[8]);
    }
}
