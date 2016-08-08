package cardGame;

public class PlayGame {

	public static void main(String[] args) {
		GameConsole game = new GameConsole();
		Deck deck = new Deck();

		game.displayMenu();

		game.Play();

	}

}
