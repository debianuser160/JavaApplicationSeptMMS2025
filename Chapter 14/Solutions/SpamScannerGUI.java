import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SpamScannerGUI extends JFrame {
    private static final String[] SPAM_TERMS = {"free money", "act now",
        "limited time", "click here", "winner", "congratulations",
        "risk-free", "cash bonus", "no cost", "guarantee", "make money",
        "double your income", "credit card", "urgent", "million dollars",
        "work from home", "be your own boss", "lose weight fast", "viagra",
        "online pharmacy", "lowest price", "best price", "discount", "call now",
        "exclusive deal", "100% satisfied", "no credit check", "pre-approved",
        "this isn't spam", "dear friend"};

    private final JTextArea messageArea = new JTextArea(12, 45);
    private final JTextArea reportArea = new JTextArea(10, 45);

    public SpamScannerGUI() {
        super("Exercise 14.27: Spam Scanner");
        setLayout(new BorderLayout());

        JButton scanButton = new JButton("Scan Message");
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(scanButton, BorderLayout.EAST);

        JScrollPane messagePane = new JScrollPane(messageArea);
        messagePane.setBorder(BorderFactory.createTitledBorder(
                "Enter the e-mail message:"));
        reportArea.setEditable(false);
        JScrollPane reportPane = new JScrollPane(reportArea);
        reportPane.setBorder(BorderFactory.createTitledBorder("Spam report:"));

        add(topPanel, BorderLayout.NORTH);
        add(messagePane, BorderLayout.CENTER);
        add(reportPane, BorderLayout.SOUTH);

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                scanMessage();
            }
        });
    }

    private void scanMessage() {
        String content = messageArea.getText().toLowerCase();
        int score = 0;
        StringBuilder hits = new StringBuilder();

        for (String term : SPAM_TERMS) {
            int occurrences = countOccurrences(content, term.toLowerCase());
            if (occurrences == 0) {
                continue;
            }
            int points = occurrences * (term.contains(" ") ? 2 : 1);
            score += points;
            hits.append(String.format("\"%s\" occurred %d time(s): +%d points%n",
                    term, occurrences, points));
        }

        String rating;
        if (score == 0) {
            rating = "Not spam";
        } else if (score <= 4) {
            rating = "Low likelihood of spam";
        } else if (score <= 9) {
            rating = "Moderate likelihood of spam";
        } else if (score <= 19) {
            rating = "High likelihood of spam";
        } else {
            rating = "Almost certainly spam";
        }

        reportArea.setText(hits
                + String.format("%nSpam score: %d%nRating: %s%n", score, rating));
    }

    private static int countOccurrences(String text, String term) {
        int count = 0;
        int index = text.indexOf(term);
        while (index != -1) {
            count++;
            index = text.indexOf(term, index + term.length());
        }
        return count;
    }

    public static void main(String[] args) {
        SpamScannerGUI application = new SpamScannerGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
