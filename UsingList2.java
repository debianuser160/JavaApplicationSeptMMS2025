import java.util.List;
import java.util.ArrayList;

public class UsingList2{
	public static void main(String[] args){
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(90);
		numbers.add(980);
		numbers.add(70);
		numbers.add(60);
		numbers.add(60);
		numbers.add(50);
		numbers.add(10);
		numbers.add(20);
		numbers.add(50);
		
		System.out.printf("%s%n",numbers);
		System.out.printf("The size is: %d%n",numbers.size());
	}
}