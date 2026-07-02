public class VariableLengthArgument{
	public static void main(String[] args){
		System.out.printf("the odd numbers are: %d%n",oddNumbers(5,6,8,9,3,2,1));
		System.out.printf("the odd numbers are: %d%n",oddNumbers(8,6,4,7,5,6));
		System.out.printf("the odd numbers are: %d%n",oddNumbers(5,6,8,9,4));
		System.out.printf("the odd numbers are: %d%n",oddNumbers(5,6,8,6));
		System.out.printf("the odd numbers are: %d%n",oddNumbers(5,6,8));
		System.out.printf("the odd numbers are: %d%n",oddNumbers(5,6));
		System.out.printf("the odd numbers are: %d%n",oddNumbers(5));
		}
	}
	
	public static int oddNumbers(int... numbers){
		//an elipsis(...) after the datatype above indicates variable length argument
		
		int oddNumber = 0;
		for(int number :numbers){
			if(number % 3 == 0){
				oddNumber++;
			}
		}
		return oddNumber;
	}
}