

import java.util.ArrayList;

public class GameSettingModel {

	private int zoomInit;
	private int tailleView;
	private int[] grillOfRule;
	private int speed;
	private int tailleTab;
	
	public GameSettingModel() {
		zoomInit = 1;
		tailleView = 2;
		int [] grill = {0,0,0,1,1,1,0,0};
		grillOfRule = grill;
		speed = 1;
		tailleTab = 2;
	}
	
	public void newSettings(ArrayList<Object> settings) {
		zoomInit =  (Integer) settings.get(0);
		tailleView =  (Integer) settings.get(1);
		grillOfRule = (int[]) settings.get(2);
		speed =  (Integer) settings.get(3);
		tailleTab = (Integer) settings.get(4);
	}

	public ArrayList<Object> getSettings() {
		return null;
	}
	
	public String toString () {
		String s = "";
		s = zoomInit + " " + tailleView + " " + grillOfRule[1]+" " + grillOfRule[2]+" " + grillOfRule[3]+" " + grillOfRule[4]+" " + grillOfRule[5]+" " + grillOfRule[6]+" " + grillOfRule[7]+" " + grillOfRule[8] + " " + speed + " " + tailleTab ;
		return s;
	}

	
}
