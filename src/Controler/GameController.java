package Controler;

/**
 * Classe Controller
 * Prends en entree le state, est un tread, et controlle la boucle de jeu, fait la com entre
 * le model et la vue;
 * A chaque etape, on incremente le step, sauf si on met en pause, on test si on doit avancer
 * reculer ou aller a la fin. On appelle les fonction du model, et on informe la vue .step()
 * 
 * @author Danti.
 */

import Model.Tool;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Model.GameHistory;
import Model.GameReport;
import Model.GameState;
import Model.GrilleCellule;
import View.GameUserInt;
import View.JeuView.AwtInterface;

public class GameController extends Thread {

	// Le state de jeu
	private GameState GameState;
	// La vue
	private GameUserInt userInterface;
	// L'historique de jeu
	private GameHistory history;
	// statut
	private byte statut;

	public GameController() {

	}

	public GameController(GameState setting) {
		this.GameState = setting;
		history = new GameHistory(setting);
		userInterface = new AwtInterface(this);
		statut = 1;
	}

	public void run() {

		// On demarre la vue
		userInterface.start(GameState);
		// On procede a l'affiche du premier etat de jeu
		userInterface.step(GameState);
		// On ajoute l'etat a l'historique
		history.addStep(GameState);
		try {Thread.sleep(300);} catch (InterruptedException e1) {e1.printStackTrace();}

		// boucle de jeu
		while(true) {
			if (GameState.isPlay()) {
				try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();
				}
				// Si on doit revenir en arriere
				if (statut==3) {
					// Si l'etat de jeu est superieur a 0
					if (GameState.getStep() > 0) {
						// On copie la table pour ne pas perturber le la vrai table
						GrilleCellule tab = new GrilleCellule();
						// On recupere la table historique
						tab.copy(history.get(GameState.getStep() - 1)) ;
						GameState.setTabOfGame(tab);
						tab = null;

						// Step la vue
						userInterface.step(GameState);

						GameState.setStep(GameState.getStep() - 1);
					}
					// Si l'etat de jeu est a 0 on fait pause
					else {
						pause();
					}
				} 
				// Si on doit remettre le dernier etat en memoire
				else  if (statut==2) {
					// Si l'etat de l'historique est superieur a l'etat
					if ((history.getNumberOfStep() > GameState.getStep())) {
						// On recupere le dernier etat
						GameState.setTabOfGame(history.get(history.getNumberOfStep() - 1));
						GameState.setStep(history.getNumberOfStep());

						// Step la vue
						userInterface.step(GameState);
						statut = 1;
					}
					// Si l'etat de l'historique n'est pas superieur a l'etat act
					else {
						pause();
					}
				}
				// Si on doit jouer
				else if (statut==1) {

					// On utilise calcul la nouvel table
					GrilleCellule tab = new GrilleCellule();
					tab.copy(Tool.tabAction(GameState)) ;
					// Si la table recu a rate on fait pause
					if (tab.getDimension()<1) {
						pause();
					}
					else {
						// On met la nouvelle table dans la table de state
						GameState.setTabOfGame(tab);
						tab = null;
						GameState.setStep(GameState.getStep()+1);
						// On ajoute l'etat a l'historique
						history.addStep(GameState);
						// Vue
						userInterface.step(GameState);

					}

				}
				// Pause
				else {
					try {Thread.sleep(30);} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					userInterface.step(GameState);
				}
			}
		}
	}

	public GameReport end() {
		userInterface.end();
		System.out.print("END");
		return new GameReport (GameState, history);
	}

	public void zoomOut() {
		GameState.zoomOut();
	}
	public void zoomIn() {
		GameState.zoomIn();
	}
	public void speedUp() {
		GameState.speedUp();
	}
	public void speedDown() {
		GameState.speedDown();
	}
	public void pausePlay(){
		if (statut==3 || GameState.getStep() == 0) {
			history.clear(GameState.getStep());
		}
		if (statut==1)
			statut=0;
		else
			statut=1;
	}
	public void pause() {
		statut = 0;
	}

	public void past() {
		statut = 3;

	}

	public void forward() {
		statut = 2;
	}


}
