import java.time.LocalDate;

public class UsingLocalDate{
	public static void main(String[] args){
		LocalDate todaysDate = LocalDate.now();
		System.out.printf("Today's date is: %s%n",todaysDate);
		
		LocalDate myBirthDate = LocalDate.of(2010,6,27);
		System.out.printf("Birthdate: %s%n",myBirthDate);
		
		LocalDate resumptionDate = LocalDate.parse("2028-10-15");
		System.out.printf("The resumption date is %s%n",resumptionDate);
		
		System.out.printf("The resumption date is %s%n",resumptionDate.getYear());
		System.out.printf("The resumption month is %s%n",resumptionDate.getMonth());
		System.out.printf("The resumption day is %s%n",resumptionDate.getDayOfMonth());
		System.out.printf("The meeting date is %s%n",resumptionDate.plusDays(10));
		System.out.printf("The party date is %s%n",resumptionDate.plusMonths(5));
		
		boolean isLeapYear = resumptionDate.isLeapYear();
		System.out.printf("is resumption date a leap year?: %b%n",isLeapYear);
		
		boolean isEqual = resumptionDate.equals(myBirthDate);
		System.out.printf("is %s the same as %s?: %b%n",resumptionDate,myBirthDate,isEqual);
		

	}
}