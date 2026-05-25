import java.util.Scanner;

public class SwitchCaseStatement{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char grade;
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter the subject: ");
		String subject = input.nextLine();
		
		System.out.print("Enter your score: ");
		int score = input.nextInt();
		
		System.out.println("");
		System.out.println("-----------------------------------------------");
		if (score > 100) {
			System.out.println("Inputted Score is greater than 100. Input Prohibited.");
		}
		else{
			
		switch (score/10){
			case 0: 
			case 1: 
			case 2:
				System.out.printf("Full name: %s%n",name);
				System.out.printf("Subject: %s%n",subject);
				System.out.printf("Score: %d%n",score);
				System.out.print("Grade: F\n");
			break;
			case 3:
				System.out.printf("Full name: %s%n",name);
				System.out.printf("Subject: %s%n",subject);
				System.out.printf("Score: %d%n",score);
				System.out.printf("Grade: E\n");
			break;
			case 4:
				System.out.printf("Full name: %s%n",name);
				System.out.printf("Subject: %s%n",subject);
				System.out.printf("Score: %d%n",score);
				System.out.printf("Grade: D\n");
			break;
			case 5:
				System.out.printf("Full name: %s%n",name);
				System.out.printf("Subject: %s%n",subject);
				System.out.printf("Score: %d%n",score);
				System.out.printf("Grade: C\n");
			break;
			case 6:
				System.out.printf("Full name: %s%n",name);
				System.out.printf("Subject: %s%n",subject);
				System.out.printf("Score: %d%n",score);
				System.out.printf("Grade: B\n");
			break;
			case 7:
			case 8:
			case 9:
			case 10:
				System.out.printf("Full name: %s%n",name);
				System.out.printf("Subject: %s%n",subject);
				System.out.printf("Score: %d%n",score);
				System.out.printf("Grade: A\n");
			break;
			default:
				System.out.println("Invalid Score inputed");
				
		}
		}
	}
}