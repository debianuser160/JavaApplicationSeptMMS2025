import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MyOval extends MyBoundedShape {
    private boolean filled;

    public MyOval() {
        super();
    }

    public MyOval(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke, boolean filled) {
        super(x1, y1, x2, y2, paint, stroke);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(getPaint());
        g2d.setStroke(getStroke());
        if (filled) {
            g2d.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        } else {
            g2d.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }
}
