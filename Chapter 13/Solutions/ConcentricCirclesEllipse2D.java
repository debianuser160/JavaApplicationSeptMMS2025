import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConcentricCirclesEllipse2D extends JPanel {
    private static final int CIRCLES = 8;
    private static final int SEPARATION = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int width = getWidth();
        int height = getHeight();
        int largestDiameter = Math.min(width, height);

        for (int i = 0; i < CIRCLES; i++) {
            int diameter = largestDiameter - i * 2 * SEPARATION;
            double x = (width - diameter) / 2.0;
            double y = (height - diameter) / 2.0;
            g2d.draw(new Ellipse2D.Double(x, y, diameter, diameter));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.7: Concentric Circles Using Ellipse2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ConcentricCirclesEllipse2D());
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
