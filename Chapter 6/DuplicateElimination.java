import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        int uniqueCount = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number between 10 and 100: ");
            int num = input.nextInt();

            if (num < 10 || num > 100) {
                System.out.println("Number out of range. Please enter between 10 and 100.");
                i--;
                continue;
            }

            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (numbers[j] == num) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                numbers[uniqueCount] = num;
                uniqueCount++;
            }

            System.out.print("Unique values: ");
            for (int j = 0; j < uniqueCount; j++) {
                System.out.print(numbers[j] + " ");
            }
            System.out.println();
        }
    }
}
