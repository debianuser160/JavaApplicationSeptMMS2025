
package schoolmanagementsystem;


public class MainApp {
    public static void main(String[] args){
        Teacher teacher = new Teacher("Jason Vorhees", 22);
        Student student = new Student("Oasis", 18);
        
        System.out.println("====Teacher's Details=====");
        teacher.displayDetails();
        teacher.performDuty();
        
        System.out.println("========Student's Details====");
        student.displayDetails();
        student.performDuty();
    }
}
