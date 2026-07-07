public class MainApp{
	public static void main(String[] args){
		Student student1 = new Student(1,"John","Willy",'F');
		Student student2 = new Student(2,"David","Nkweke",'F');
		Student student3 = new Student(3,"jason","vorhees",'M');
		Student student4 = new Student(4,"Ligma","Bawls",'F');
		Student student5 = new Student(5,"Ben","Dover",'F');

		student1.displayStudentInfo();
		System.out.println("==================");
		
		student2.displayStudentInfo();
		System.out.println("==================");
		
		student3.displayStudentInfo();
		System.out.println("==================");
		
		student4.displayStudentInfo();
		System.out.println("==================");
		
		student5.displayStudentInfo();
		System.out.println("==================");
	}
}