package Model;

public class GameReport {

	private GameState state;
	private GameHistory history;
	
	public GameReport(GameState state, GameHistory history) {
		this.state = state;
		this.history = history;
	}

}
