import java.util.Scanner;

public class Classwork7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int num1; 
		int num2; 
		int num3;

        System.out.print("Enter first number: ");
        num1 = input.nextInt();

        System.out.print("Enter second number: ");
        num2 = input.nextInt();

        System.out.print("Enter second number: ");
        num3 = input.nextInt();

        int sum = num1 + num2 + num3;

        if (sum % 2 == 0 && sum % 10 == 0) {
            System.out.println("The sum is even and is divisible by 10");
            int num4;
			int num5;
			int num6;
            System.out.print("Enter first number(2): ");
            num4 = input.nextInt();
            System.out.print("Enter second number(2): ");
            num5 = input.nextInt();
            System.out.print("Enter Third number(2): ");
            num6 = input.nextInt();
            int product = num4 + num5 + num6;
            if (product > 200) {
                System.out.println("HORRAAAAYY!!!!");
                }
            else{
                System.out.println("Ongoing...");
                }
        }
    }
}