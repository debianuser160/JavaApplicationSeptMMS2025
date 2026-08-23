
package runtime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismaExceptionHandling {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        try{
        System.out.print("Enter yout age: ");
        int age = input.nextInt();
        
        System.out.printf("you are %d years old", age);
        }
        catch(InputMismatchException e){
            System.out.println("age is a number");
        }
    }
}
