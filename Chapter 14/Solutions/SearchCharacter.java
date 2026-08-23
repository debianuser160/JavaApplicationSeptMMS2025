import java.util.Scanner;

public class SearchCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String text = scanner.nextLine();

        System.out.println("Enter a search character:");
        String input = scanner.nextLine();
        char searchCharacter = input.charAt(0);

        int count = 0;
        int index = text.indexOf(searchCharacter);
        while (index != -1) {
            count++;
            index = text.indexOf(searchCharacter, index + 1);
        }

        System.out.printf("The character '%c' occurs %d time(s) in the text.%n",
                searchCharacter, count);
    }
}
