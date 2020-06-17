package mainPack;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import toolPack.ImageInput;

public class MainAccountPanel extends JLayeredPane {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);
	
	public MainAccountPanel() {
		
	}

	public MainAccountPanel(String Type) {
		setBackground(BG); //
		setSize(420, 500); //setBound at 40, 185
		setLayout(null);
		
		ImageIcon passNormal = new ImageIcon("src\\mainIcon\\passCB1.jpg");
		ImageIcon passAction = new ImageIcon("src\\mainIcon\\passCB2.jpg");
		ImageIcon phoneNormal = new ImageIcon("src\\mainIcon\\phoneCB1.jpg");
		ImageIcon phoneAction = new ImageIcon("src\\mainIcon\\phoneCB2.jpg");
		ImageIcon outNormal = new ImageIcon("src\\mainIcon\\outB1.jpg");
		ImageIcon outAction = new ImageIcon("src\\mainIcon\\outB2.jpg");
		
		JButton passChange = new JButton();
		passChange.setBounds(15, 0, 60, 60);
		imageEdit.setButtonImage(passChange, passNormal, passAction);
		add(passChange);
		
		JButton phoneChange = new JButton();
		phoneChange.setBounds(180, 0, 60, 60);
		imageEdit.setButtonImage(phoneChange, phoneNormal, phoneAction);
		add(phoneChange);
		
		JButton accountOut = new JButton();
		accountOut.setBounds(345, 0, 60, 60);
		imageEdit.setButtonImage(accountOut, outNormal, outAction);
		add(accountOut);
		
		
		if(Type.equals("¡°¿Â")) {
			ImageIcon shopNormal = new ImageIcon("src\\mainIcon\\shopCB1.jpg");
			ImageIcon shopAction = new ImageIcon("src\\mainIcon\\shopCB2.jpg");
			ImageIcon rankNormal = new ImageIcon("src\\mainIcon\\rankCB1.jpg");
			ImageIcon rankAction = new ImageIcon("src\\mainIcon\\rankCB2.jpg");
			
			JButton shopChange = new JButton();
			shopChange.setBounds(97, 0, 60, 60);
			imageEdit.setButtonImage(shopChange, shopNormal, shopAction);
			add(shopChange);
			
			JButton rankChange = new JButton();
			rankChange.setBounds(262, 0, 60, 60);
			imageEdit.setButtonImage(rankChange, rankNormal, rankAction);
			add(rankChange);
			
		}

	}

}
