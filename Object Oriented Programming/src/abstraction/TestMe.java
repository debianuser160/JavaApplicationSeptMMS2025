
package abstraction;

public class TestMe {
    public static void main(String[] args){
        Student student1 = new Student("John", "Young", "whatever", "whatever", 1);
        
        student1.read();
        System.out.println("===============");
        student1.study();
    }
}
