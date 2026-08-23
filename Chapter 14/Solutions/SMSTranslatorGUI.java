import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SMSTranslatorGUI extends JFrame {
    private static final Map<String, String> SMS_TO_ENGLISH = new HashMap<>();
    private static final Map<String, String> ENGLISH_TO_SMS = new HashMap<>();

    private final JTextArea inputArea = new JTextArea(6, 40);
    private final JTextArea outputArea = new JTextArea(6, 40);

    public SMSTranslatorGUI() {
        super("Exercise 14.28: SMS Language");
        loadDictionary();
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton toEnglishButton = new JButton("Translate to English");
        JButton toSmsButton = new JButton("Translate to SMS Language");
        buttonPanel.add(toEnglishButton);
        buttonPanel.add(toSmsButton);

        JScrollPane inputPane = new JScrollPane(inputArea);
        inputPane.setBorder(BorderFactory.createTitledBorder("Message:"));
        outputArea.setEditable(false);
        JScrollPane outputPane = new JScrollPane(outputArea);
        outputPane.setBorder(BorderFactory.createTitledBorder("Translation:"));

        add(inputPane, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPane, BorderLayout.SOUTH);

        JLabel noteLabel = new JLabel("Note: one abbreviation can have several "
                + "meanings (e.g., IMO); the most common meaning is used.");
        add(noteLabel, BorderLayout.PAGE_END);

        toEnglishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                translate(true);
            }
        });
        toSmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                translate(false);
            }
        });
    }

    private static void addEntry(String sms, String english) {
        SMS_TO_ENGLISH.put(sms.toLowerCase(), english.toLowerCase());
        ENGLISH_TO_SMS.put(english.toLowerCase(), sms.toLowerCase());
    }

    private static void loadDictionary() {
        String[][] entries = {
            {"imo", "in my opinion"}, {"lol", "laughing out loud"},
            {"brb", "be right back"}, {"ttyl", "talk to you later"},
            {"omg", "oh my god"}, {"btw", "by the way"},
            {"idk", "i do not know"}, {"smh", "shaking my head"},
            {"tbh", "to be honest"}, {"fyi", "for your information"},
            {"asap", "as soon as possible"}, {"bff", "best friends forever"},
            {"diy", "do it yourself"}, {"eta", "estimated time of arrival"},
            {"fomo", "fear of missing out"}, {"ftw", "for the win"},
            {"g2g", "got to go"}, {"gr8", "great"}, {"ic", "i see"},
            {"jk", "just kidding"}, {"lmk", "let me know"},
            {"np", "no problem"}, {"nvm", "never mind"}, {"omw", "on my way"},
            {"pls", "please"}, {"ppl", "people"},
            {"rofl", "rolling on the floor laughing"}, {"thx", "thanks"},
            {"tmi", "too much information"}, {"u", "you"}, {"ur", "your"},
            {"yolo", "you only live once"}
        };
        for (String[] entry : entries) {
            addEntry(entry[0], entry[1]);
        }
    }

    private void translate(boolean toEnglish) {
        String text = inputArea.getText().trim();
        if (text.isEmpty()) {
            return;
        }

        if (toEnglish) {
            outputArea.setText(translateToEnglish(text));
        } else {
            outputArea.setText(translateToSms(text));
        }
    }

    private static String translateToEnglish(String text) {
        StringBuilder result = new StringBuilder();
        for (String token : text.split("(?<=\\s)|(?=\\s)")) {
            if (token.trim().isEmpty()) {
                result.append(token);
                continue;
            }
            String punctuation = "";
            String word = token;
            while (!word.isEmpty() && !Character.isLetterOrDigit(
                    word.charAt(word.length() - 1))) {
                punctuation = word.charAt(word.length() - 1) + punctuation;
                word = word.substring(0, word.length() - 1);
            }
            String replacement = SMS_TO_ENGLISH.get(word.toLowerCase());
            result.append(replacement == null ? word : replacement).append(punctuation);
        }
        return result.toString();
    }

    private static String translateToSms(String text) {
        String[] tokens = text.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < tokens.length) {
            boolean matched = false;
            for (int span = Math.min(5, tokens.length - i); span >= 1 && !matched; span--) {
                StringBuilder phrase = new StringBuilder();
                for (int k = 0; k < span; k++) {
                    phrase.append(k > 0 ? " " : "").append(tokens[i + k].toLowerCase());
                }
                String abbreviation = ENGLISH_TO_SMS.get(stripPunctuation(phrase.toString()));
                if (abbreviation != null) {
                    result.append(i > 0 ? " " : "").append(abbreviation);
                    i += span;
                    matched = true;
                }
            }
            if (!matched) {
                result.append(i > 0 ? " " : "").append(tokens[i]);
                i++;
            }
        }
        return result.toString();
    }

    private static String stripPunctuation(String word) {
        return word.replaceAll("[^\\w\\s']", "");
    }

    public static void main(String[] args) {
        SMSTranslatorGUI application = new SMSTranslatorGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
