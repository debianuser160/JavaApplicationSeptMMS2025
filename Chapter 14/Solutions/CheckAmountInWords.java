import javax.swing.JOptionPane;

public class CheckAmountInWords {

    private static final String[] ONES = {"", "ONE", "TWO", "THREE", "FOUR",
        "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    private static final String[] TEENS = {"TEN", "ELEVEN", "TWELVE",
        "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN",
        "EIGHTEEN", "NINETEEN"};
    private static final String[] TENS = {"", "", "TWENTY", "THIRTY", "FORTY",
        "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

    public static void main(String[] args) {
        double amount = readAmount();
        if (amount >= 0) {
            JOptionPane.showMessageDialog(null, toWords(amount));
        }
    }

    public static String toWords(double amount) {
        int dollars = (int) amount;
        int cents = (int) Math.round((amount - dollars) * 100);
        if (cents == 100) {
            dollars++;
            cents = 0;
        }

        String dollarWords = dollars == 0 ? "ZERO" : convertThreeDigits(dollars);
        return String.format("%s and %02d/100", dollarWords, cents);
    }

    private static String convertThreeDigits(int number) {
        StringBuilder words = new StringBuilder();

        if (number >= 100) {
            words.append(ONES[number / 100]).append(" hundred");
            number %= 100;
            if (number > 0) {
                words.append(" ");
            }
        }
        if (number >= 20) {
            words.append(TENS[number / 10]);
            if (number % 10 > 0) {
                words.append("-").append(ONES[number % 10]);
            }
        } else if (number >= 10) {
            words.append(TEENS[number - 10]);
        } else if (number > 0) {
            words.append(ONES[number]);
        }
        return words.toString();
    }

    private static double readAmount() {
        while (true) {
            String text = JOptionPane.showInputDialog(
                    "Enter a check amount less than $1000 (e.g., 112.43):");
            if (text == null) {
                return -1;
            }
            try {
                double value = Double.parseDouble(text.trim());
                if (value >= 0 && value < 1000) {
                    return value;
                }
                JOptionPane.showMessageDialog(null,
                        "The amount must be between 0 and 999.99.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid dollar amount.");
            }
        }
    }
}
