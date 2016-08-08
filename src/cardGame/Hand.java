package cardGame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> hand = new ArrayList<>();

	void addCard(Card card) {
		hand.add(card);
	}

	void displayHand() {
		for (Card card : hand) {
			System.out.println(card);
		}
	}

	int getValue() {
		int value = 0;
		for (Card card : hand) {
			value = value + card.getValue();
		}
		return value;
	}
}
