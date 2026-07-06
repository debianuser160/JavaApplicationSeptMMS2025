import java.security.SecureRandom;

public class DeckOfCardsEnum {
    private CardEnum[] deck;
    private int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    private static final SecureRandom randomNumbers = new SecureRandom();

    public DeckOfCardsEnum() {
        Face[] faces = Face.values();
        Suit[] suits = Suit.values();
        deck = new CardEnum[NUMBER_OF_CARDS];
        currentCard = 0;
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new CardEnum(faces[count % 13], suits[count / 13]);
        }
    }

    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            CardEnum temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public CardEnum dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }
}
