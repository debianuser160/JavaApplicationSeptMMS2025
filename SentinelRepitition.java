import java.util.Scanner;

public class SentinelRepitition{
	public static void main(String[] args){
		Scanner controlled_scan = new Scanner(System.in);
		int num, sum = 0;
		System.out.print("Enter -1 to end the input process.\new");
		
		while(true){
			System.out.print("Enter number: ");
			
			num = controlled_scan.nextInt();
			
			if(num == -1){
				System.out.print("Terminating...");
				break;
			}
			sum += num;
			
			System.out.printf("The sum of all numbers is %d%n",sum);
		}
	}
}