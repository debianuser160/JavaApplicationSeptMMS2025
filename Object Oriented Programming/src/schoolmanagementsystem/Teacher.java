
package schoolmanagementsystem;


public class Teacher extends Person{

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    void performDuty() {
        System.out.println("The Teacher's duty is to teach.");
    }
    
    @Override
    void displayDetails(){
        System.out.println("Teacher name: " + name);
        System.out.println("Teacher age: " + age);
        
    }
    
}
