import javax.swing.JOptionPane;

public class UpperLowercase {

    public static void main(String[] args) {
        String line = JOptionPane.showInputDialog("Enter a line of text:");
        if (line == null) {
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null,
                "Uppercase: " + line.toUpperCase() + "\nLowercase: " + line.toLowerCase());
    }
}
