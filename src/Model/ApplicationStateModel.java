package Model;

public class ApplicationStateModel {

	
	int gameState;
	public ApplicationStateModel() {
		gameState = 0;
	}
	
	public void GameOn() {
		gameState = 1;
	}
	
	public void GameOff() {
		gameState = 0;
	}
	
}
