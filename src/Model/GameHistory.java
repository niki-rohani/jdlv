package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GameHistory {

	private GrilleCellule[] tab;
	private int step;
	private String NomFichier = "tmp.tmp";
	private byte currentStep;
	private byte memoryLimit;
	
	public GameHistory (GameState state) {
		step = 0;
		File f = new File(NomFichier);
		f.delete();
		tab = new GrilleCellule[100];
		currentStep = 0;
		memoryLimit = 100;
	}
	
	public void addStep(GameState state) {
		if(currentStep<memoryLimit - 1) {
			GrilleCellule c = new GrilleCellule();
		    c.copy (state.getTabOfGame());
			tab[currentStep] = c;
		}
		else {
		  try{
			  currentStep = 0;
			  GrilleCellule c = new GrilleCellule();
			  c.copy (state.getTabOfGame());
		      PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter(NomFichier, true)));
		      for (int i = 0; i<tab.length; i++)
		      out.print(tab[i] + "\n");
		      out.print(c + "\n");
		      out.flush();
		      out.close();
		    }
		    catch(Exception e){
		      e.printStackTrace();
		    }
		}
		step++;
		currentStep++;
	}

	public GrilleCellule get(int i) {
		if (step - i > currentStep ) {
			GrilleCellule c = new GrilleCellule();
	    try{
	      BufferedReader in  = new BufferedReader(new FileReader(NomFichier));
	      String line;
	      int it = 0;
	      while ((line = in.readLine()) != null) {
	    	  if (it == i) {
	    		  c.load(line);
	    		  break;
	    	  }
	    	  else
	    		  it++;
	      }
	      in.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
		return c ;
		}
		else {
			return tab[i - ( step - currentStep ) ];
		}
	}

	public int getNumberOfStep() {
		return step;
	}
	
	public void clear (int step) {
		 PrintWriter out;
 		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("tmp", true)));
			PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter(NomFichier, true)));
			BufferedReader in;
			in = new BufferedReader(new FileReader(NomFichier));
			for (int i = 0; i<step; i++) {
				out.println(in.readLine());
			} 
			out.flush();
			out.close();
			outf.close();
			in.close();
			File f = new File (NomFichier);
			f.delete();
			in = new BufferedReader(new FileReader("tmp"));
			for (int i = 0; i<step; i++) {
				outf.println(in.readLine());
				outf.flush();
				outf.close();
			} 
			in.close();
			f = new File ("tmp");
			f.delete();
			
		} catch (IOException e) {
		}
		this.step = step;
		System.out.println("STEP : " + step);
	}

}
