
package abstraction;


public class Student extends Person {

    @Override
    void study() {
        System.out.println("Student is studying");
    }
    
    @Override
    void read(){
        System.out.println(firstName + " " + lastName + " " + 
                           " is reading");
    }
    
    int studentID;
    
    public Student(){
        
    }
    
    public Student(String firstName, String lastName, String phoneNumber,
                    String address, int studentID){
        super(firstName, lastName, phoneNumber, address);
        this.studentID = studentID;
    }
}
