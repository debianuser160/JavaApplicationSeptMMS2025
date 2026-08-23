import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CircleInfo extends JPanel {
    private double radius;
    private double centerX;
    private double centerY;

    public void setCircle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (radius <= 0) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(centerX - radius, centerY - radius,
                2 * radius, 2 * radius);
        g2d.draw(circle);

        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        String output = String.format(
                "Radius: %.2f   Diameter: %.2f   Circumference: %.2f   Area: %.2f",
                radius, diameter, circumference, area);
        g2d.drawString(output, 10, 20);
    }

    public static void main(String[] args) {
        double radius = readPositiveDouble("Enter the radius of the circle:");
        double x = readDouble("Enter the x-coordinate of the circle's center:");
        double y = readDouble("Enter the y-coordinate of the circle's center:");

        CircleInfo panel = new CircleInfo();
        panel.setCircle(radius, x, y);

        JFrame frame = new JFrame("Exercise 13.17: Circle Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private static double readPositiveDouble(String prompt) {
        double value = -1;
        while (value <= 0) {
            String text = JOptionPane.showInputDialog(prompt);
            if (text == null) {
                System.exit(0);
            }
            try {
                value = Double.parseDouble(text.trim());
                if (value <= 0) {
                    JOptionPane.showMessageDialog(null, "The value must be greater than zero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
        return value;
    }

    private static double readDouble(String prompt) {
        while (true) {
            String text = JOptionPane.showInputDialog(prompt);
            if (text == null) {
                System.exit(0);
            }
            try {
                return Double.parseDouble(text.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
}
