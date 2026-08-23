import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class LargeTypeDisplay extends JFrame {
    private static final int INITIAL_FONT_SIZE = 18;
    private static final int CONTROL_FONT_SIZE = 20;

    private final JTextArea textArea = new JTextArea(15, 40);
    private final JComboBox<String> fontComboBox =
            new JComboBox<>(new String[]{"Serif", "Sans-serif", "Monospaced"});
    private final JCheckBox boldCheckBox = new JCheckBox("Bold");
    private final JButton increaseButton = new JButton("Increase Font Size");
    private final JButton decreaseButton = new JButton("Decrease Font Size");
    private int fontSize = INITIAL_FONT_SIZE;

    public LargeTypeDisplay() {
        super("Exercise 13.32: Large-Type Display for People with Low Vision");
        setLayout(new BorderLayout());

        Font controlFont = new Font(Font.SANS_SERIF, Font.PLAIN, CONTROL_FONT_SIZE);
        fontComboBox.setFont(controlFont);
        boldCheckBox.setFont(controlFont);
        increaseButton.setFont(controlFont);
        decreaseButton.setFont(controlFont);

        JPanel controls = new JPanel();
        controls.add(fontComboBox);
        controls.add(boldCheckBox);
        controls.add(increaseButton);
        controls.add(decreaseButton);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        fontComboBox.addActionListener(e -> updateFont());
        boldCheckBox.addActionListener(e -> updateFont());
        increaseButton.addActionListener(e -> {
            fontSize++;
            updateFont();
        });
        decreaseButton.addActionListener(e -> {
            if (fontSize > 1) {
                fontSize--;
            }
            updateFont();
        });

        updateFont();
    }

    private void updateFont() {
        String family = (String) fontComboBox.getSelectedItem();
        int style = boldCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
        textArea.setFont(new Font(family, style, fontSize));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LargeTypeDisplay application = new LargeTypeDisplay();
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.setSize(700, 500);
            application.setVisible(true);
        });
    }
}
