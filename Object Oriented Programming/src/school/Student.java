
package school;

import java.time.LocalDate;


public class Student {
    //Properties of Student :)
    private int studentID;
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate dOB;
    private String phoneNumber;

    public Student(int studentID, String firstName, 
            String lastName, char gender, LocalDate dOB, 
            String phoneNumber) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dOB = dOB;
        this.phoneNumber = phoneNumber;
    }
    
    

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getdOB() {
        return dOB;
    }

    public void setdOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumbers) {
        this.phoneNumber = phoneNumbers;
    }
    
    public void displayStudentInfo(){
        System.out.println("StudentID: " + studentID);
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dOB);
        System.out.println("Phone Number: " + phoneNumber);
    }
    
    
}
