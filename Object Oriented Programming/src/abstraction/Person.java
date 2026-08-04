
package abstraction;


public abstract class Person {
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
    
    public Person(){
        
    }
    
    public Person(String firstName, String lastName, String phoneNumber,
                   String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    void eat(){
        System.out.println("The person is eating");
    }
    
    void read(){
        System.out.println("The person is reading");
    }
    
    abstract void study();
}
