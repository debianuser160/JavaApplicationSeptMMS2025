import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private final List<MyShape> shapes = new ArrayList<>();
    private MyShape currentShape;
    private int shapeType;
    private boolean filled;
    private Paint currentPaint = Color.BLACK;
    private Stroke currentStroke = new BasicStroke();

    public DrawPanel() {
        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setCurrentPaint(Paint paint) {
        currentPaint = paint;
    }

    public void setCurrentStroke(Stroke stroke) {
        currentStroke = stroke;
    }

    private MyShape createShape(int x1, int y1, int x2, int y2) {
        switch (shapeType) {
            case 0:
                return new MyLine(x1, y1, x2, y2, currentPaint, currentStroke);
            case 1:
                return new MyRectangle(x1, y1, x2, y2, currentPaint, currentStroke, filled);
            default:
                return new MyOval(x1, y1, x2, y2, currentPaint, currentStroke, filled);
        }
    }

    private void updateCurrentShapeEndPoint(int x, int y) {
        if (currentShape instanceof MyLine) {
            MyLine line = (MyLine) currentShape;
            line.setX2(x);
            line.setY2(y);
        } else if (currentShape instanceof MyRectangle) {
            MyRectangle rectangle = (MyRectangle) currentShape;
            rectangle.setX2(x);
            rectangle.setY2(y);
        } else if (currentShape instanceof MyOval) {
            MyOval oval = (MyOval) currentShape;
            oval.setX2(x);
            oval.setY2(y);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (MyShape shape : shapes) {
            shape.draw(g2d);
        }

        if (currentShape != null) {
            currentShape.draw(g2d);
        }
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            currentShape = createShape(event.getX(), event.getY(), event.getX(), event.getY());
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            if (currentShape != null) {
                updateCurrentShapeEndPoint(event.getX(), event.getY());
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            if (currentShape != null) {
                updateCurrentShapeEndPoint(event.getX(), event.getY());
                shapes.add(currentShape);
                currentShape = null;
                repaint();
            }
        }
    }
}
