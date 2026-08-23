import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridDrawLine extends JPanel {
    private static final int CELLS = 8;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int spacing = Math.min(getWidth(), getHeight()) / CELLS;
        int offsetX = (getWidth() - spacing * CELLS) / 2;
        int offsetY = (getHeight() - spacing * CELLS) / 2;

        for (int i = 0; i <= CELLS; i++) {
            g.drawLine(offsetX + i * spacing, offsetY, offsetX + i * spacing, offsetY + CELLS * spacing);
            g.drawLine(offsetX, offsetY + i * spacing, offsetX + CELLS * spacing, offsetY + i * spacing);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.11: Grid Using drawLine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridDrawLine());
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
