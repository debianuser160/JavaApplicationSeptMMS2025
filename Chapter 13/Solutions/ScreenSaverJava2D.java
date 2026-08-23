import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaverJava2D extends JPanel implements ActionListener {
    private static final int SHAPES = 20;
    private final Random random = new Random();
    private final Timer timer;

    public ScreenSaverJava2D() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    private Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < SHAPES; i++) {
            int x = random.nextInt(Math.max(1, width - 60));
            int y = random.nextInt(Math.max(1, height - 60));
            int w = 20 + random.nextInt(80);
            int h = 20 + random.nextInt(80);

            g2d.setPaint(new GradientPaint(x, y, randomColor(), x + w, y + h, randomColor(), true));
            g2d.setStroke(new BasicStroke(1.0f + random.nextFloat() * 8.0f));

            if (random.nextBoolean()) {
                g2d.fill(new java.awt.geom.Rectangle2D.Double(x, y, w, h));
            } else {
                g2d.fill(new java.awt.geom.Ellipse2D.Double(x, y, w, h));
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.22: Screen Saver Using the Java 2D API");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ScreenSaverJava2D());
        frame.setSize(500, 450);
        frame.setVisible(true);
    }
}
