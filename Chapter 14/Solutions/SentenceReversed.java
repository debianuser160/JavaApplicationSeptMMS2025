import javax.swing.JOptionPane;

public class SentenceReversed {

    public static void main(String[] args) {
        String line = JOptionPane.showInputDialog("Enter a line of text:");
        if (line == null) {
            System.exit(0);
        }

        String[] tokens = line.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            reversed.append(tokens[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        JOptionPane.showMessageDialog(null, reversed.toString());
    }
}
