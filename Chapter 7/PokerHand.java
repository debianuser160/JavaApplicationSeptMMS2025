public class PokerHand {
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();

        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = myDeckOfCards.dealCard();
            System.out.println(hand[i]);
        }

        System.out.println("\nHand evaluation:");
        System.out.println("Pair: " + myDeckOfCards.hasPair(hand));
        System.out.println("Two Pairs: " + myDeckOfCards.hasTwoPairs(hand));
        System.out.println("Three of a Kind: " + myDeckOfCards.hasThreeOfAKind(hand));
        System.out.println("Four of a Kind: " + myDeckOfCards.hasFourOfAKind(hand));
        System.out.println("Flush: " + myDeckOfCards.hasFlush(hand));
        System.out.println("Straight: " + myDeckOfCards.hasStraight(hand));
        System.out.println("Full House: " + myDeckOfCards.hasFullHouse(hand));
        System.out.println("Best hand: " + myDeckOfCards.getHandName(myDeckOfCards.evaluateHand(hand)));
    }
}
