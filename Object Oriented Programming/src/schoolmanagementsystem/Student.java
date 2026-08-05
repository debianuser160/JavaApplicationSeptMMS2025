
package schoolmanagementsystem;


public class Student extends Person{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    void performDuty() {
        System.out.println("The student's duty is to study.");
    }
    
    @Override
    void displayDetails(){
        System.out.println("Student name: " + name);
        System.out.println("Student age: " + age);
        
    }
    
}
