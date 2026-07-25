
package classworks;


public class ShapeMain {
    public static void main(String[] args){
        ClassWork_Shape[] shapeObj = {
            new Circle(),
            new Rectangle(),
            new Triangle()
        };
        for (ClassWork_Shape shape: shapeObj){
            shape.draw();
        }
    }
}
