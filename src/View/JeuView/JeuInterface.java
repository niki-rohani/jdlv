package View.JeuView;

import java.awt.*;
import javax.swing.*;

import Model.GameState;

public class JeuInterface extends JPanel {
	
	private GameState st;
	
	public JeuInterface (GameState st) {
		this.st = new GameState();
		this.st.copy(st);
		
		
	}
	
	public void step (GameState st) {
		try {
			 Thread.sleep(3000 - st.getSpeed());
		} catch (InterruptedException e) {} 
		this.st.copy(st);
		this.repaint();
	}
	
	public void paint(Graphics g) {
		g.clearRect(0,0,g.getClipBounds().width,g.getClipBounds().height);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,g.getClipBounds().width,g.getClipBounds().height);
		g.drawString(st.getSpeed()+"", 10, 10);
		g.setColor(Color.white);
		paintCells(g);
		
		 // paintGrill(g);
		paintState(g);
	}
	
	public void paintGrill(Graphics g) {
		double ecart =  ( st.getSizeFrame() - 30 ) / st.getSizeTab() ;
		for (int i = 0; i <= st.getSizeTab(); i++) {
			g.drawLine((int)(i*ecart), 0, (int)(i*ecart), (int) ( (st.getSizeTab()) * ecart ) );
			g.drawLine((int)(i*ecart)+1, 0, (int)(i*ecart)+1,   (int) ( (st.getSizeTab()) * ecart ) );
		}
		
		for (int i = 0; i <= st.getSizeTab(); i++) {
			g.drawLine(0, (int)(i*ecart),  (int) ( (st.getSizeTab()) * ecart ) ,  (int)(i*ecart));
			g.drawLine(0, (int)(i*ecart)+1,  (int) ( (st.getSizeTab()) * ecart ) , (int)(i*ecart)+1);
		}
		
	}
	
	public void paintState(Graphics g) {
		double ecart =  ( st.getSizeFrame() - 30 ) / st.getSizeTab() ;
		g.drawString("Speed : " + st.getSpeed(), st.getSizeFrame() / 20, (int) ( (st.getSizeTab()) * ecart )) ;
		g.drawString("Zoom : ", st.getSizeFrame() / 3, (int) ( (st.getSizeTab()) * ecart )) ;
		g.drawString("Generation : " + st.getStep(), (int) ( st.getSizeFrame() / 1.5 ) , (int) ( (st.getSizeTab()) * ecart )) ;
		
		
		
		g.drawString("K ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 20) ;
		g.drawString("E ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 20 +10);
		g.drawString("Y ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 20 +20);
		g.drawString("S ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 20 +30);
		
		g.drawString("Z ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 5) ;
		g.drawString("O ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 5 +10);
		g.drawString("O ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 5 +20);
		g.drawString("M ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 5 +30);
		
		g.drawString("S ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2) ;
		g.drawString("P ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2 +10);
		g.drawString("E ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2 +20);
		g.drawString("E ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2 +30);
		g.drawString("D ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2 +40);
		
		g.setColor(Color.RED);
		
		g.drawString("+ ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 5 + 50) ;
		g.drawString("- ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 5 +70);
		
		g.drawString("F ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2 +60);
		g.drawString("S ", (int) ( (st.getSizeTab()) * ecart ) + 10, st.getSizeFrame() / 2 +80);
		
	}
	
	public void paintCells(Graphics g) {
		double ecart =  ( st.getSizeFrame() - 30 ) / st.getSizeTab() ;
		for (int i=0;i<st.getSizeTab();i++) {
			for (int j=0;j<st.getSizeTab();j++) {
				if  (st.getTabOfGame().getCellule(i, j) == 0) g.setColor(Color.BLACK);
				if  (st.getTabOfGame().getCellule(i, j) == 1) g.setColor(Color.YELLOW);
				if  (st.getTabOfGame().getCellule(i, j) == 2) g.setColor(Color.ORANGE);
				if  (st.getTabOfGame().getCellule(i, j) == 3) g.setColor(Color.RED);
				g.fillRect((int)(i*ecart),  (int)(j*ecart), (int)(ecart), (int)(ecart));
				
			}
		}
		g.setColor(Color.BLACK);
	}

}
