import java.util.Scanner;

public class BookManager {
    public static void main(String[] args) {

        String[] books = {"Tensura", "The Bells of Notre Dam", "Brave New World", "Celcius 451",
                          "Lord of the Flies", "Pride and Prejudice", "The Catcher in the Rye",
                          "Diary of a wimpy kid", "Beserk", "Bleach"};

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("1 - View all books");
            System.out.println("2 - Search for a book");
            System.out.println("3 - Exit");
            System.out.print("Pick 1, 2, or 3: ");
            int pick = input.nextInt();
            input.nextLine();

            if (pick == 1) {
                int count = 1;
                for (String book : books) {
                    System.out.println(count + ". " + book);
					System.out.println("=================");
                    count++;
					
                }
            }

            if (pick == 2) {
                System.out.print("Enter book name: ");
                String search = input.nextLine();
                String found = null;
                for (String book : books) {
                    if (book.equals(search)) {
                        found = book;
                    }
                }
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("Not Available");
                }
            }

            if (pick == 3) {
                System.out.println("Terminating...");
                break;
            }

        }

    }
}
