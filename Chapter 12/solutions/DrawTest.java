import javax.swing.SwingUtilities;

public class DrawTest {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new DrawFrame().setVisible(true));
   }
}
