package View.JeuView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import Controler.GameController;
import Model.GameState;
import View.GameUserInt;

public class AwtInterface extends GameUserInt implements KeyListener {
	protected JFrame f;
	protected JeuInterface jeu;
	public AwtInterface(GameController gameController) {
		super(gameController);
		f = new JFrame();
		f.addKeyListener(this);
	}

	public void start(GameState state) {	
		
		jeu = new JeuInterface(state) ;
		f.add(jeu);
		f.setSize(state.getSizeFrame(), state.getSizeFrame());
		f.setResizable(false);
		f.setTitle("Jeu En Cour");
		f.setVisible(true);
		
	}
	public void step(GameState c) { jeu.step(c); }
	public void end() {f.setVisible(false);}
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar() == '-') {
			control.zoomOut();
		}
		if (arg0.getKeyChar() == '+') {
			control.zoomIn();
		}
		if (arg0.getKeyChar() == 'f') {
			control.speedUp();
		}
		if (arg0.getKeyChar() == 's') {
			control.speedDown();
		}
		if (arg0.getKeyChar() == 'q') {
			control.past();
		}
		if (arg0.getKeyChar() == 'w') {
			control.forward();
		}
	}

	
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyChar() == ' ') {
			control.pausePlay();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
