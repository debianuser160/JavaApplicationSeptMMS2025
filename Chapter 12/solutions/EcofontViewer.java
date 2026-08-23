import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EcofontViewer extends JFrame {
   private static final String FONT_NAME = "Spranq eco sans";
   private static final int MIN_SIZE = 1;
   private static final int MAX_SIZE = 120;

   private final JTextField textField = new JTextField("Ecofont sample text", 30);
   private final JLabel displayLabel = new JLabel("", SwingConstants.CENTER);
   private final JLabel sizeLabel = new JLabel();
   private int fontSize = 9;

   public EcofontViewer() {
      super("Ecofont Viewer");

      Runnable update = () -> {
         Font font = new Font(FONT_NAME, Font.PLAIN, fontSize);
         displayLabel.setText(textField.getText());
         displayLabel.setFont(font);
         sizeLabel.setText("Current font size: " + fontSize + " pt");
      };

      textField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
         @Override
         public void insertUpdate(javax.swing.event.DocumentEvent e) { update.run(); }
         @Override
         public void removeUpdate(javax.swing.event.DocumentEvent e) { update.run(); }
         @Override
         public void changedUpdate(javax.swing.event.DocumentEvent e) { update.run(); }
      });

      JButton increaseButton = new JButton("Increase Font Size");
      increaseButton.addActionListener(event -> {
         if (fontSize < MAX_SIZE) {
            fontSize++;
            update.run();
         }
      });

      JButton decreaseButton = new JButton("Decrease Font Size");
      decreaseButton.addActionListener(event -> {
         if (fontSize > MIN_SIZE) {
            fontSize--;
            update.run();
         }
      });

      JPanel controls = new JPanel(new FlowLayout());
      controls.add(textField);
      controls.add(increaseButton);
      controls.add(decreaseButton);

      setLayout(new BorderLayout());
      add(controls, BorderLayout.NORTH);
      add(displayLabel, BorderLayout.CENTER);
      add(sizeLabel, BorderLayout.SOUTH);

      update.run();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(650, 250);
      setLocationRelativeTo(null);
   }

   public static void main(String[] args) {
      EcofontViewer frame = new EcofontViewer();
      frame.setVisible(true);
   }
}
