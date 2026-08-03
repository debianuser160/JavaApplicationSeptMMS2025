
package chapter8assignment;


public class RectangleTest {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        System.out.println("length = " + rect.length);
        System.out.println("width = " + rect.width);
        System.out.println("perimeter = " + rect.perimeter());
        System.out.println("area = " + rect.area());

        rect.length = 10;
        rect.width = 4;
        System.out.println("perimeter = " + rect.perimeter());
        System.out.println("area = " + rect.area());
    }

}
