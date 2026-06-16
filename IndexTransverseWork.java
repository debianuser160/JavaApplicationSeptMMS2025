//numbers = {6,9,5,12,4,8,5,2,16,14}

public class IndexTransverseWork{
	public static void main(String[] args){
	int[] numbers = {6,9,5,12,4,8,5,2,16,14};
	int totalEven = 0;
	
	for (int i = 0; i < 10; i++){
		if (numbers[i] % 2 == 0){
			totalEven++;
		}
	}
	
	System.out.printf("the count of even numbers is %d%n",totalEven);


	}
}