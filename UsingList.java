import java.util.List;
import java.util.ArrayList;

public class UsingList{
	public static void main(String[] args){
		List<String> cars = new ArrayList<>();
		
		cars.add("Toyota");
		cars.add("BMW");
		cars.add("Hyundai");
		cars.add("Mercedes Benz");
		cars.add(1,"Ford");
		
		//set the value of an element
		cars.set(1,"Dodge");
		//check the size of a list/array
		System.out.printf("list size is: %d%n",cars.size());
		
		for(String car: cars){
			System.out.println(car);
		}
		
		//remove an element
		cars.remove(0);
		
		System.out.printf("%s%n",cars.get(1));
		
		
	}
}