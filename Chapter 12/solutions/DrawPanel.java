import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
   public static final int LINE = 0;
   public static final int OVAL = 1;
   public static final int RECTANGLE = 2;

   private final MyShape[] shapes = new MyShape[100];
   private int shapeCount;
   private int shapeType = LINE;
   private MyShape currentShape;
   private Color currentColor = Color.BLACK;
   private boolean filledShape;
   private final JLabel statusLabel;

   public DrawPanel(JLabel statusLabel) {
      this.statusLabel = statusLabel;
      setBackground(Color.WHITE);

      MouseHandler mouseHandler = new MouseHandler();
      addMouseListener(mouseHandler);
      addMouseMotionListener(mouseHandler);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int index = 0; index < shapeCount; index++) {
         shapes[index].draw(g);
      }
      if (currentShape != null) {
         currentShape.draw(g);
      }
   }

   public void setShapeType(int shapeType) {
      this.shapeType = shapeType;
   }

   public void setCurrentColor(Color currentColor) {
      this.currentColor = currentColor;
   }

   public void setFilledShape(boolean filledShape) {
      this.filledShape = filledShape;
   }

   public void clearLastShape() {
      if (shapeCount > 0) {
         shapeCount--;
         repaint();
      }
   }

   public void clearDrawing() {
      shapeCount = 0;
      repaint();
   }

   private class MouseHandler extends MouseAdapter implements MouseMotionListener {
      @Override
      public void mousePressed(MouseEvent event) {
         switch (shapeType) {
            case OVAL:
               currentShape = new MyOval(event.getX(), event.getY(),
                  event.getX(), event.getY(), currentColor, filledShape);
               break;
            case RECTANGLE:
               currentShape = new MyRect(event.getX(), event.getY(),
                  event.getX(), event.getY(), currentColor, filledShape);
               break;
            default:
               currentShape = new MyLine(event.getX(), event.getY(),
                  event.getX(), event.getY(), currentColor);
               break;
         }
      }

      @Override
      public void mouseReleased(MouseEvent event) {
         if (currentShape != null && shapeCount < shapes.length) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());
            shapes[shapeCount] = currentShape;
            shapeCount++;
            currentShape = null;
            repaint();
         }
      }

      @Override
      public void mouseMoved(MouseEvent event) {
         statusLabel.setText(String.format("(%d, %d)", event.getX(), event.getY()));
      }

      @Override
      public void mouseDragged(MouseEvent event) {
         if (currentShape != null) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());
            statusLabel.setText(String.format("(%d, %d)", event.getX(), event.getY()));
            repaint();
         }
      }
   }
}
