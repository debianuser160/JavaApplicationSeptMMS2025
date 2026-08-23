import java.util.Scanner;

public class WordsStartingWithB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String[] tokens = scanner.nextLine().split("\\s+");

        System.out.println("Words beginning with \"b\":");
        for (String token : tokens) {
            if (token.toLowerCase().startsWith("b")) {
                System.out.println(token);
            }
        }
    }
}
