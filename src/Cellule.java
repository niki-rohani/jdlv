
public class Cellule {
	  public final short colonne;
	  public final short ligne;
	  
	  public Cellule( int colonne, int ligne ) {
		    this.colonne = (short)colonne;
		    this.ligne = (short)ligne;
	  }
	  
	  
	  public boolean equals(Object o) {
		    if (!(o instanceof Cellule) )
		      return false;
		    return colonne==((Cellule)o).colonne && ligne==((Cellule)o).ligne;
	  }
	  
	  public String toString() {
		    return "Cellule  ("+colonne+", "+ligne+")";
	  }
}
