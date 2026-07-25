
package classwork3;


public class Person {
    void display(){
        System.out.println("No arguments needed");
    }
    
    void display(String name){
        System.out.println("Your name is: " + name);
    }
    
    void display(String name, int age){
        System.out.println("your name is " + name + " and you are " + age + " years old.");
    }
}
