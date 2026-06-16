public class EnhancedForLoop2{
	public static void main(String[] args){
		int[] marks = {69, 80, 100, 70, 50, 60, 69, 80, 76, 20};
		
		System.out.println("Student marks are:");
		for(int mark:marks){
			System.out.printf("%d%n",mark);
		}
	}
}