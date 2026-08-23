import javax.swing.SwingUtilities;

public class DrawingAppJava2D {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawFrame().setVisible(true));
    }
}
