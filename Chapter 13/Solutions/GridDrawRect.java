import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridDrawRect extends JPanel {
    private static final int CELLS = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int spacing = Math.min(getWidth(), getHeight()) / CELLS;
        int offsetX = (getWidth() - spacing * CELLS) / 2;
        int offsetY = (getHeight() - spacing * CELLS) / 2;

        for (int row = 0; row < CELLS; row++) {
            for (int column = 0; column < CELLS; column++) {
                g2d.drawRect(offsetX + column * spacing, offsetY + row * spacing, spacing, spacing);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.13: Grid Using drawRect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridDrawRect());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
