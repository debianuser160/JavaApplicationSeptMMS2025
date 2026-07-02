import java.util.Queue;
import java.util.LinkedList;

public class UsingQueue{
	public static void main(String[] args){
		Queue<String> names = new LinkedList<>();
		
		names.add("Henry");
		names.add("Young");
		names.add("John");
		
		System.out.println(names);
	}
}