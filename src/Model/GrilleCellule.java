package Model;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Enumeration;


public class GrilleCellule {
	
	private ArrayList<Integer> tab;
	
	
	public GrilleCellule() {
		tab = new ArrayList<Integer>();
	}
	
	public void setTab(ArrayList <Integer> tab) {
		this.tab.clear();
		this.tab.addAll(tab);
	}
	public int getCellule(int line,int colonne) {
		return tab.get(colonne + line*getDimension() );
	}
		
	/*
	 *  modifie le statut de la cellule
	 */
	public void setCellule( int colonne, int row, int cellule) {
		tab.set(colonne*getDimension() + row, cellule);
	}
	
	/*
	 *  renvoi la dimension dela grille
	 */
	public int getDimension() {
		return (int) Math.sqrt(tab.size());
	}

	public void clear() {
		tab.clear();
	}

	public int checkArround(int i, int j, int[] grillOfRule, boolean isPerso) {
			if (isPerso) {
		if (getCellule(i,j) == 0){
			if (getCellule(i-1,j-1) == grillOfRule[0]){
				if (getCellule(i,j-1) == grillOfRule[1]){
					if (getCellule(i+1,j-1) == grillOfRule[2]){
						if (getCellule(i-1,j) == grillOfRule[3]){
							if (getCellule(i+1,j) == grillOfRule[4]){
								if (getCellule(i-1,j+1) == grillOfRule[5]){
									if (getCellule(i,j+1) == grillOfRule[6]){
										if (getCellule(i+1,j+1) == grillOfRule[7]){
											return 1;
			}}}}}}}}
		}
		if (getCellule(i,j) == 1){
			if (getCellule(i-1,j-1) == grillOfRule[8]){
				if (getCellule(i,j-1) == grillOfRule[9]){
					if (getCellule(i+1,j-1) == grillOfRule[10]){
						if (getCellule(i-1,j) == grillOfRule[11]){
							if (getCellule(i+1,j) == grillOfRule[12]){
								if (getCellule(i-1,j+1) == grillOfRule[13]){
									if (getCellule(i,j+1) == grillOfRule[14]){
										if (getCellule(i+1,j+1) == grillOfRule[15]){
											return 0;
			}}}}}}}}}
			return getCellule(i,j);
			}
			else {
					int c = getCellule(i,j);
					if (c == 3) {
						c = -1;
					}
					int nmbr = 0;
					if (getCellule(i-1,j-1) == c + 1) nmbr++;
					if (getCellule(i,j-1) == c + 1) nmbr++;
					if (getCellule(i+1,j-1) == c + 1) nmbr++;
					if (getCellule(i-1,j) == c + 1) nmbr++;
					if (getCellule(i+1,j) == c + 1) nmbr++;
					if (getCellule(i-1,j+1) == c + 1) nmbr++;
					if (getCellule(i,j+1) == c + 1) nmbr++;
					if (getCellule(i+1,j+1) == c + 1 ) nmbr++; 
					if (nmbr >= 3) return c + 1;
					return getCellule(i,j);
			}
	}
	
	public void copy(GrilleCellule tabb) {
		this.tab.clear();
		for(int i=0; i<tabb.getDimension()*tabb.getDimension(); i++){
			this.tab.add(tabb.getCellule(i));
		}
	}
	
	public int getCellule(int i) {
		return tab.get(i);
	}
	
	public String toString() {
		return tab  + "" ;
	}
	
	public void load (String s) {
		tab.clear();
		String load = "";
		for (int i=0 ; i<s.length(); i++) {
			if (s.substring(i,i+1).equals(",") || s.substring(i,i+1).equals("]")) {
				tab.add(Integer.parseInt(load));
				load = "";
			}
			else if (s.substring(i,i+1).equals(" ")) {	}
			else if (s.substring(i,i+1).equals("[")) {	}
			else {
				load = load + s.substring(i, i+1);
			}
		}
	}
	

}
