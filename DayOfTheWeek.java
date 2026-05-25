//Write a Java program to accept a day in number(1-sunday,2-monday,3-tuesday,4-wednesday,5-thursday,6-friday,7-saturday)
import java.util.Scanner;

public class DayOfTheWeek{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number(1 - 7): ");
		int number = input.nextInt();
		
		if (number == 1) {
			System.out.printf("You entered %d. The day of the week is Sunday",number);
		}
		else if (number == 2) {
			System.out.printf("You entered %d. The day of the week is Monday",number);
		}
		else if (number == 3) {
			System.out.printf("You entered %d. The day of the week is Tuesday",number);
		}
		else if (number == 4) {
			System.out.printf("You entered %d. The day of the week is Wednesday",number);
		}
		else if (number == 5) {
			System.out.printf("You entered %d. The day of the week is Thursday",number);
		}
		else if (number == 6) {
			System.out.printf("You entered %d. The day of the week is Friday",number);
		}
		else if (number == 7) {
			System.out.printf("You entered %d. The day of the week is Saturday",number);
		}
		else{
			System.out.print("There are only 7 days in a week.");
		}
		
/*SwitchCase version

		switch(day){
			case 1:
				System.out.println("The day you entered is Sunday");
			break;
			case 2:
				System.out.println("The day you entered is Monday");
			break;
			case 3:
				System.out.println("The day you entered is Tuesday");
			break;
			case 4:
				System.out.println("The day you entered is Wednesday");
			break;
			case 5:
				System.out.println("The day you entered is Thursday");
			break;
			case 6:
				System.out.println("The day you entered is Friday");
			break;
			case 7:
				System.out.println("The day you entered is Saturday");
			break;
			default:
				System.out.print("Invalid day");
			break;
		}
*/
	}
}