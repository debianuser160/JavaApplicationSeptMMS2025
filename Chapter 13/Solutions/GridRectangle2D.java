import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridRectangle2D extends JPanel {
    private static final int CELLS = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        double spacing = Math.min(getWidth(), getHeight()) / (double) CELLS;
        double offsetX = (getWidth() - spacing * CELLS) / 2.0;
        double offsetY = (getHeight() - spacing * CELLS) / 2.0;

        for (int row = 0; row < CELLS; row++) {
            for (int column = 0; column < CELLS; column++) {
                g2d.draw(new Rectangle2D.Double(offsetX + column * spacing,
                        offsetY + row * spacing, spacing, spacing));
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.14: Grid Using Rectangle2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridRectangle2D());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
