import java.util.ArrayList;

import View.MainViewInterface;
import View.ViewInterface;
import View.MainView.MainView;

import Controler.MainControler;

public class Main {

	
	
	public static void main(String []args){

	    MainControler controler = new MainControler ();
		MainViewInterface userInterface = new MainView (controler);
		
		controler.setInterface(userInterface);
		controler.display(); 
	}
}
