import java.security.SecureRandom;

public class DiceRolling {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] sums = new int[13];

        for (int roll = 1; roll <= 36000000; roll++) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;
            sums[sum]++;
        }

        System.out.println("Sum\tFrequency");
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "\t" + sums[i]);
        }
    }
}
