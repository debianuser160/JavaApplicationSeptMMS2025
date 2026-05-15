import java.util.Scanner;

public class  ClassWork3{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter your age: ");
		int age = input.nextInt();
		input.nextLine();
		
		System.out.print("Enter your address: ");
		String address = input.nextLine();
		
		System.out.printf("----------------------------------------%n");
		System.out.printf("Hello %s. You are %d years old and Your address is %s",name,age,address);
	}
}

//write a java program that accepts 5 numbers from the user and find the sum, average and product of those numbers
//Write a program that accepts a number and checks if an inputed number is an even number
//Write a java program to accept name, age, and address and format the received data to print a meaningful information on the screen