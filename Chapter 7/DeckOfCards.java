import java.security.SecureRandom;

public class DeckOfCards {
    private Card[] deck;
    private int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    private static final SecureRandom randomNumbers = new SecureRandom();

    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new Card[NUMBER_OF_CARDS];
        currentCard = 0;
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }

    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }

    public int[] getFaceValues(Card[] hand) {
        int[] values = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            String face = hand[i].getFace();
            switch (face) {
                case "Ace": values[i] = 1; break;
                case "Deuce": values[i] = 2; break;
                case "Three": values[i] = 3; break;
                case "Four": values[i] = 4; break;
                case "Five": values[i] = 5; break;
                case "Six": values[i] = 6; break;
                case "Seven": values[i] = 7; break;
                case "Eight": values[i] = 8; break;
                case "Nine": values[i] = 9; break;
                case "Ten": values[i] = 10; break;
                case "Jack": values[i] = 11; break;
                case "Queen": values[i] = 12; break;
                case "King": values[i] = 13; break;
            }
        }
        return values;
    }

    public int[] countFaces(Card[] hand) {
        int[] counts = new int[14];
        int[] values = getFaceValues(hand);
        for (int v : values) {
            counts[v]++;
        }
        return counts;
    }

    public boolean hasPair(Card[] hand) {
        int[] counts = countFaces(hand);
        for (int c : counts) {
            if (c == 2) return true;
        }
        return false;
    }

    public boolean hasTwoPairs(Card[] hand) {
        int[] counts = countFaces(hand);
        int pairs = 0;
        for (int c : counts) {
            if (c == 2) pairs++;
        }
        return pairs == 2;
    }

    public boolean hasThreeOfAKind(Card[] hand) {
        int[] counts = countFaces(hand);
        for (int c : counts) {
            if (c == 3) return true;
        }
        return false;
    }

    public boolean hasFourOfAKind(Card[] hand) {
        int[] counts = countFaces(hand);
        for (int c : counts) {
            if (c == 4) return true;
        }
        return false;
    }

    public boolean hasFlush(Card[] hand) {
        String suit = hand[0].getSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasStraight(Card[] hand) {
        int[] values = getFaceValues(hand);
        java.util.Arrays.sort(values);
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] + 1 != values[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFullHouse(Card[] hand) {
        int[] counts = countFaces(hand);
        boolean hasTwo = false;
        boolean hasThree = false;
        for (int c : counts) {
            if (c == 2) hasTwo = true;
            if (c == 3) hasThree = true;
        }
        return hasTwo && hasThree;
    }

    public int evaluateHand(Card[] hand) {
        if (hasFlush(hand) && hasStraight(hand)) return 8;
        if (hasFourOfAKind(hand)) return 7;
        if (hasFullHouse(hand)) return 6;
        if (hasFlush(hand)) return 5;
        if (hasStraight(hand)) return 4;
        if (hasThreeOfAKind(hand)) return 3;
        if (hasTwoPairs(hand)) return 2;
        if (hasPair(hand)) return 1;
        return 0;
    }

    public String getHandName(int value) {
        switch (value) {
            case 8: return "Straight Flush";
            case 7: return "Four of a Kind";
            case 6: return "Full House";
            case 5: return "Flush";
            case 4: return "Straight";
            case 3: return "Three of a Kind";
            case 2: return "Two Pairs";
            case 1: return "Pair";
            default: return "High Card";
        }
    }
}
