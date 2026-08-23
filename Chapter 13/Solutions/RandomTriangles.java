import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomTriangles extends JPanel {
    private static final int TRIANGLES = 15;
    private final Random random = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < TRIANGLES; i++) {
            GeneralPath triangle = new GeneralPath();
            triangle.moveTo(random.nextInt(width), random.nextInt(height));
            triangle.lineTo(random.nextInt(width), random.nextInt(height));
            triangle.lineTo(random.nextInt(width), random.nextInt(height));
            triangle.closePath();

            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g2d.setColor(color);
            g2d.fill(triangle);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.9: Random Triangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomTriangles());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
