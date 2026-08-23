import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TemperatureConversion extends JFrame {
   private final JTextField inputField = new JTextField(10);
   private final JLabel resultLabel = new JLabel("Celsius: ");

   public TemperatureConversion() {
      super("Temperature Conversion");
      setLayout(new FlowLayout());
      add(new JLabel("Fahrenheit:"));
      add(inputField);
      add(resultLabel);

      inputField.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent event) { convert(); }

         @Override
         public void removeUpdate(DocumentEvent event) { convert(); }

         @Override
         public void changedUpdate(DocumentEvent event) { convert(); }
      });

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(340, 100);
      setLocationRelativeTo(null);
   }

   private void convert() {
      try {
         double fahrenheit = Double.parseDouble(inputField.getText().trim());
         double celsius = 5.0 / 9.0 * (fahrenheit - 32);
         resultLabel.setText(String.format("Celsius: %.2f", celsius));
      }
      catch (NumberFormatException exception) {
         resultLabel.setText("Celsius: ");
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new TemperatureConversion().setVisible(true));
   }
}
