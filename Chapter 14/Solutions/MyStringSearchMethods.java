import java.util.Scanner;

public class MyStringSearchMethods {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to search:");
        String text = scanner.nextLine();

        System.out.println("Enter the characters to search for:");
        String searchKey = scanner.nextLine();

        System.out.printf("myIndexOf(\"%s\", \"%s\")      = %d%n",
                text, searchKey, myIndexOf(text, searchKey));
        System.out.printf("String.indexOf(\"%s\")       = %d (for comparison)%n",
                searchKey, text.indexOf(searchKey));
        System.out.printf("myLastIndexOf(\"%s\", \"%s\")  = %d%n",
                text, searchKey, myLastIndexOf(text, searchKey));
        System.out.printf("String.lastIndexOf(\"%s\")   = %d (for comparison)%n",
                searchKey, text.lastIndexOf(searchKey));
    }

    public static int myIndexOf(String source, String target) {
        if (target.isEmpty()) {
            return 0;
        }
        int limit = source.length() - target.length();
        for (int i = 0; i <= limit; i++) {
            if (matchesAt(source, target, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int myLastIndexOf(String source, String target) {
        if (target.isEmpty()) {
            return source.length();
        }
        for (int i = source.length() - target.length(); i >= 0; i--) {
            if (matchesAt(source, target, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean matchesAt(String source, String target, int position) {
        for (int j = 0; j < target.length(); j++) {
            if (source.charAt(position + j) != target.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
