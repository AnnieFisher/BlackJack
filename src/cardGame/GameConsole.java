package cardGame;

import java.util.Scanner;

public class GameConsole {
	Deck deck = new Deck();
	Player player;
	Player dealer;
	String response;
	Scanner kb = new Scanner(System.in);

	public void displayMenu() {
		System.out.println("Welcome to the BlackJack Table");
		System.out.println("To play: Type Begin \nTo quit: Type Q");
		String response = kb.next();
		if (response.equalsIgnoreCase("Begin")) {
			enterPlayerName();
		} else if (response.equalsIgnoreCase("q")) {
			System.exit(0);
		} else {
			System.err.println("Unknown what to proceed with, please enter game again");
			System.exit(0);
		}
	}

	public void enterPlayerName() {
		System.out.println("Enter your name: ");
		String name = kb.next();
		Player player = new Player(name);
		System.out.println("Im excited you are joining us " + name + "! Let's Play!!!\n");
	}

	public void Play() {

		String name = "keyboard";
		Player player = new Player(name);
		Player dealer = new Player("dealer");
		int playerVal = player.hand.getValue();
		int dealerVal = dealer.hand.getValue();

		deck.shuffle();

		dealer.hand.addCard(deck.dealCard());
		deck.removeCard(deck.dealCard());
		player.hand.addCard(deck.dealCard());
		deck.removeCard(deck.dealCard());
		dealer.hand.addCard(deck.dealCard());
		deck.removeCard(deck.dealCard());
		player.hand.addCard(deck.dealCard());
		deck.removeCard(deck.dealCard());
		dealer.hand.displayHand();
		System.out.println("Dealer's hand value: " + dealer.hand.getValue());
		player.hand.displayHand();
		System.out.println("Your hand value: " + player.hand.getValue());

		if (playerVal == 21 || dealerVal == 21) {
			if (playerVal == 21) {
				System.out.println("BlackJack!!!! You win!!!");
			} else if (dealerVal == 21) {
				System.out.println("Dealer gets BlackJack! Sorry, You Lose!");
			}
		} else {
			while (playerVal < 22 || dealerVal < 22) {

				System.out.println("'Hit' or 'Stay': ");
				String hit = kb.next().toLowerCase();

				if (hit.equalsIgnoreCase("hit")) {
					player.hand.addCard(deck.dealCard());
					System.out.println("You got: " + deck.dealCard());
					deck.removeCard(deck.dealCard());
					System.out.println("Your hand is now: ");
					player.hand.displayHand();
					System.out.println("You have: " + player.hand.getValue() + "points");
					if (dealer.hand.getValue() > 21) {
						System.out.println("Dealer BUSTED, You WIN!!!!");
						System.exit(0);
					}

					if (player.hand.getValue() > 21) {
						System.out.println("Bust! Bummer, You are over 21! You lose");
						System.exit(0);
					}

					if (dealer.hand.getValue() == 21) {
						System.out.println("Dealer hits 21 and WINS!");
						System.exit(0);
					}

					if (player.hand.getValue() == 21) {
						System.out.println("BlackJack!!!!! You win!!!!!!");
						System.exit(0);
					}
					if (dealer.hand.getValue() >= 17) {
						System.out.println("Dealer must stay.");
					} else {
						dealer.hand.addCard(deck.dealCard());
						System.out.println("\nDealer got: " + deck.dealCard());
						deck.removeCard(deck.dealCard());
						System.out.println("Dealer has: " + dealer.hand.getValue() + " points");
						if (dealer.hand.getValue() > 21) {
							System.out.println("Dealer BUSTED, You WIN!!!!");
							System.exit(0);
						}

						if (player.hand.getValue() > 21) {
							System.out.println("Bust! Bummer, You are over 21! You lose");
							System.exit(0);
						}

						if (dealer.hand.getValue() == 21) {
							System.out.println("Dealer hits 21 and WINS!");
							System.exit(0);
						}

						if (player.hand.getValue() == 21) {
							System.out.println("BlackJack!!!!! You win!!!!!!");
							System.exit(0);
						}
					}
				}

				if (hit.equalsIgnoreCase("stay")) {
					System.out.println("\nYou chose to stay.");
					if (dealer.hand.getValue() >= 17 && dealer.hand.getValue() > player.hand.getValue()) {
						System.out.println("\nYou lose! Dealer is closer to 21!");
						System.exit(0);
					}
					if (dealer.hand.getValue() < 17) {
						dealer.hand.addCard(deck.dealCard());
						System.out.println("Dealer got: " + deck.dealCard());
						deck.removeCard(deck.dealCard());
						if (dealer.hand.getValue() > 21) {
							System.out.println("Bust! The dealer is over 21! You Win");
							System.exit(0);
						}

						if (player.hand.getValue() > 21) {
							System.out.println("Bust! You're over 21! You lose");
							System.exit(0);
						}

						if (dealer.hand.getValue() == 21) {
							System.out.println("Dealer hit 21! You lose!");
							System.exit(0);
						}

						if (player.hand.getValue() == 21) {
							System.out.println("BlackJack! You win!");
							System.exit(0);
						}
						System.out.println("Dealer's hand value: " + dealer.hand.getValue());
						System.out.println("");
						System.out.println("Your hand: ");
						player.hand.displayHand();
						System.out.println("Your hand value: " + player.hand.getValue());
					} else {
						System.out.println("\nYou win!");
						System.exit(0);
					}
				}
			}
		}
	}
}
