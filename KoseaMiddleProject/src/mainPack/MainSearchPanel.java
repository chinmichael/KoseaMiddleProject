package mainPack;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import toolPack.ImageInput;
import javax.swing.JButton;

public class MainSearchPanel extends JPanel {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);

	public MainSearchPanel() {
		setBackground(BG); //
		setSize(420, 70); //setBound at 40, 185
		setLayout(null);
		
		ImageIcon searchSNormal = new ImageIcon("src\\mainIcon\\searchSB1.jpg");
		ImageIcon searchSAction = new ImageIcon("src\\mainIcon\\searchSB2.jpg");
		ImageIcon insertSNormal = new ImageIcon("src\\mainIcon\\insertSB1.jpg");
		ImageIcon insertSAction = new ImageIcon("src\\mainIcon\\insertSB2.jpg");
		ImageIcon searchPNormal = new ImageIcon("src\\mainIcon\\searchPB1.jpg");
		ImageIcon searchPAction = new ImageIcon("src\\mainIcon\\searchPB2.jpg");
		ImageIcon insertPNormal = new ImageIcon("src\\mainIcon\\insertPB1.jpg");
		ImageIcon insertPAction = new ImageIcon("src\\mainIcon\\insertPB2.jpg");
		
		JButton searchSB = new JButton();
		searchSB.setBounds(15, 0, 60, 60);
		imageEdit.setButtonImage(searchSB, searchSNormal, searchSAction);
		add(searchSB);
		
		JButton insertSB = new JButton();
		insertSB.setBounds(125, 0, 60, 60);
		imageEdit.setButtonImage(insertSB, insertSNormal, insertSAction);
		add(insertSB);
		
		JButton searchPB = new JButton();
		searchPB.setBounds(235, 0, 60, 60);
		imageEdit.setButtonImage(searchPB, searchPNormal, searchPAction);
		add(searchPB);
		
		JButton insertPB = new JButton();
		insertPB.setBounds(345, 0, 60, 60);
		imageEdit.setButtonImage(insertPB, insertPNormal, insertPAction);
		add(insertPB);
		
		

	}

}
