package cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>(52);{
	

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
	}

	void shuffle() {
		Collections.shuffle(deck);
	}

	Card dealCard() {
		return deck.get(0);
	}

	void removeCard(Card card) {
		deck.remove(card);
	}
}
