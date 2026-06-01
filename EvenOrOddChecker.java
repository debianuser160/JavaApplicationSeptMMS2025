import java.util.Scanner;

public class EvenOrOddChecker{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		char option;
		int num1;
		do{
			System.out.print("Enter any number: ");
			num1 = input.nextInt();
			
			if (num1 % 2 == 0) {
				System.out.printf("%d is an even number%n",num1);
			}
			else{
				System.out.printf("%d is an odd number%n",num1);
			}
			System.out.print("Do you want to run the program again?(Y/N): ");
			option = input.next().charAt(0);
		}while(option == 'Y' || option == 'y');
		
		System.out.println("\nTerminating...");
	}
}