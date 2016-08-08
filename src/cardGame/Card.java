package cardGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Card {
	private Rank rank;
	private Suit suit;
	private int value;

	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
		Map<Rank, Integer> values = new HashMap<>();
		
		values.put(Rank.TWO, 2);
		values.put(Rank.THREE, 3);
		values.put(Rank.FOUR, 4);
		values.put(Rank.FIVE, 5);
		values.put(Rank.SIX, 6);
		values.put(Rank.SEVEN, 7);
		values.put(Rank.EIGHT, 8);
		values.put(Rank.NINE, 9);
		values.put(Rank.TEN, 10);
		values.put(Rank.JACK, 10);
		values.put(Rank.QUEEN, 10);
		values.put(Rank.KING, 10);
		values.put(Rank.ACE, 11);

		Set<Rank> keySet = values.keySet();
		for (Rank key : keySet) {
			if (key == r) {
				this.value = values.get(key);
			}
		}
	}

	int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return (rank + " of " + suit).toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}