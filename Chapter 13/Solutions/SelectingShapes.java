import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectingShapes extends JFrame {
    private static final String[] SHAPE_NAMES = {"Line", "Rectangle", "Oval"};
    private final JComboBox<String> shapeComboBox = new JComboBox<>(SHAPE_NAMES);
    private final ShapePanel shapePanel = new ShapePanel();

    public SelectingShapes() {
        super("Exercise 13.28: Selecting Shapes");
        setLayout(new BorderLayout());
        add(shapeComboBox, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);
        shapeComboBox.addActionListener(e -> shapePanel.setShape(shapeComboBox.getSelectedIndex()));
    }

    private class ShapePanel extends JPanel {
        private final Random random = new Random();
        private int shapeType;

        void setShape(int shapeType) {
            this.shapeType = shapeType;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < 20; i++) {
                int x1 = random.nextInt(Math.max(1, width));
                int y1 = random.nextInt(Math.max(1, height));
                int x2 = random.nextInt(Math.max(1, width));
                int y2 = random.nextInt(Math.max(1, height));

                switch (shapeType) {
                    case 1:
                        g.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                                Math.abs(x2 - x1), Math.abs(y2 - y1));
                        break;
                    case 2:
                        g.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                                Math.abs(x2 - x1), Math.abs(y2 - y1));
                        break;
                    default:
                        g.drawLine(x1, y1, x2, y2);
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SelectingShapes application = new SelectingShapes();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500, 450);
        application.setVisible(true);
    }
}
