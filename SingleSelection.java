public class SingleSelection{
	public static void main(String[] args) {
		/*Control structures are used to manage the flow of execution based on certain conditions or loops. 
		In other words, control structure are rules that control the order in which statements in a program is executed. 
		Without them, java would run code line by line from top to bottom.
	There are three primary types of control structures:
	1.	Selection(decision making): these are known as branching statements. They are used to select a part of the program to be executed based on a condition. Java provides the following selection statements:
		a.	Single selection: is used when you want a block of code only if a condition is true
			i.	If the condition is false, the statement is simply skipped (no alternative is taken)
			ii.	Implemented using the if statement
		b.	Double selection: allows the program choose between two paths
			i.	One code clock executes if the condition is true
			ii.	Another code block executes if the condition is false
			iii.	Implemented using if-else statement

		c.	Multiple selection
	2.	Repetition(loop):
	3.	Jump: 
		*/
		int age = 22;
		if (age >= 18){
			System.out.printf("Oh wow. you are %d years old and you are an adult%n",age);
			System.out.println("I am happy to be an adult");
		}
	}
}