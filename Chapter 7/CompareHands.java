public class CompareHands {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] hand1 = new Card[5];
        Card[] hand2 = new Card[5];

        System.out.println("Hand 1:");
        for (int i = 0; i < 5; i++) {
            hand1[i] = deck.dealCard();
            System.out.println(hand1[i]);
        }

        System.out.println("\nHand 2:");
        for (int i = 0; i < 5; i++) {
            hand2[i] = deck.dealCard();
            System.out.println(hand2[i]);
        }

        int score1 = deck.evaluateHand(hand1);
        int score2 = deck.evaluateHand(hand2);

        System.out.println("\nHand 1: " + deck.getHandName(score1));
        System.out.println("Hand 2: " + deck.getHandName(score2));

        if (score1 > score2) {
            System.out.println("Hand 1 wins!");
        } else if (score2 > score1) {
            System.out.println("Hand 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
