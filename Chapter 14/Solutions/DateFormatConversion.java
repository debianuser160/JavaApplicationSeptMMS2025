import javax.swing.JOptionPane;

public class DateFormatConversion {

    private static final String[] MONTH_NAMES = {"January", "February", "March",
        "April", "May", "June", "July", "August", "September", "October",
        "November", "December"};

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(
                "Enter a date in the format MM/DD/YYYY (e.g., 04/25/1955):");
        if (input == null) {
            System.exit(0);
        }

        String[] parts = input.trim().split("/");
        if (parts.length != 3) {
            JOptionPane.showMessageDialog(null,
                    "Invalid date. Please use the format MM/DD/YYYY.");
            return;
        }

        try {
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(null,
                        "Invalid date: the month must be between 01 and 12.");
                return;
            }

            String converted = String.format("%s %d, %d", MONTH_NAMES[month - 1], day, year);
            JOptionPane.showMessageDialog(null, converted);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid date. Please use numeric values.");
        }
    }
}
