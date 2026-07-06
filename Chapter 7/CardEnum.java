public class CardEnum {
    private final Face face;
    private final Suit suit;

    public CardEnum(Face cardFace, Suit cardSuit) {
        face = cardFace;
        suit = cardSuit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return face + " of " + suit;
    }
}
