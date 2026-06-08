public class Chapter4_1{
	public static void main(String[] args){
		//question A
		i = 1;
		while (i <= 10){ 
		++i; 
		} 
		
		//question B
		for (float k = 0.1; k != 1.0; k += 0.1) {
			System.out.printf("%.1f%n",k);
		}
		
		//question C
		switch (n) { 
			case 1: 
			System.out.println("The number is 1"); 
			case 2: 
			System.out.println("The number is 2");
			 break; 
			default: 
			System.out.println("The number is not 1 or 2"); 
			break;
		}
		
		//qeustion D
		n = 1; 
		while (n <= 10){
			System.out.printf("%d%n",n);
			n++;
		} 
		

	}
}