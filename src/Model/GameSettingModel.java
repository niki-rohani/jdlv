package Model;

import java.util.ArrayList;

public class GameSettingModel {

	private byte zoomInit;
	private byte tailleView;
	private int[] grillOfRule;
	private int speed;
	private byte tailleTab;
	private boolean play;
	private byte nmbr;
	private boolean isPerso;
	
	public GameSettingModel() {
		zoomInit = 1;
		tailleView = 2;
		nmbr = 3;
		int [] grill = {0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0};
		grillOfRule = grill;
		speed = 2998;
		tailleTab = 4;
		play = true;
		isPerso = false;
	}
	
	public void newSettings(ArrayList<Object> settings) {
		zoomInit =  (Byte) settings.get(0);
		tailleView =  (Byte) settings.get(1);
		grillOfRule = (int[]) settings.get(2);
		speed =  (Integer) settings.get(3);
		tailleTab = (Byte) settings.get(4);
	}

	public ArrayList<Object> getSettings() {
		return null;
	}
	
	public String toString () {
		String s = "";
		s = zoomInit + " " + tailleView + " " + grillOfRule[1]+" " + grillOfRule[2]+" " + grillOfRule[3]+" " + grillOfRule[4]+" " + grillOfRule[5]+" " + grillOfRule[6]+" " + grillOfRule[7]+" " + grillOfRule[8] + " " + speed + " " + tailleTab ;
		return s;
	}

	public byte getZoomInit() {
		return zoomInit;
	}

	public void setZoomInit(int zoomInit) {
		this.zoomInit = (byte) zoomInit;
	}

	public byte getTailleView() {
		return tailleView;
	}

	public void setTailleView(int tailleView) {
		this.tailleView = (byte) tailleView;
	}

	public int[] getGrillOfRule() {
		return grillOfRule;
	}

	public void setGrillOfRule(int[] grillOfRule) {
		this.grillOfRule = grillOfRule;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 1)
		this.speed = 1;
		else
		this.speed = speed;
	}

	public int getTailleTab() {
		return tailleTab;
	}

	public void setTailleTab(int tailleTab) {
		this.tailleTab = (byte) tailleTab;
	}

	public void setPlay(boolean b) {
		play = b;
	}
	
	public boolean getPlay() {
		return play;
	}

	public int getNombre() {
		return nmbr;
	}
	
	public boolean isPerso() {
		return isPerso;
	}

	
}
