import java.util.Scanner;
import java.util.TreeSet;

public class ThreeLetterStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word;
        while (true) {
            System.out.println("Enter a five-letter word:");
            word = scanner.nextLine().trim();
            if (word.matches("[a-zA-Z]{5}")) {
                break;
            }
            System.out.println("Please enter exactly five letters.");
        }

        TreeSet<String> results = new TreeSet<>();
        generate(word.toLowerCase().toCharArray(), new boolean[word.length()],
                new StringBuilder(), results);

        System.out.printf("%d distinct three-letter strings can be formed:%n", results.size());
        int count = 0;
        for (String combination : results) {
            System.out.print(combination + " ");
            if (++count % 12 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void generate(char[] letters, boolean[] used,
            StringBuilder current, TreeSet<String> results) {
        if (current.length() == 3) {
            results.add(current.toString());
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.append(letters[i]);
            generate(letters, used, current, results);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
