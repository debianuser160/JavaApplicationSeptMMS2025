import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TurtleGraphicsGUI extends JFrame {
    private static final int CELL_SIZE = 10;
    private static final int COLUMNS = 50;
    private static final int ROWS = 40;

    private final SketchPanel sketchPanel = new SketchPanel();
    private final JTextField stepsField = new JTextField("5", 4);
    private final JLabel statusLabel = new JLabel();

    private boolean penDown = true;
    private int direction = 1;
    private int column;
    private int row;

    public TurtleGraphicsGUI() {
        super("Exercise 13.23: Turtle Graphics");
        setLayout(new BorderLayout());

        JButton penUpButton = new JButton("Pen Up");
        JButton penDownButton = new JButton("Pen Down");
        JButton turnRightButton = new JButton("Turn Right");
        JButton turnLeftButton = new JButton("Turn Left");
        JButton moveButton = new JButton("Move Forward");
        JButton resetButton = new JButton("Reset");

        JPanel controls = new JPanel(new FlowLayout());
        controls.add(penUpButton);
        controls.add(penDownButton);
        controls.add(turnRightButton);
        controls.add(turnLeftButton);
        controls.add(moveButton);
        controls.add(new JLabel("Positions:"));
        controls.add(stepsField);
        controls.add(resetButton);

        add(sketchPanel, BorderLayout.CENTER);
        add(controls, BorderLayout.NORTH);
        add(statusLabel, BorderLayout.SOUTH);

        penUpButton.addActionListener(e -> setPen(false));
        penDownButton.addActionListener(e -> setPen(true));
        turnRightButton.addActionListener(e -> turnRight());
        turnLeftButton.addActionListener(e -> turnLeft());
        moveButton.addActionListener(e -> moveForward(parseSteps()));
        resetButton.addActionListener(e -> reset());

        updateStatus();
    }

    private int parseSteps() {
        try {
            return Integer.parseInt(stepsField.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void setPen(boolean down) {
        penDown = down;
        updateStatus();
    }

    private void turnRight() {
        direction = (direction + 1) % 4;
        updateStatus();
    }

    private void turnLeft() {
        direction = (direction + 3) % 4;
        updateStatus();
    }

    private void moveForward(int positions) {
        if (positions <= 0) {
            return;
        }

        int deltaColumn = 0;
        int deltaRow = 0;
        switch (direction) {
            case 0:
                deltaRow = -1;
                break;
            case 1:
                deltaColumn = 1;
                break;
            case 2:
                deltaRow = 1;
                break;
            default:
                deltaColumn = -1;
                break;
        }

        int targetColumn = Math.max(0, Math.min(COLUMNS - 1, column + deltaColumn * positions));
        int targetRow = Math.max(0, Math.min(ROWS - 1, row + deltaRow * positions));

        if (penDown && (targetColumn != column || targetRow != row)) {
            sketchPanel.addLine(column * CELL_SIZE + CELL_SIZE / 2, row * CELL_SIZE + CELL_SIZE / 2,
                    targetColumn * CELL_SIZE + CELL_SIZE / 2, targetRow * CELL_SIZE + CELL_SIZE / 2);
        }

        column = targetColumn;
        row = targetRow;
        updateStatus();
    }

    private void reset() {
        column = 0;
        row = 0;
        direction = 1;
        penDown = true;
        sketchPanel.clear();
        updateStatus();
    }

    private void updateStatus() {
        String[] directions = {"Up", "Right", "Down", "Left"};
        statusLabel.setText(String.format("Pen: %s   Facing: %s   Position: (%d, %d)",
                penDown ? "Down" : "Up", directions[direction], column, row));
    }

    private class SketchPanel extends JPanel {
        private final List<Line2D> lines = new ArrayList<>();

        SketchPanel() {
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(COLUMNS * CELL_SIZE, ROWS * CELL_SIZE));
        }

        void addLine(int x1, int y1, int x2, int y2) {
            lines.add(new Line2D.Double(x1, y1, x2, y2));
            repaint();
        }

        void clear() {
            lines.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (Line2D line : lines) {
                g2d.draw(line);
            }
        }
    }

    public static void main(String[] args) {
        TurtleGraphicsGUI application = new TurtleGraphicsGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
