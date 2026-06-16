import java.util.Scanner;

public class MultipleSumAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int sum1 = numbers[0] + numbers[4] + numbers[9];
        int sum2 = numbers[2] + numbers[7] + numbers[1];
        int product = sum1 * sum2;
        int sum3 = numbers[3] + numbers[6] + numbers[7] + numbers[8];
        int result = sum3 - product;

        if (result >= 100) {
            System.out.println("hurray I did it");
        } else {
            System.out.println("I still need to learn more in Java");
        }
    }
}
