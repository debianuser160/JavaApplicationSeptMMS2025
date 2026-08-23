import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ColorSelect {
   public static void main(String[] args) {
      JFrame frame = new JFrame("ColorSelect");

      JLabel colorLabel = new JLabel("RED", SwingConstants.CENTER);

      JPanel checks = new JPanel(new FlowLayout());
      checks.add(new JCheckBox("Background"));
      checks.add(new JCheckBox("Foreground"));

      JPanel buttons = new JPanel(new FlowLayout());
      buttons.add(new JButton("Ok"));
      buttons.add(new JButton("Cancel"));

      frame.setLayout(new BorderLayout());
      frame.add(colorLabel, BorderLayout.NORTH);
      frame.add(checks, BorderLayout.CENTER);
      frame.add(buttons, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 150);
      frame.setVisible(true);
   }
}
