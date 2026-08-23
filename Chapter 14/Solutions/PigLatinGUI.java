import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PigLatinGUI extends JFrame {
    private final JTextField sentenceField = new JTextField(30);
    private final JTextArea displayArea = new JTextArea(15, 40);

    public PigLatinGUI() {
        super("Exercise 14.7: Pig Latin");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(sentenceField, BorderLayout.CENTER);
        JButton translateButton = new JButton("Translate to Pig Latin");
        topPanel.add(translateButton, BorderLayout.EAST);

        displayArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                translateSentence();
            }
        });
    }

    private void translateSentence() {
        String sentence = sentenceField.getText().trim();
        if (sentence.isEmpty()) {
            return;
        }

        String[] words = sentence.split("\\s+");
        for (String word : words) {
            printLatinWord(word);
        }
        displayArea.append(String.format("%n"));

        sentenceField.setText("");
        sentenceField.requestFocusInWindow();
    }

    private void printLatinWord(String word) {
        if (word.length() >= 2) {
            displayArea.append(word.substring(1) + word.charAt(0) + "ay ");
        } else {
            displayArea.append(word + "ay ");
        }
    }

    public static void main(String[] args) {
        PigLatinGUI application = new PigLatinGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
