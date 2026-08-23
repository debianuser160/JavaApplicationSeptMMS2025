import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLine2D extends JPanel {
    private static final int CELLS = 8;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        double spacing = Math.min(getWidth(), getHeight()) / (double) CELLS;
        double offsetX = (getWidth() - spacing * CELLS) / 2.0;
        double offsetY = (getHeight() - spacing * CELLS) / 2.0;

        for (int i = 0; i <= CELLS; i++) {
            double position = i * spacing;
            Line2D vertical = new Line2D.Double(offsetX + position, offsetY,
                    offsetX + position, offsetY + CELLS * spacing);
            Line2D horizontal = new Line2D.Double(offsetX, offsetY + position,
                    offsetX + CELLS * spacing, offsetY + position);
            g2d.draw(vertical);
            g2d.draw(horizontal);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.12: Grid Using Line2D.Double");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridLine2D());
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
