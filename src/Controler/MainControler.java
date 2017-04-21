package Controler;

import java.util.ArrayList;

import Model.ApplicationStateModel;
import Model.GameReport;
import Model.GameSettingModel;
import Model.GameState;
import View.MainViewInterface;

public class MainControler {

	private GameSettingModel settings; // les parametres de jeu
	private ApplicationStateModel applicationState; // etat de l'application
	
	private MainViewInterface mainInterface; // l'interface graphique de l'application
	private GameController game; // controlleur de jeu
	private GameState gameState; // etat du jeu
	private GameReport report;
	
	public MainControler() {
		this.mainInterface = null;
		settings = new GameSettingModel();
		applicationState = new ApplicationStateModel();
		gameState = new GameState();
		report = new GameReport(null,null);
	}
	
	public void setInterface (MainViewInterface mainInterface) {
		this.mainInterface = mainInterface;
		
	}
	
	/*^^^^^^^^^^^^^^^^^^^^^^^^^
	 * lancement du jeu
	 */
	public void display() {
		mainInterface.start();
		GameController e = startNewGame();
	}
	
	/*
	 * modification des parametres du jeu
	 * Prend un arrayList qui va correspondre à tous les parametres
	 * et on met a jour
	 */
	public void changeGameSettings(ArrayList<Object> settings) {
		this.settings.newSettings(settings);
	}
	
	/*
	 * recuperation des parametres du jeu
	 */
	public ArrayList<Object> getGameSettings() {
		return settings.getSettings();
	}
	
	
	public GameController startNewGame() {
		gameState.loadSetting(settings);
		game = new GameController(gameState);
		game.start();
		applicationState.GameOn();
		return game;
	}
	
	public void endGame(GameState state) {
		this.gameState = state;
		report = game.end();
		game.interrupt();
		applicationState.GameOff();
	}
	
}
