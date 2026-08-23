import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectShapesColorChooser extends JFrame {
    private static final String[] SHAPE_NAMES = {"Line", "Rectangle", "Oval"};
    private final JComboBox<String> shapeComboBox = new JComboBox<>(SHAPE_NAMES);
    private final JButton colorButton = new JButton("Choose Color");
    private final ShapePanel shapePanel = new ShapePanel();

    public SelectShapesColorChooser() {
        super("Exercise 13.30: JColorChooser Dialog");
        setLayout(new BorderLayout());

        JPanel controls = new JPanel();
        controls.add(shapeComboBox);
        controls.add(colorButton);

        add(controls, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);

        shapeComboBox.addActionListener(e -> shapePanel.setShape(shapeComboBox.getSelectedIndex()));
        colorButton.addActionListener(e -> {
            Color selected = JColorChooser.showDialog(
                    SelectShapesColorChooser.this, "Choose a color", shapePanel.getColor());
            if (selected != null) {
                shapePanel.setColor(selected);
            }
        });
    }

    private class ShapePanel extends JPanel {
        private final java.util.Random random = new java.util.Random();
        private Color color = Color.BLACK;
        private int shapeType;

        void setShape(int shapeType) {
            this.shapeType = shapeType;
            repaint();
        }

        void setColor(Color color) {
            this.color = color;
            repaint();
        }

        Color getColor() {
            return color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
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
        SelectShapesColorChooser application = new SelectShapesColorChooser();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500, 450);
        application.setVisible(true);
    }
}
