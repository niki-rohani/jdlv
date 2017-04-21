package View.JeuView;

import java.awt.event.KeyEvent;

public class Listener {
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyChar() == '-') {
			control.zoomOut();
			System.out.println("Control");
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
		if (arg0.getKeyChar() == ' ') {
			control.pausePlay();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
