import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetrahedron extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        int width = getWidth();
        int height = getHeight();
        int apexX = width / 2;
        int apexY = height / 5;
        int leftX = width / 6;
        int leftY = height * 4 / 5;
        int rightX = width * 5 / 6;
        int rightY = height * 4 / 5;
        int backX = width / 2;
        int backY = height * 3 / 5;

        GeneralPath frontFace = new GeneralPath();
        frontFace.moveTo(apexX, apexY);
        frontFace.lineTo(leftX, leftY);
        frontFace.lineTo(rightX, rightY);
        frontFace.closePath();

        GeneralPath leftFace = new GeneralPath();
        leftFace.moveTo(apexX, apexY);
        leftFace.lineTo(backX, backY);
        leftFace.lineTo(leftX, leftY);
        leftFace.closePath();

        GeneralPath backFace = new GeneralPath();
        backFace.moveTo(apexX, apexY);
        backFace.lineTo(rightX, rightY);
        backFace.lineTo(backX, backY);
        backFace.closePath();

        g2d.draw(frontFace);
        g2d.draw(leftFace);
        g2d.draw(backFace);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 13.15: Drawing Tetrahedrons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Tetrahedron());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
