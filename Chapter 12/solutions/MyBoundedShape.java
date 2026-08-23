import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape {
   private boolean filled;

   public MyBoundedShape() {
      this(0, 0, 0, 0, Color.BLACK, false);
   }

   public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
      super(x1, y1, x2, y2, color);
      this.filled = filled;
   }

   public void setFilled(boolean filled) { this.filled = filled; }
   public boolean isFilled() { return filled; }

   public int getUpperLeftX() { return Math.min(getX1(), getX2()); }
   public int getUpperLeftY() { return Math.min(getY1(), getY2()); }
   public int getWidth() { return Math.abs(getX1() - getX2()); }
   public int getHeight() { return Math.abs(getY1() - getY2()); }
}
