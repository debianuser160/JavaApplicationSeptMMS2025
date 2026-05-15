import java.util.Scanner;

public class ClassWork2{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter num1: ");
		int num1 = input.nextInt();
		
		boolean evenNumber = num1 % 2 == 0;
		
		System.out.println("------------------------------------------------");
		System.out.printf("is %d an even number: %b",num1, evenNumber);
	}
}