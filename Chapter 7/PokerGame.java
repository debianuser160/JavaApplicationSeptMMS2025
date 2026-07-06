import java.util.Scanner;
import java.security.SecureRandom;

public class PokerGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        int playerWins = 0;
        int dealerWins = 0;

        for (int game = 1; game <= 20; game++) {
            System.out.println("\n=== Game " + game + " ===");
            DeckOfCards deck = new DeckOfCards();
            deck.shuffle();

            Card[] playerHand = new Card[5];
            Card[] dealerHand = new Card[5];

            for (int i = 0; i < 5; i++) {
                playerHand[i] = deck.dealCard();
                dealerHand[i] = deck.dealCard();
            }

            System.out.println("Your hand:");
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + ": " + playerHand[i]);
            }

            System.out.print("Enter card numbers to replace (1-5, space-separated, 0 to keep all): ");
            String replace = input.nextLine();
            if (!replace.equals("0")) {
                String[] parts = replace.split(" ");
                for (String p : parts) {
                    int idx = Integer.parseInt(p) - 1;
                    if (idx >= 0 && idx < 5) {
                        playerHand[idx] = deck.dealCard();
                    }
                }
            }

            int dealerValue = deck.evaluateHand(dealerHand);
            int cardsToDraw;
            if (dealerValue >= 5) cardsToDraw = 0;
            else if (dealerValue >= 3) cardsToDraw = 1;
            else if (dealerValue >= 1) cardsToDraw = 2;
            else cardsToDraw = 3;

            for (int i = 5 - cardsToDraw; i < 5; i++) {
                dealerHand[i] = deck.dealCard();
            }

            int playerValue = deck.evaluateHand(playerHand);
            dealerValue = deck.evaluateHand(dealerHand);

            System.out.println("Your hand: " + deck.getHandName(playerValue));
            System.out.println("Dealer's hand: " + deck.getHandName(dealerValue));

            if (playerValue > dealerValue) {
                System.out.println("You win!");
                playerWins++;
            } else if (dealerValue > playerValue) {
                System.out.println("Dealer wins!");
                dealerWins++;
            } else {
                System.out.println("Tie!");
            }
        }

        System.out.println("\n=== Final Results ===");
        System.out.println("Player wins: " + playerWins);
        System.out.println("Dealer wins: " + dealerWins);
    }
}
