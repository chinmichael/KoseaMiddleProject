package mainPack;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import toolPack.ImageInput;

public class MainAccountPanel extends JPanel {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);
	
	public MainAccountPanel() {
		
	}

	public MainAccountPanel(String Type) {
		setBackground(BG); //
		setSize(420, 500); //setBound at 40, 185
		setLayout(null);
		
		ImageIcon dayNormal = new ImageIcon("src\\mainIcon\\dayB1.jpg");
		ImageIcon dayAction = new ImageIcon("src\\mainIcon\\dayB2.jpg");
		ImageIcon monNormal = new ImageIcon("src\\mainIcon\\monthB1.jpg");
		ImageIcon monAction = new ImageIcon("src\\mainIcon\\monthB2.jpg");
		ImageIcon cntNormal = new ImageIcon("src\\mainIcon\\McheckB1.jpg");
		ImageIcon cntAction = new ImageIcon("src\\mainIcon\\McheckB2.jpg");
		
		
		if(Type.equals("¡°¿Â")) {
			
		} else {
			
		}

	}

}
