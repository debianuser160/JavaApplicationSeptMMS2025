import javax.swing.JOptionPane;

public class ComparePortions {

    public static void main(String[] args) {
        String first = JOptionPane.showInputDialog("Enter the first string:");
        if (first == null) {
            System.exit(0);
        }
        String second = JOptionPane.showInputDialog("Enter the second string:");
        if (second == null) {
            System.exit(0);
        }
        int startingIndex = readInteger("Enter the starting index of the comparison:");
        if (startingIndex < 0) {
            System.exit(0);
        }
        int numberOfCharacters = readInteger("Enter the number of characters to compare:");
        if (numberOfCharacters < 0) {
            System.exit(0);
        }

        boolean equal = first.regionMatches(true, startingIndex,
                second, startingIndex, numberOfCharacters);

        String message = equal
                ? "The portions of the strings are equal (ignoring case)."
                : "The portions of the strings are not equal.";
        JOptionPane.showMessageDialog(null, message);
    }

    private static int readInteger(String prompt) {
        while (true) {
            String text = JOptionPane.showInputDialog(prompt);
            if (text == null) {
                return -1;
            }
            try {
                int value = Integer.parseInt(text.trim());
                if (value >= 0) {
                    return value;
                }
                JOptionPane.showMessageDialog(null, "Please enter a non-negative integer.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
            }
        }
    }
}
