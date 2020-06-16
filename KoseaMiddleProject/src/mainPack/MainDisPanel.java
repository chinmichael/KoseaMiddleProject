package mainPack;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import toolPack.ImageInput;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainDisPanel extends JPanel {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);

	public MainDisPanel() {
		setBackground(BG); //
		setSize(420, 70); //setBound at 40, 185
		setLayout(null);
		
		ImageIcon dayNormal = new ImageIcon("src\\mainIcon\\dayB1.jpg");
		ImageIcon dayAction = new ImageIcon("src\\mainIcon\\dayB2.jpg");
		ImageIcon monNormal = new ImageIcon("src\\mainIcon\\monthB1.jpg");
		ImageIcon monAction = new ImageIcon("src\\mainIcon\\monthB2.jpg");
		ImageIcon cntNormal = new ImageIcon("src\\mainIcon\\McheckB1.jpg");
		ImageIcon cntAction = new ImageIcon("src\\mainIcon\\McheckB2.jpg");
		
		
		JButton disDayCheck = new JButton();
		disDayCheck.setBounds(15, 0, 60, 60);
		imageEdit.setButtonImage(disDayCheck, dayNormal, dayAction);
		add(disDayCheck);
		
		JButton disMonthCheck = new JButton();
		disMonthCheck.setBounds(180, 0, 60, 60);
		imageEdit.setButtonImage(disMonthCheck, monNormal, monAction);
		add(disMonthCheck);
		
		JButton disMonthCount = new JButton();
		disMonthCount.setBounds(345, 0, 60, 60);
		imageEdit.setButtonImage(disMonthCount, cntNormal, cntAction);
		add(disMonthCount);
	}
}
