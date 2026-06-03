public class StaticMethodInJava{
	public static void main(String[] args){
		
		int sum = add(60, 50, 80);
		
		System.out.printf("The sum of all numbers is %d%n",sum);
		
		sum = add(90, 40, 30);
		
		System.out.printf("The sum of all numbers is %d%n",sum);
		
		details(21, "Konquer");

		details(15, "Konquer");

		details(20, "Konquer");

	}


	public static int add(int num1, int num2, int num3	){
		/*instructions will be entered here*/
			
		int sum = num1 + num2 + num3;
		return sum;
		

	}
	
	public static void details(int age, String name){
		System.out.printf("Your name is %s%n",name);
		System.out.printf("You are %d years old%n",age);
		System.out.println("---------------------------");
	}
}