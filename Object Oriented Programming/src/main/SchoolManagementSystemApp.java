
package main;


import java.time.LocalDate;
//import school.Student;
import school.GraduateStudent;
import school.UnderGraduateStudent;
import java.util.Scanner;

public class SchoolManagementSystemApp {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter 1: For Graduate Student");
        System.out.println("Enter 2: For Under Graduate Student");
        
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        
        switch(choice){
            case 1:{
                System.out.print("Enter your student ID: ");
                int studentID = scan.nextInt();
                
                System.out.print("Enter First Name: ");
                String firstName = scan.nextLine();
                
                System.out.print("Enter Last Name: ");
                String lastName = scan.nextLine();
                
                System.out.print("Enter Gender: ");
                char gender = scan.next().charAt(0);
                
                System.out.print("Enter Date of Birth(YYYY-MM-dd): ");
                String dateOfBirth = scan.nextLine();
                
                System.out.print("Enter Phone Number: ");
                String phoneNumber = scan.nextLine();
                
                System.out.print("Enter Final Year Project: ");
                String finalYearProject = scan.nextLine();
                
                GraduateStudent gstudent = new GraduateStudent(studentID, 
                        firstName, lastName, gender, 
                        LocalDate.parse(dateOfBirth) ,
                        phoneNumber, finalYearProject);
                gstudent.displayStudentInfo();
             break;
            }
            case 2:{
                System.out.print("Enter your student ID: ");
                int studentID = scan.nextInt();
                
                System.out.print("Enter First Name: ");
                String firstName = scan.nextLine();
                
                System.out.print("Enter Last Name: ");
                String lastName = scan.nextLine();
                
                System.out.print("Enter Gender: ");
                char gender = scan.next().charAt(0);
                
                System.out.print("Enter Date of Birth(YYYY-MM-dd): ");
                String dateOfBirth = scan.nextLine();
                
                System.out.print("Enter Phone Number: ");
                String phoneNumber = scan.nextLine();
                
                System.out.print("Enter Level: ");
                int level = scan.nextInt();
                
                UnderGraduateStudent ugstudent = 
                        new UnderGraduateStudent(studentID, firstName, 
                                lastName, gender, 
                                LocalDate.parse(dateOfBirth) ,
                                phoneNumber, level);
                ugstudent.displayStudentInfo();
            break;
            }
            default:
                System.out.println("Invalid input");
        }
        
    }
}
