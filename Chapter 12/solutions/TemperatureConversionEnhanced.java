import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TemperatureConversionEnhanced extends JFrame {
   private static final String[] SCALES = {"Fahrenheit", "Celsius", "Kelvin"};

   private final JTextField inputField = new JTextField(10);
   private final JComboBox<String> fromCombo = new JComboBox<>(SCALES);
   private final JComboBox<String> toCombo = new JComboBox<>(SCALES);
   private final JLabel resultLabel = new JLabel("Result: ");

   public TemperatureConversionEnhanced() {
      super("Temperature Conversion");
      setLayout(new FlowLayout());

      add(new JLabel("Value:"));
      add(inputField);
      add(new JLabel("From:"));
      add(fromCombo);
      add(new JLabel("To:"));
      add(toCombo);
      add(resultLabel);

      toCombo.setSelectedIndex(1);

      inputField.getDocument().addDocumentListener(new UpdateListener());
      fromCombo.addActionListener(event -> convert());
      toCombo.addActionListener(event -> convert());

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(520, 120);
      setLocationRelativeTo(null);
   }

   private class UpdateListener implements DocumentListener {
      @Override
      public void insertUpdate(DocumentEvent event) { convert(); }

      @Override
      public void removeUpdate(DocumentEvent event) { convert(); }

      @Override
      public void changedUpdate(DocumentEvent event) { convert(); }
   }

   private void convert() {
      try {
         double value = Double.parseDouble(inputField.getText().trim());
         String from = (String) fromCombo.getSelectedItem();
         String to = (String) toCombo.getSelectedItem();

         double celsius;
         switch (from) {
            case "Fahrenheit": celsius = 5.0 / 9.0 * (value - 32); break;
            case "Kelvin":     celsius = value - 273.15;           break;
            default:           celsius = value;                    break;
         }

         double result;
         switch (to) {
            case "Fahrenheit": result = 9.0 / 5.0 * celsius + 32; break;
            case "Kelvin":     result = celsius + 273.15;          break;
            default:           result = celsius;                   break;
         }

         resultLabel.setText(String.format("Result: %.2f %s", result, to));
      }
      catch (NumberFormatException exception) {
         resultLabel.setText("Result: ");
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new TemperatureConversionEnhanced().setVisible(true));
   }
}
