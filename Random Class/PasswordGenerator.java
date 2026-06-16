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
		
<<<<<<< HEAD
		System.out.printf("Password: %s%n",password);
=======
		System.out.printf("Password: %s%n", password);
>>>>>>> a94b5089903c585888e98d1b7ae21a9018d37d11
	}
}
