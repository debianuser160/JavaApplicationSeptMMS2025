import java.util.Scanner;

public class HeartRatesTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter birth month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter birth day: ");
        int day = input.nextInt();

        System.out.print("Enter birth year: ");
        int year = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, month, day, year);

        System.out.println("\n--- Heart Rate Information ---");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Date of Birth: " + person.getBirthMonth() + "/" + person.getBirthDay() + "/" + person.getBirthYear());
        System.out.println("Age: " + person.getAge() + " years");
        System.out.println("Maximum Heart Rate: " + person.getMaxHeartRate() + " bpm");
        System.out.println("Target Heart Rate Range: " + person.getTargetHeartRate());
    }
}
