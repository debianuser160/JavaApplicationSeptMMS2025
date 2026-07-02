import java.time.LocalDateTime;

public class UsingLocalDateTime{
	public static void main(String[] args){
		
		LocalDateTime todaysDateTime = LocalDateTime.now();
		System.out.printf("the current date and time is %s%n",todaysDateTime);
		
		LocalDateTime meetingDateTime = LocalDateTime.of(2026,5,7,12,32);
		System.out.printf("The current date and time: %s%n",meetingDateTime);
		
		LocalDateTime classTime = LocalDateTime.parse("2025-11-30T13:12:05");
		System.out.printf("The current date and time is: %s%n",classTime);
		
		System.out.printf("the meeting date is: %s%n",meetingDateTime.getDayOfMonth());
		System.out.printf("the meeting month is: %s%n",meetingDateTime.getMonth());
		System.out.printf("the meeting year is: %s%n",meetingDateTime.getYear());
		System.out.printf("the meeting date is: %s%n",meetingDateTime.getHour());
		System.out.printf("the meeting date will be postponed in 10 days: %s%n",meetingDateTime.plusDays(10));
		System.out.printf("the meeting date will hold in 10 hours: %s%n",meetingDateTime.plusHours(10));
		System.out.printf("the meeting will take place 10 minutes earlier: %s%n",meetingDateTime.minusMinutes(10));
		System.out.printf("the meeting date is: %s%n",meetingDateTime.getDate());


	}
}