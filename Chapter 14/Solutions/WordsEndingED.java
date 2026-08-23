import java.util.Scanner;

public class WordsEndingED {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String[] tokens = scanner.nextLine().split("\\s+");

        System.out.println("Words ending with \"ED\":");
        for (String token : tokens) {
            if (token.endsWith("ED")) {
                System.out.println(token);
            }
        }
    }
}
