import java.util.Scanner;

public class CountLetterOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String text = scanner.nextLine().toLowerCase();

        int[] counts = new int[26];

        for (char letter = 'a'; letter <= 'z'; letter++) {
            int index = text.indexOf(letter);
            while (index != -1) {
                counts[letter - 'a']++;
                index = text.indexOf(letter, index + 1);
            }
        }

        System.out.println("Letter occurrences:");
        System.out.printf("%-8s%s%n", "Letter", "Count");
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.printf("%-8c%d%n", (char) ('a' + i), counts[i]);
            }
        }
    }
}
