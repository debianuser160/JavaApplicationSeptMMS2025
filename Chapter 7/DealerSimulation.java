import java.security.SecureRandom;

public class DealerSimulation {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = deck.dealCard();
        }

        System.out.println("Dealer's original hand (face down):");
        for (int i = 0; i < 5; i++) {
            System.out.println("Card " + (i + 1) + ": [hidden]");
        }

        int handValue = deck.evaluateHand(hand);
        System.out.println("\nHidden evaluation: " + deck.getHandName(handValue));

        int cardsToDraw;
        if (handValue >= 5) {
            cardsToDraw = 0;
        } else if (handValue >= 3) {
            cardsToDraw = 1;
        } else if (handValue >= 1) {
            cardsToDraw = 2;
        } else {
            cardsToDraw = 3;
        }

        System.out.println("Dealer discards " + cardsToDraw + " card(s).");

        for (int i = 5 - cardsToDraw; i < 5; i++) {
            hand[i] = deck.dealCard();
        }

        System.out.println("\nDealer's final hand:");
        for (int i = 0; i < 5; i++) {
            System.out.println(hand[i]);
        }

        int finalValue = deck.evaluateHand(hand);
        System.out.println("Final hand: " + deck.getHandName(finalValue));
    }
}
