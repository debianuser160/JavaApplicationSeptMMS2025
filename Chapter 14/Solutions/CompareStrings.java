import javax.swing.JOptionPane;

public class CompareStrings {

    public static void main(String[] args) {
        String first = JOptionPane.showInputDialog("Enter the first string:");
        if (first == null) {
            System.exit(0);
        }
        String second = JOptionPane.showInputDialog("Enter the second string:");
        if (second == null) {
            System.exit(0);
        }

        int result = first.compareTo(second);

        if (result < 0) {
            JOptionPane.showMessageDialog(null, String.format(
                    "\"%s\" is less than \"%s\".", first, second));
        } else if (result == 0) {
            JOptionPane.showMessageDialog(null,
                    "The strings are equal.");
        } else {
            JOptionPane.showMessageDialog(null, String.format(
                    "\"%s\" is greater than \"%s\".", first, second));
        }
    }
}
