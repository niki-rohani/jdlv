package View;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Controler.GameController;
import Model.GameState;
import javax.swing.JFrame;
import Model.GameState;

public abstract class GameUserInt {
	protected GameController control;
	public GameUserInt(GameController control) { this.control = control; }
	public void start(GameState state) {}
	public void step(GameState s) {
		int i = 0;
		new Thread () {
		i++;
	};}
	public void end() {}
}
