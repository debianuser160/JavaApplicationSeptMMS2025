public class StudentGradingSystem{
	public static void main(String[] args){
		String[] names = {"John", "Mary", "Jack", "James", "Lucy"};
		int[] marks = {69, 80, 100, 70, 50};
		
		for (int i = 0; i < 5; i++){
			if(marks[i] >= 70){
				System.out.printf("Student Name: %s%n",names[i]);
				System.out.printf("Student Mark: %d%n",marks);
				System.out.println("Grade: A");
				System.out.println("================\n\n");
			}
			else if(marks[i] >= 60){
				System.out.printf("Student Name: %s%n",names[i]);
				System.out.printf("Student Mark: %d%n",marks);
				System.out.println("Grade: B");
				System.out.println("================\n\n");
				
			}
			else if(marks[i] >= 50){
				System.out.printf("Student Name: %s%n",names[i]);
				System.out.printf("Student Mark: %d%n",marks);
				System.out.println("Grade: C");
				System.out.println("================\n\n");
			}
			else if(marks[i] >= 40){
				System.out.printf("Student Name: %s%n",names[i]);
				System.out.printf("Student Mark: %d%n",marks[i]);
				System.out.println("Grade: D");
				System.out.println("================\n\n");
			}
			else if(marks[i] >= 30){
				System.out.printf("Student Name: %s%n",names[i]);
				System.out.printf("Student Mark: %d%n",marks);
				System.out.println("Grade: E");
				System.out.println("================\n\n");
			}
			else{
				System.out.printf("Student Name: %s%n",names[i]);
				System.out.printf("Student Mark: %d%n",marks);
				System.out.println("Grade: F");
				System.out.println("================\n\n");
			}
		}//traditional for loop ends
		

	}
}