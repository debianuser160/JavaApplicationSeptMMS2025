import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaverShapes extends JPanel implements ActionListener {
    private static final int SHAPES = 20;
    private final Random random = new Random();
    private final Timer timer;

    public ScreenSaverShapes() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < SHAPES; i++) {
            int x = random.nextInt(Math.max(1, width - 60));
            int y = random.nextInt(Math.max(1, height - 60));
            int w = 20 + random.nextInt(80);
            int h = 20 + random.nextInt(80);

            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

            switch (random.nextInt(6)) {
                case 0:
                    g.drawLine(x, y, x + w, y + h);
                    break;
                case 1:
                    g.drawRect(x, y, w, h);
                    break;
                case 2:
                    g.fillRect(x, y, w, h);
                    break;
                case 3:
                    g.drawOval(x, y, w, h);
                    break;
                case 4:
                    g.fillOval(x, y, w, h);
                    break;
                default:
                    g.draw3DRect(x, y, w, h, random.nextBoolean());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.21: Screen Saver with Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ScreenSaverShapes());
        frame.setSize(500, 450);
        frame.setVisible(true);
    }
}
