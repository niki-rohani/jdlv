package Model;

import java.util.ArrayList;

public class GameState {

	GameSettingModel parameters;
	private int step;
	private GrilleCellule tabOfGame;
	
	public GameState () {
		step = 0;
		tabOfGame = new GrilleCellule();
		ArrayList<Integer> array = new ArrayList<Integer> ();
		for (int i = 0; i<160 ; i++){
			for (int j = 0; j<160; j++) {
				double hasard = Math.random();
				if (hasard < 0.20 )
				array.add(0);
				else if (hasard < 0.40 )
				array.add(1);
				else if (hasard < 0.60 )
				array.add(2);
				else
				array.add(3);
			}
		}
		tabOfGame.setTab(array);
		
	}
	
	public int get (int x, int y) {
		return tabOfGame.getCellule(x, y);
	}
	
	public void loadTab (ArrayList<Integer> t) {
		tabOfGame.setTab(t);
	}
	
	public void loadSetting(GameSettingModel settings) {
		parameters = settings;
	}

	public void setTabOfGame(GrilleCellule grilleCellule) {
		tabOfGame.copy(grilleCellule) ;
	}
	
	public String toString () {
		String s = "";
		s = parameters + " ";
		
		return s;
	}
	
	public void load(String serial) {
		
	}

	public GameSettingModel getParameters() {
		return parameters;
	}
	
	public int getSizeTab() {
		return (int) Math.pow(2,parameters.getTailleTab()-1) * 10;
	}
	
	public int getSizeFrame() {
		return 300 + 100 * ( parameters.getTailleView() - 1 );
	}

	public GrilleCellule getTabOfGame() {
		return tabOfGame;
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(int i) {
		step = i;
		
	}


	public void zoomOut() {
		if ((parameters.getZoomInit()-5)<1);
		parameters.setZoomInit(parameters.getZoomInit()-5);
		
	}
	
	public void zoomIn() {
		parameters.setZoomInit(parameters.getZoomInit()+5);
	}
	
	public void speedUp() {
		parameters.setSpeed(parameters.getSpeed()+5);
	}
	
	public void speedDown() {
		if (parameters.getSpeed()!=0)
		parameters.setSpeed(parameters.getSpeed()-5);
	}


	public void playPause() {
		parameters.setPlay(!(parameters.getPlay()));
	}


	public void pause() {
		parameters.setPlay(false);
	}
	
	public boolean isPlay() {
		return parameters.getPlay();
	}
	
	public int getSpeed() {
		return parameters.getSpeed();
	}

	
	public void copy(GameState state) {
		this.step = state.getStep();
		this.tabOfGame.copy(state.getTabOfGame());
		this.parameters = state.getParameters();
	}
	
	

}
