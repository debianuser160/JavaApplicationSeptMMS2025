import javax.swing.JOptionPane;

public class IntToCharacter {

    public static void main(String[] args) {
        int code = readCode();
        if (code >= 0) {
            JOptionPane.showMessageDialog(null,
                    String.format("Character code %d corresponds to '%c'", code, code));

            System.out.println("Characters for codes 000-255:");
            StringBuilder line = new StringBuilder();
            for (int i = 0; i <= 255; i++) {
                char character = Character.isISOControl(i) ? '.' : (char) i;
                line.append(String.format("%03d:%c  ", i, character));
                if ((i + 1) % 8 == 0) {
                    line.append(System.lineSeparator());
                }
            }
            System.out.println(line);
        }
    }

    private static int readCode() {
        while (true) {
            String text = JOptionPane.showInputDialog(
                    "Enter an integer code for a character (0-65535):");
            if (text == null) {
                return -1;
            }
            try {
                return Integer.parseInt(text.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
            }
        }
    }
}
