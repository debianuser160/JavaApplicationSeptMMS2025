import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomLinesLine2D extends JPanel {
    private static final int LINES = 20;
    private final Random random = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < LINES; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            float thickness = 1.0f + random.nextFloat() * 9.0f;

            Line2D line = new Line2D.Double(random.nextInt(width), random.nextInt(height),
                    random.nextInt(width), random.nextInt(height));

            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(line);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.8: Random Lines Using Line2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomLinesLine2D());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
