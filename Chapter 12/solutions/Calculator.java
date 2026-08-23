import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Calculator");
      JTextField display = new JTextField("0.");
      display.setHorizontalAlignment(JTextField.RIGHT);

      JPanel top = new JPanel(new GridLayout(1, 3, 4, 4));
      top.add(new JButton("Backspace"));
      top.add(new JButton("CE"));
      top.add(new JButton("C"));

      String[][] keys = {
         {"7", "8", "9", "/", "sqrt"},
         {"4", "5", "6", "*", "%"},
         {"1", "2", "3", "-", "1/x"},
         {"0", "+/-", ".", "+", "="}
      };
      JPanel pad = new JPanel(new GridLayout(4, 5, 4, 4));
      for (String[] row : keys)
         for (String label : row)
            pad.add(new JButton(label));

      frame.setLayout(new BorderLayout(4, 4));
      frame.add(display, BorderLayout.NORTH);
      frame.add(top, BorderLayout.CENTER);
      frame.add(pad, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
