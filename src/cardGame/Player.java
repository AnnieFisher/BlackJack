package cardGame;

public class Player {

	private String name;
	Hand hand;

	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}

}
