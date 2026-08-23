import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class MyShape {
    private Paint paint;
    private Stroke stroke;

    public MyShape() {
        paint = Color.BLACK;
        stroke = new BasicStroke();
    }

    public MyShape(Paint paint, Stroke stroke) {
        this.paint = paint;
        this.stroke = stroke;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public abstract void draw(Graphics2D g2d);
}
