import java.util.Scanner;
//Input name, subject, score for the subject and sum all the scores, then grade the sum.
public class IfElseIfStatement{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char grade;
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter the subject: ");
		String subject = input.nextLine();
		
		System.out.print("Enter your score: ");
		int score = input.nextInt();
		
		System.out.println("\n--------------------------------------");
		
		if (score >= 70) {
			System.out.printf("Full name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: A\n");
		}
		else if (score <= 69 && score >= 60) {
			System.out.printf("Full name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: B\n");
		}
		else if (score <= 59 && score >= 50) {
			System.out.printf("Full name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.printf("Grade: C\n");
		}
		else if (score <= 49 && score >= 40) {
			System.out.printf("Full name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.printf("Grade: D\n");
		}
		else if (score <= 39 && score >= 30) {
			System.out.printf("Full name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.printf("Grade: E\n");
		}
		else {
			System.out.printf("Full name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.printf("Grade: F\n");
		}
	}
}