package mainPack;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import toolPack.*;
import loginPack.*;
import popUpPack.ReturnLogin;

public class MainHome extends JFrame {

	Container contentP = getContentPane();
	ImageInput imageEdit = new ImageInput();
	MainHomePanel mhp = new MainHomePanel();

	public static void main(String[] args) {

				try {
					MainHome frame = new MainHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public void openMainHome() {
		MainHome frame = new MainHome();
		frame.setVisible(true);
	}

	public MainHome() {
		setSize(500, 700);
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(500), st.setCenterY(700) - 40);
		setUndecorated(true);
		contentP.setLayout(null);
		addMouseMotionListener(new MouseDragMove());
		
		ImageIcon backImage = new ImageIcon("src\\mainIcon\\BG1.jpg");
		JPanel background = imageEdit.panelPaint(backImage);
		background.setBounds(0, 0, 500, 700);
		
		ImageIcon xNormal = new ImageIcon("src\\mainIcon\\mainXB1.jpg");
		ImageIcon xAction = new ImageIcon("src\\mainIcon\\mainXB2.jpg");
		
		JButton xButton = new JButton();
		xButton.setBounds(470, 9, 20, 19);
		imageEdit.setButtonImage(xButton, xNormal, xAction);
		contentP.add(xButton);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				ReturnLogin rl = new ReturnLogin();
//				rl.printMsg();
//				
//				if(rl.getFlg()) {
//					dispose();
//				}
				
				System.exit(0);
			}
		});
		
		mhp.setBounds(40, 180, 420, 500);
		contentP.add(mhp);
		mhp.setVisible(true);
		
		ImageIcon homeNormal = new ImageIcon("src\\mainIcon\\homeB1.jpg");
		ImageIcon homeAction = new ImageIcon("src\\mainIcon\\homeB2.jpg");
		ImageIcon disuseNormal = new ImageIcon("src\\mainIcon\\disB1.jpg");
		ImageIcon disuseAction = new ImageIcon("src\\mainIcon\\disB2.jpg");
		ImageIcon searchNormal = new ImageIcon("src\\mainIcon\\searchB1.jpg");
		ImageIcon searchAction = new ImageIcon("src\\mainIcon\\searchB2.jpg");
		ImageIcon accountNormal = new ImageIcon("src\\mainIcon\\accChB1.jpg");
		ImageIcon accountAction = new ImageIcon("src\\mainIcon\\accChB2.jpg");
		
		JButton homeButton = new JButton();
		homeButton.setBounds(60, 85, 55, 55);
		imageEdit.setButtonImage(homeButton, homeNormal, homeAction);
		contentP.add(homeButton);
		
		JButton disButton = new JButton();
		disButton.setBounds(168, 86, 55, 55);
		imageEdit.setButtonImage(disButton, disuseNormal, disuseAction);
		contentP.add(disButton);
		
		JButton searchButton = new JButton();
		searchButton.setBounds(276, 85, 55, 55);
		imageEdit.setButtonImage(searchButton, searchNormal, searchAction);
		contentP.add(searchButton);
		
		JButton accountButton = new JButton();
		accountButton.setBounds(385, 85, 55, 55);
		imageEdit.setButtonImage(accountButton, accountNormal, accountAction);
		contentP.add(accountButton);
		
		ImageIcon menuBG = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel menuBar = new JLabel("New label");
		menuBar.setBounds(40, 75, 420, 75);
		imageEdit.setPaintLabel(menuBar, menuBG);
		contentP.add(menuBar);
		
		contentP.add(background);
		
	}
	
	public void openHomePanel() {
		
	}
}
