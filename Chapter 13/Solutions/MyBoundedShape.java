import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class MyBoundedShape extends MyShape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public MyBoundedShape() {
        super();
    }

    public MyBoundedShape(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke) {
        super(paint, stroke);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getUpperLeftX() {
        return Math.min(x1, x2);
    }

    public int getUpperLeftY() {
        return Math.min(y1, y2);
    }

    public int getWidth() {
        return Math.abs(x2 - x1);
    }

    public int getHeight() {
        return Math.abs(y2 - y1);
    }
}
