public class InstanceMethodInJava{
	//Methods can be placed here
	public static void main(String[] args){
		InstanceMethodInJava instanceMethod = new InstanceMethodInJava();
		
		int sum = instanceMethod.add(60, 50, 80);
		
		System.out.printf("The sum of all numbers is %d%n",sum);
		
		sum = instanceMethod.add(90, 40, 30);
		
		System.out.printf("The sum of all numbers is %d%n",sum);
		
		instanceMethod.details(21, "Konquer");

		instanceMethod.details(15, "Konquer");

		instanceMethod.details(20, "Konquer");

	}
	//Methods can be placed here
	public int add(int num1, int num2, int num3	){
		/*instructions will be entered here*/
			
		int sum = num1 + num2 + num3;
		return sum;
		
		/*instant method
		static method
		recursive method*/
	}
	
	public void details(int age, String name){
		System.out.printf("Your name is %s%n",name);
		System.out.printf("You are %d years old%n",age);
		System.out.println("---------------------------");
	}
}