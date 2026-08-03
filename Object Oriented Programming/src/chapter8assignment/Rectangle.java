
package chapter8assignment;


public class Rectangle {
    public float length = 1;
    public float width = 1;

    public float perimeter() {
        return 2 * (length + width);
    }

    public float area() {
        return length * width;
    }
}
