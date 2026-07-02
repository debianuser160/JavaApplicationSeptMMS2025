import java.util.Set;
import java.util.HashSet;

public class SetEmails{
	public static void main(String[] args){
		Set<String> emails = new HashSet<>();
		
		emails.add("randomguy36@gmail.com");
		emails.add("best0fthemall@gmail.com");
		emails.add("randomwoman1344@gmail.com");
		emails.add("USAcivilian36@gmail.com");
		emails.add("williams9909@gmail.com");
		emails.add("user6@gmail.com");
		emails.add("Sineststr0@gmail.com");
		emails.add("blahblahblah@gmail.com");
		emails.add("debianuser160@gmail.com");
		emails.add("randomguy6@gmail.com");

		for (String email : emails){
			System.out.printf("%s%n",email);
		}
	}
}