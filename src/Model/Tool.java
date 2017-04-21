package Model;

import java.util.ArrayList;

public class Tool {

	public static GrilleCellule tabAction(Model.GameState gameState) {
		GrilleCellule array = new GrilleCellule(); 
		GrilleCellule rTab = new GrilleCellule();
		array.copy(gameState.getTabOfGame());
		rTab.copy(gameState.getTabOfGame());
		
		if (gameState.isPlay()) {
		for (int i=1; i<array.getDimension() - 1; i++) {
			for (int j=1; j<array.getDimension() - 1; j++) {
				 rTab.setCellule(i, j, array.checkArround(i,j,gameState.getParameters().getGrillOfRule(), false) ) ;
			}
		}
		return rTab;
		}
		
		else {
			for (int i=1; i<array.getDimension() - 1; i++) {
				for (int j=1; j<array.getDimension() - 1; j++) {
					 rTab.setCellule(i, j, array.checkArround(i,j,gameState.getParameters().getGrillOfRule(), true) ) ;
				}
			}
		}
		return rTab;
		
	}

}
