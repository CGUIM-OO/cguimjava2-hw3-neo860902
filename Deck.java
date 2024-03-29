import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed;

	public Deck(int nDeck) {
		usedCard = new ArrayList<Card>();
		cards = new ArrayList<Card>();

		cards = new ArrayList<Card>();

		for (int n = 1; n <= nDeck; n++) {
			for (int s = 1; s <= 4; s++) {
				for (int r = 1; r <= 13; r++) {
					if (s == 1) {
						Card card = new Card(Card.Suit.Clubs, r);
						cards.add(card);
					}
					if (s == 2) {
						Card card = new Card(Card.Suit.Diamonds, r);
						cards.add(card);
					}
					if (s == 3) {
						Card card = new Card(Card.Suit.Hearts, r);
						cards.add(card);
					}
					if (s == 4) {
						Card card = new Card(Card.Suit.Spades, r);
						cards.add(card);
					}
				}
			}
		}
		shuffle();
	}

	public void printDeck() {

		for (int n = 0; n < cards.size(); n++) {
			cards.get(n).printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	public Card getOneCard() {
		nUsed += 1;
		// TODO Auto-generated method stub
		if (nUsed == 52) {
			shuffle();
		}

		usedCard.add(cards.get(nUsed));
		return cards.get(nUsed);
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < 52; i++) {
			int j = random.nextInt(51);
			Card newcard;
			newcard = cards.get(j);

			cards.set(j, cards.get(i));
			cards.set(i, newcard);
		}

		nUsed = 0;
		usedCard.clear();
	}
}
