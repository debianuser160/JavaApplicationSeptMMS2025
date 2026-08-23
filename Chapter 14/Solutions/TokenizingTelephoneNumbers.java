import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TokenizingTelephoneNumbers {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(
                "Enter a telephone number in the form (555) 555-5555:");
        if (input == null) {
            System.exit(0);
        }

        List<String> tokens = new ArrayList<>();
        for (String token : input.trim().split("[^0-9]+")) {
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }

        if (tokens.size() != 3
                || tokens.get(0).length() != 3
                || tokens.get(1).length() != 3
                || tokens.get(2).length() != 4) {
            JOptionPane.showMessageDialog(null,
                    "Invalid telephone number. Please use the form (555) 555-5555.");
            return;
        }

        String areaCode = tokens.get(0);
        String firstThreeDigits = tokens.get(1);
        String lastFourDigits = tokens.get(2);
        String phoneNumber = firstThreeDigits + lastFourDigits;

        JOptionPane.showMessageDialog(null,
                String.format("Area code: %s%nPhone number: %s", areaCode, phoneNumber));
    }
}
