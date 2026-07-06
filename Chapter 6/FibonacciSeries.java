import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n to calculate fibonacci(n): ");
        int n = input.nextInt();

        System.out.println("fibonacci(" + n + ") = " + fibonacci(n));

        System.out.println("\nLargest fibonacci number using int:");
        int a = 0, b = 1;
        int count = 0;
        while (a >= 0) {
            System.out.println("fibonacci(" + count + ") = " + a);
            int next = a + b;
            a = b;
            b = next;
            count++;
        }
        System.out.println("Overflow at n = " + (count - 1));

        System.out.println("\nLargest fibonacci number using double:");
        double da = 0, db = 1;
        count = 0;
        while (da < Double.MAX_VALUE / 2) {
            System.out.println("fibonacci(" + count + ") = " + da);
            double next = da + db;
            da = db;
            db = next;
            count++;
            if (count > 1500) break;
        }
    }

    public static long fibonacci(long n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long a = 0, b = 1;
        for (long i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}
