import java.util.Random;

public class PasswordGenerator{
	public static void main(String[] args){
		Random random = new Random();
		
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
		String password = "";
		
		for(int i = 0; i < 15; i++){
			int index = random.nextInt(70);
			password = password + chars.charAt(index);
		}
		
		System.out.printf("Password: %s%n",password);
	}
}
