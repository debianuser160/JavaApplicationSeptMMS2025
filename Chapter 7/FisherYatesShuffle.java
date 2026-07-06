import java.security.SecureRandom;

public class FisherYatesShuffle {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        SecureRandom random = new SecureRandom();

        for (int count = 0; count < 52; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }

        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        System.out.println("Shuffled deck (Fisher-Yates):");
        for (int i = 0; i < 52; i++) {
            System.out.println(deck[i]);
        }
    }
}
