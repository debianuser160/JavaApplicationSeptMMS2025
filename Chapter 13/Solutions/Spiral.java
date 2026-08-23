import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spiral extends JPanel {
    private static final int POINTS = 400;
    private static final double MAX_THETA = 6 * Math.PI;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int[] xPoints = new int[POINTS];
        int[] yPoints = new int[POINTS];

        for (int i = 0; i < POINTS; i++) {
            double theta = MAX_THETA * i / (POINTS - 1);
            double radius = 5 * theta;
            xPoints[i] = centerX + (int) Math.round(radius * Math.cos(theta));
            yPoints[i] = centerY + (int) Math.round(radius * Math.sin(theta));
        }

        g.drawPolyline(xPoints, yPoints, POINTS);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.26: Drawing Spirals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Spiral());
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
