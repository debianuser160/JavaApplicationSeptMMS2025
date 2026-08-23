import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cube extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        int size = Math.min(getWidth(), getHeight()) / 2;
        int frontX = (getWidth() - size) / 2 - size / 8;
        int frontY = (getHeight() + size / 4 - size) / 2;
        int offsetX = size / 4;
        int offsetY = size / 4;
        int backX = frontX + offsetX;
        int backY = frontY - offsetY;

        GeneralPath cube = new GeneralPath();

        cube.moveTo(frontX, frontY);
        cube.lineTo(frontX + size, frontY);
        cube.lineTo(frontX + size, frontY + size);
        cube.lineTo(frontX, frontY + size);
        cube.closePath();

        cube.moveTo(backX, backY);
        cube.lineTo(backX + size, backY);
        cube.lineTo(backX + size, backY + size);
        cube.lineTo(backX, backY + size);
        cube.closePath();

        cube.moveTo(frontX, frontY);
        cube.lineTo(backX, backY);
        cube.moveTo(frontX + size, frontY);
        cube.lineTo(backX + size, backY);
        cube.moveTo(frontX, frontY + size);
        cube.lineTo(backX, backY + size);
        cube.moveTo(frontX + size, frontY + size);
        cube.lineTo(backX + size, backY + size);

        g2d.draw(cube);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.16: Drawing Cubes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Cube());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
