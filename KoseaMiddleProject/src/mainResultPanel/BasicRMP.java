package mainResultPanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import toolPack.ImageInput;

public class BasicRMP extends JPanel {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);
	
	public BasicRMP() {
		setBackground(BG); //
		setSize(420, 415); //setBound at 0, 85
		setLayout(null);
		
	}

}
