public class VariableLengthArgument{
	public static void main(String[] args){
		System.out.printf("the sum is: %d%n",addition(5,6,8,9,3,2,1));
		System.out.printf("the sum is: %d%n",addition(8,6,4,7,5,6));
		System.out.printf("the sum is: %d%n",addition(5,6,8,9,4));
		System.out.printf("the sum is: %d%n",addition(5,6,8,6));
		System.out.printf("the sum is: %d%n",addition(5,6,8));
		System.out.printf("the sum is: %d%n",addition(5,6));
		System.out.printf("the sum is: %d%n",addition(5));
		System.out.printf("the sum is: %d%n",addition());
	}
	
	public static int addition(int... numbers){
		//an elipsis(...) after the datatype above indicates variable length argument
		
		int sum = 0;
		for(int number : numbers){
			sum += number;
		}
		return sum;
	}
}