import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HealthyCookingGUI extends JFrame {
    private static final String WARNING =
            "WARNING: Always consult your physician before making significant "
            + "changes to your diet.";

    private static final String[][] SUBSTITUTIONS = {
        {"sour cream", "1 cup sour cream -> 1 cup yogurt", "ALL"},
        {"milk", "1 cup milk -> 1 cup soy milk, or 1/2 cup evaporated milk"
                + " + 1/2 cup water", "CHOLESTEROL"},
        {"butter", "1 cup butter -> 1 cup margarine or 1 cup yogurt", "ALL"},
        {"cream cheese", "1 cup cream cheese -> 1 cup low-fat cottage cheese",
                "CHOLESTEROL"},
        {"mayonnaise", "1 cup mayonnaise -> 1 cup cottage cheese, or 1/8 cup"
                + " mayonnaise + 7/8 cup yogurt", "CHOLESTEROL|WEIGHT"},
        {"sugar", "1 cup sugar -> 1/2 cup honey, or 1 cup molasses, or 1/4"
                + " cup agave nectar", "WEIGHT"},
        {"oil", "1/4 cup oil -> 1/4 cup applesauce", "WEIGHT"},
        {"flour", "1 cup wheat flour -> 1 cup rye flour or rice flour (gluten-free)",
                "GLUTEN"},
        {"bread", "white bread -> whole-grain bread", "ALL|WEIGHT"},
        {"egg", "eggs -> egg whites (2 per whole egg), cornstarch, arrowroot,"
                + " potato starch, or mashed banana", "CHOLESTEROL"},
        {"cheese", "regular cheese -> low-fat or part-skim cheese", "CHOLESTEROL|WEIGHT"},
        {"salt", "salt -> herbs, spices, or salt-free seasoning blends",
                "BLOOD PRESSURE"}
    };
    private static final Pattern EGG_PATTERN =
            Pattern.compile("(\\d+)\\s+eggs?\\b", Pattern.CASE_INSENSITIVE);

    private final JTextArea recipeArea = new JTextArea(10, 40);
    private final JTextArea outputArea = new JTextArea(10, 40);
    private final JComboBox<String> concernComboBox = new JComboBox<>(new String[]{
        "None", "High cholesterol", "High blood pressure", "Weight loss",
        "Gluten allergy"});

    public HealthyCookingGUI() {
        super("Exercise 14.26: Cooking with Healthier Ingredients");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Health concern:"));
        topPanel.add(concernComboBox);
        JButton analyzeButton = new JButton("Suggest Substitutions");
        topPanel.add(analyzeButton);

        JScrollPane inputPane = new JScrollPane(recipeArea);
        inputPane.setBorder(BorderFactory.createTitledBorder(
                "Enter your recipe (one ingredient per line):"));
        JScrollPane outputPane = new JScrollPane(outputArea);
        outputPane.setBorder(BorderFactory.createTitledBorder("Suggestions:"));
        outputArea.setEditable(false);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.add(inputPane);
        centerPanel.add(outputPane);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                analyzeRecipe();
            }
        });
    }

    private void analyzeRecipe() {
        String concern = String.valueOf(concernComboBox.getSelectedItem());
        StringBuilder report = new StringBuilder();

        for (String line : recipeArea.getText().split("\\n")) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String lowerLine = line.toLowerCase();

            for (String[] substitution : SUBSTITUTIONS) {
                if (!lowerLine.contains(substitution[0])) {
                    continue;
                }
                if (!tagMatches(concern, substitution[2])) {
                    continue;
                }
                String suggestion = substitution[1];
                Matcher matcher = EGG_PATTERN.matcher(lowerLine);
                while (matcher.find()) {
                    int quantity = Integer.parseInt(matcher.group(1));
                    suggestion += String.format("%n   For %d eggs: use %d egg"
                            + " whites, %d tablespoons cornstarch, or %d mashed bananas.",
                            quantity, quantity * 2, quantity * 2, Math.max(1, quantity / 2));
                    break;
                }
                report.append(String.format("- %s%n   %s%n", line.trim(), suggestion));
            }
        }

        if (report.length() == 0) {
            report.append("No substitutions suggested for this recipe.\n");
        }
        report.append("\n").append(WARNING);
        outputArea.setText(report.toString());
    }

    private boolean tagMatches(String concern, String tags) {
        for (String tag : tags.split("\\|")) {
            if (tag.equals("ALL")) {
                return true;
            }
            switch (concern) {
                case "High cholesterol":
                    if (tag.equals("CHOLESTEROL")) {
                        return true;
                    }
                    break;
                case "High blood pressure":
                    if (tag.equals("BLOOD PRESSURE")) {
                        return true;
                    }
                    break;
                case "Weight loss":
                    if (tag.equals("WEIGHT")) {
                        return true;
                    }
                    break;
                case "Gluten allergy":
                    if (tag.equals("GLUTEN")) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HealthyCookingGUI application = new HealthyCookingGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
