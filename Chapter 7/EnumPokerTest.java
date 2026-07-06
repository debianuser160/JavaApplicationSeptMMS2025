public class EnumPokerTest {
    public static void main(String[] args) {
        DeckOfCardsEnum myDeck = new DeckOfCardsEnum();
        myDeck.shuffle();

        for (int i = 0; i < 5; i++) {
            System.out.println(myDeck.dealCard());
        }
    }
}
