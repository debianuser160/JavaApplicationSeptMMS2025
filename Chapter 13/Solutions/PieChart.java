import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class PieChart extends JPanel {
    private static final Color[] SLICE_COLORS =
            {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
    private final double[] values;
    private final String[] labels = {"Value 1", "Value 2", "Value 3", "Value 4"};

    public PieChart(double[] values) {
        this.values = values.clone();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        double total = 0;
        for (double value : values) {
            total += value;
        }

        int size = Math.max(50, Math.min(getWidth(), getHeight()) - 60);
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2 + 20;

        double startAngle = 0;
        for (int i = 0; i < values.length; i++) {
            double extentAngle = total == 0 ? 0 : 360.0 * values[i] / total;
            Arc2D slice = new Arc2D.Double(x, y, size, size,
                    startAngle, extentAngle, Arc2D.PIE);
            g2d.setColor(SLICE_COLORS[i % SLICE_COLORS.length]);
            g2d.fill(slice);
            startAngle += extentAngle;
        }

        g2d.setColor(Color.BLACK);
        for (int i = 0; i < values.length; i++) {
            double percent = total == 0 ? 0 : 100.0 * values[i] / total;
            g2d.setColor(SLICE_COLORS[i % SLICE_COLORS.length]);
            g2d.fillRect(10, 10 + i * 16, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.format("%s: %.1f (%.1f%%)", labels[i], values[i], percent), 26, 19 + i * 16);
        }
    }

    public static void main(String[] args) {
        double[] values = new double[4];
        for (int i = 0; i < values.length; i++) {
            values[i] = readPositiveDouble(String.format(
                    "Enter value %d of 4 for the pie chart:", i + 1));
        }

        PieChart panel = new PieChart(values);
        JFrame frame = new JFrame("Exercise 13.27: Pie Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(450, 450);
        frame.setVisible(true);
    }

    private static double readPositiveDouble(String prompt) {
        while (true) {
            String text = JOptionPane.showInputDialog(prompt);
            if (text == null) {
                System.exit(0);
            }
            try {
                double value = Double.parseDouble(text.trim());
                if (value > 0) {
                    return value;
                }
                JOptionPane.showMessageDialog(null, "The value must be greater than zero.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
}
