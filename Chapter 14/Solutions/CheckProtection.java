import javax.swing.JOptionPane;

public class CheckProtection {

    public static void main(String[] args) {
        double amount = readAmount();
        if (amount >= 0) {
            System.out.println("Check-protected amount:");
            printCheckAmount(amount);
        }
    }

    public static void printCheckAmount(double amount) {
        String formatted = String.format("%,.2f", amount);

        int spacesAvailable = 9;
        if (formatted.length() < spacesAvailable) {
            formatted = "*".repeat(spacesAvailable - formatted.length()) + formatted;
        }
        System.out.println(formatted);
    }

    private static double readAmount() {
        while (true) {
            String text = JOptionPane.showInputDialog("Enter the check amount:");
            if (text == null) {
                return -1;
            }
            try {
                double value = Double.parseDouble(text.trim());
                if (value >= 0) {
                    return value;
                }
                JOptionPane.showMessageDialog(null, "The amount cannot be negative.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid dollar amount.");
            }
        }
    }
}
