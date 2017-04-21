package View.MainView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import Controler.MainControler;
import View.MainViewInterface;

public class MainView extends MainViewInterface {

	
	private MainControler controler;
	
	public MainView(MainControler controler) {
		this.controler = controler;
	}

	public void start () {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		JFrame f = new JFrame();
		f.setSize(500, 200);
		f.setTitle("JDLV");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	
}
