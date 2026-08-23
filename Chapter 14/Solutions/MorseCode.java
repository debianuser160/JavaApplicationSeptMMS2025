import javax.swing.JOptionPane;

public class MorseCode {

    private static final char[] CHARACTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
        'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
        'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '.', ',', ':', ';', '?'};
    private static final String[] CODES = {".-", "-...", "-.-.", "-..", ".",
        "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
        ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....",
        "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "---...",
        "-.-.-.", "..--.."};

    public static void main(String[] args) {
        String[] options = {"Encode English to Morse", "Decode Morse to English"};
        int choice = JOptionPane.showOptionDialog(null,
                "What would you like to do?", "Exercise 14.22: Morse Code",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            String phrase = JOptionPane.showInputDialog("Enter an English-language phrase:");
            if (phrase == null) {
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, encode(phrase));
        } else if (choice == 1) {
            String phrase = JOptionPane.showInputDialog(
                    "Enter a Morse-code phrase (one blank between letters,"
                    + " three blanks between words):");
            if (phrase == null) {
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, decode(phrase));
        }
    }

    public static String encode(String phrase) {
        StringBuilder encoded = new StringBuilder();
        String[] words = phrase.trim().toUpperCase().split("\\s+");

        for (String currentWord : words) {
            StringBuilder codedWord = new StringBuilder();
            for (char character : currentWord.toCharArray()) {
                String code = codeFor(character);
                if (!code.isEmpty()) {
                    if (codedWord.length() > 0) {
                        codedWord.append(" ");
                    }
                    codedWord.append(code);
                }
            }
            if (codedWord.length() > 0) {
                if (encoded.length() > 0) {
                    encoded.append("   ");
                }
                encoded.append(codedWord);
            }
        }
        return encoded.toString();
    }

    public static String decode(String morsePhrase) {
        StringBuilder decoded = new StringBuilder();
        String[] words = morsePhrase.trim().split("\\s{3,}");

        for (int w = 0; w < words.length; w++) {
            for (String code : words[w].trim().split("\\s+")) {
                Character character = characterFor(code);
                decoded.append(character == null ? "?" : character.charValue());
            }
            if (w < words.length - 1) {
                decoded.append(" ");
            }
        }
        return decoded.toString();
    }

    private static String codeFor(char character) {
        for (int i = 0; i < CHARACTERS.length; i++) {
            if (CHARACTERS[i] == character) {
                return CODES[i];
            }
        }
        return "";
    }

    private static Character characterFor(String code) {
        for (int i = 0; i < CODES.length; i++) {
            if (CODES[i].equals(code)) {
                return CHARACTERS[i];
            }
        }
        return null;
    }
}
