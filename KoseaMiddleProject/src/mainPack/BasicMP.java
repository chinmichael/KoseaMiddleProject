package mainPack;

import java.awt.Color;


import javax.swing.JLayeredPane;
import javax.swing.plaf.ColorUIResource;
import toolPack.ImageInput;

public class BasicMP extends JLayeredPane {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);
	
	public BasicMP() {
		setBackground(BG); //
		setSize(420, 500); //setBound at 40, 185
		setLayout(null);
	}

}
