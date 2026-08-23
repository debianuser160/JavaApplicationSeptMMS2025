import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Align {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Align");
      frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

      JPanel checks = new JPanel(new GridLayout(2, 1, 5, 5));
      checks.add(new JCheckBox("Snap to Grid"));
      checks.add(new JCheckBox("Show Grid"));

      JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 5));
      buttons.add(new JButton("OK"));
      buttons.add(new JButton("Cancel"));
      buttons.add(new JButton("Help"));

      frame.add(checks);
      frame.add(buttons);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
