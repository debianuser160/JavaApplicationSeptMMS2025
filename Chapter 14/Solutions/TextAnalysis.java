import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String text = scanner.nextLine();

        analyzeLetters(text);
        System.out.println();
        analyzeWordLengths(text);
        System.out.println();
        analyzeWordCounts(text);
    }

    private static void analyzeLetters(String text) {
        int[] counts = new int[26];
        for (char character : text.toLowerCase().toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                counts[character - 'a']++;
            }
        }

        System.out.println("a) Letter occurrences:");
        System.out.printf("%-8s%s%n", "Letter", "Count");
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.printf("%-8c%d%n", (char) ('a' + i), counts[i]);
            }
        }
    }

    private static void analyzeWordLengths(String text) {
        String[] words = tokenize(text);
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        int[] lengthCounts = new int[maxLength + 1];
        for (String word : words) {
            lengthCounts[word.length()]++;
        }

        System.out.println("b) Word-length counts:");
        System.out.printf("%-12s%s%n", "Word length", "Occurrences");
        for (int length = 1; length <= maxLength; length++) {
            System.out.printf("%-12d%d%n", length, lengthCounts[length]);
        }
    }

    private static void analyzeWordCounts(String text) {
        Map<String, Integer> wordCounts = new LinkedHashMap<>();
        for (String word : tokenize(text)) {
            Integer count = wordCounts.get(word);
            wordCounts.put(word, count == null ? 1 : count + 1);
        }

        System.out.println("c) Word counts (in order of appearance):");
        System.out.printf("%-16s%s%n", "Word", "Count");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.printf("%-16s%d%n", entry.getKey(), entry.getValue());
        }
    }

    private static String[] tokenize(String text) {
        String[] rawTokens = text.trim().split("\\s+");
        java.util.List<String> words = new java.util.ArrayList<>();
        for (String token : rawTokens) {
            String cleaned = token.replaceAll("^[^\\w']+|[^\\w']+$", "");
            if (!cleaned.isEmpty()) {
                words.add(cleaned.toLowerCase());
            }
        }
        return words.toArray(new String[0]);
    }
}
