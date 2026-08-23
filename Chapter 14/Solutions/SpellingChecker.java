import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SpellingChecker {

    private static final String[] DICTIONARY_WORDS = {"the", "be", "to", "of",
        "and", "in", "that", "have", "it", "for", "not", "on", "with", "he",
        "as", "you", "do", "at", "this", "but", "his", "by", "from", "they",
        "we", "say", "her", "she", "or", "an", "will", "my", "one", "all",
        "would", "there", "their", "what", "so", "up", "out", "if", "about",
        "who", "get", "which", "go", "me", "when", "make", "can", "like",
        "time", "no", "just", "him", "know", "take", "person", "into", "year",
        "your", "good", "some", "could", "them", "see", "other", "than",
        "then", "now", "look", "only", "come", "its", "over", "think", "also",
        "back", "after", "use", "two", "how", "our", "work", "first", "well",
        "way", "even", "new", "want", "because", "any", "these", "give",
        "day", "most", "us", "handy", "default", "birthday", "computer",
        "program", "java", "string", "method", "class", "world"};
    private static final Map<Character, String> NEIGHBOR_KEYS = new HashMap<>();

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<>(Arrays.asList(DICTIONARY_WORDS));
        loadNeighborKeys();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Spell checker ready. Type a word to check it, "
                + "\":add word\" to add it to the list, or \":quit\" to exit.");

        while (true) {
            System.out.print("\nEnter a word: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }
            if (input.equals(":quit")) {
                break;
            }
            if (input.startsWith(":add ")) {
                String newWord = input.substring(5).trim();
                if (!newWord.isEmpty()) {
                    wordList.add(newWord);
                    System.out.printf("\"%s\" was added to the word list.%n", newWord);
                }
                continue;
            }

            checkWord(input, wordList);
        }
    }

    private static void checkWord(String word, Set<String> wordList) {
        if (wordList.contains(word)) {
            System.out.println("Word is spelled correctly.");
            return;
        }

        System.out.println("Word is not spelled correctly.");
        Set<String> suggestions = findSuggestions(word, wordList);

        if (suggestions.isEmpty()) {
            System.out.println("No similar words were found in the word list.");
        } else {
            for (String suggestion : suggestions) {
                System.out.printf("Did you mean \"%s\"?%n", suggestion);
            }
        }
    }

    private static Set<String> findSuggestions(String word, Set<String> wordList) {
        Set<String> suggestions = new HashSet<>();
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length - 1; i++) {
            char[] transposed = letters.clone();
            char temporary = transposed[i];
            transposed[i] = transposed[i + 1];
            transposed[i + 1] = temporary;
            addIfKnown(new String(transposed), wordList, suggestions);
        }

        StringBuilder collapsed = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            if (i == 0 || letters[i] != letters[i - 1]) {
                collapsed.append(letters[i]);
            }
        }
        if (collapsed.length() != letters.length) {
            addIfKnown(collapsed.toString(), wordList, suggestions);
        }

        for (int i = 0; i < letters.length; i++) {
            String neighbors = NEIGHBOR_KEYS.getOrDefault(letters[i], "");
            for (char neighbor : neighbors.toCharArray()) {
                char[] replaced = letters.clone();
                replaced[i] = neighbor;
                addIfKnown(new String(replaced), wordList, suggestions);
            }
        }

        return suggestions;
    }

    private static void addIfKnown(String candidate, Set<String> wordList,
            Set<String> suggestions) {
        if (wordList.contains(candidate)) {
            suggestions.add(candidate);
        }
    }

    private static void loadNeighborKeys() {
        NEIGHBOR_KEYS.put('q', "wa");
        NEIGHBOR_KEYS.put('w', "qesa");
        NEIGHBOR_KEYS.put('e', "wrds");
        NEIGHBOR_KEYS.put('r', "etdf");
        NEIGHBOR_KEYS.put('t', "ryfg");
        NEIGHBOR_KEYS.put('y', "tugh");
        NEIGHBOR_KEYS.put('u', "yihj");
        NEIGHBOR_KEYS.put('i', "uojk");
        NEIGHBOR_KEYS.put('o', "ipkl");
        NEIGHBOR_KEYS.put('p', "ol");
        NEIGHBOR_KEYS.put('a', "qszw");
        NEIGHBOR_KEYS.put('s', "awdxz");
        NEIGHBOR_KEYS.put('d', "sefcx");
        NEIGHBOR_KEYS.put('f', "drgv");
        NEIGHBOR_KEYS.put('g', "fthb");
        NEIGHBOR_KEYS.put('h', "gyjn");
        NEIGHBOR_KEYS.put('j', "hukm");
        NEIGHBOR_KEYS.put('k', "jilm");
        NEIGHBOR_KEYS.put('l', "kop");
        NEIGHBOR_KEYS.put('z', "asx");
        NEIGHBOR_KEYS.put('x', "zsdc");
        NEIGHBOR_KEYS.put('c', "xdfv");
        NEIGHBOR_KEYS.put('v', "cfgb");
        NEIGHBOR_KEYS.put('b', "vghn");
        NEIGHBOR_KEYS.put('n', "bhjm");
        NEIGHBOR_KEYS.put('m', "njk");
    }
}
