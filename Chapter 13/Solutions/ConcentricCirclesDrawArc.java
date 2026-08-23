import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConcentricCirclesDrawArc extends JPanel {
    private static final int CIRCLES = 8;
    private static final int SEPARATION = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int largestDiameter = Math.min(width, height);

        for (int i = 0; i < CIRCLES; i++) {
            int diameter = largestDiameter - i * 2 * SEPARATION;
            int x = (width - diameter) / 2;
            int y = (height - diameter) / 2;
            g.drawArc(x, y, diameter, diameter, 0, 360);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.6: Concentric Circles Using drawArc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ConcentricCirclesDrawArc());
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
