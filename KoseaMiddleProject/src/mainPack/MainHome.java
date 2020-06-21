package mainPack;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import connPack.AccountDB;
import toolPack.*;
import loginPack.*;
import popUpPack.ReturnLogin;

public class MainHome extends JFrame {
	
	AccountDB ad = new AccountDB();
	String Type = ad.getUtype();
//	String Type = ""; // 확인작업용
//	String Type = "점장"; //확인작업용2
	
	Container contentP = getContentPane();
	ImageInput imageEdit = new ImageInput();
	MainHomePanel mhp = new MainHomePanel();
	MainDisPanel mdp = new MainDisPanel();
	MainSearchPanel msp = new MainSearchPanel();
	MainAccountPanel map = new MainAccountPanel(Type);
	
	boolean homeVis = true;
	boolean disVis = false;
	boolean searchVis = false;
	boolean accountVis = false;
	
	static MainHome frame;

//	public static void main(String[] args) {
//
//				try {
//					MainHome frame = new MainHome();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//	}
	
	public void diposeMain() {
		frame.dispose();
	}
	
	public void openMainHome() {
		frame = new MainHome();
		frame.setVisible(true);
	}

	public MainHome() {
		setSize(460, 680);
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(460), st.setCenterY(700) - 40);
		setUndecorated(true);
		contentP.setLayout(null);
		addMouseMotionListener(new MouseDragMove());
		
		ImageIcon backImage = new ImageIcon("src\\mainIcon\\BG1.jpg");
		JPanel background = imageEdit.panelPaint(backImage);
		background.setBounds(0, 0, 460, 680);
		
		ImageIcon xNormal = new ImageIcon("src\\mainIcon\\mainXB1.jpg");
		ImageIcon xAction = new ImageIcon("src\\mainIcon\\mainXB2.jpg");
		
		JButton xButton = new JButton();
		xButton.setBounds(430, 7, 20, 19);
		imageEdit.setButtonImage(xButton, xNormal, xAction);
		contentP.add(xButton);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ReturnLogin rl = new ReturnLogin();
				rl.printMsg();
				
				if(rl.getFlg()) {
					rl.setFlg(false);
					dispose();
				}
				
//				System.exit(0);  // 작업중 실제 실행 빠르게 확인 후 닫는 용
			}
		});
		
		mhp.setBounds(20, 160, 420, 500);
		contentP.add(mhp);
		mhp.setVisible(true);
		
		mdp.setBounds(20, 160, 420, 500);
		contentP.add(mdp);
		mdp.setVisible(false);
		
		msp.setBounds(20, 160, 420, 500);
		contentP.add(msp);
		msp.setVisible(false);
		
		map.setBounds(20, 160, 420, 500);
		contentP.add(map);
		map.setVisible(false);
		
		ImageIcon homeNormal = new ImageIcon("src\\mainIcon\\homeB1.jpg");
		ImageIcon homeAction = new ImageIcon("src\\mainIcon\\homeB2.jpg");
		ImageIcon disuseNormal = new ImageIcon("src\\mainIcon\\disB1.jpg");
		ImageIcon disuseAction = new ImageIcon("src\\mainIcon\\disB2.jpg");
		ImageIcon searchNormal = new ImageIcon("src\\mainIcon\\searchB1.jpg");
		ImageIcon searchAction = new ImageIcon("src\\mainIcon\\searchB2.jpg");
		ImageIcon accountNormal = new ImageIcon("src\\mainIcon\\accChB1.jpg");
		ImageIcon accountAction = new ImageIcon("src\\mainIcon\\accChB2.jpg");
		
		JButton homeButton = new JButton();
		homeButton.setBounds(40, 70, 55, 55);
		imageEdit.setButtonImage(homeButton, homeNormal, homeAction);
		contentP.add(homeButton);
		homeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!homeVis) {
					mhp.setVisible(true);
					homeVis = true;
				}
				
				if(disVis) {
					mdp.setVisible(false);
					disVis = false;
				}
				if(searchVis) {
					msp.setVisible(false);
					searchVis = false;
				}
				if(accountVis) {
					map.setVisible(false);
					accountVis = false;
				}
			}
		});
		
		JButton disButton = new JButton();
		disButton.setBounds(148, 71, 55, 55);
		imageEdit.setButtonImage(disButton, disuseNormal, disuseAction);
		contentP.add(disButton);
		disButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!disVis) {
					mdp.setVisible(true);
					disVis = true;
				}
				
				if(homeVis) {
					mhp.setVisible(false);
					homeVis = false;
				}
				if(searchVis) {
					msp.setVisible(false);
					searchVis = false;
				}
				if(accountVis) {
					map.setVisible(false);
					accountVis = false;
				}
			}
		});
		
		JButton searchButton = new JButton();
		searchButton.setBounds(256, 70, 55, 55);
		imageEdit.setButtonImage(searchButton, searchNormal, searchAction);
		contentP.add(searchButton);
		searchButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!searchVis) {
					msp.setVisible(true);
					searchVis = true;
				}
				
				if(homeVis) {
					mhp.setVisible(false);
					homeVis = false;
				}
				if(disVis) {
					mdp.setVisible(false);
					disVis = false;
				}
				if(accountVis) {
					map.setVisible(false);
					accountVis = false;
				}
			}
		});
		
		JButton accountButton = new JButton();
		accountButton.setBounds(365, 70, 55, 55);
		imageEdit.setButtonImage(accountButton, accountNormal, accountAction);
		contentP.add(accountButton);
		accountButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!accountVis) {
					map.setVisible(true);
					accountVis = true;
				}
				
				if(homeVis) {
					mhp.setVisible(false);
					homeVis = false;
				}
				if(disVis) {
					mdp.setVisible(false);
					disVis = false;
				}
				if(searchVis) {
					msp.setVisible(false);
					searchVis = false;
				}
			}
		});
		
		ImageIcon menuBG = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel menuBar = new JLabel("New label");
		menuBar.setBounds(20, 60, 420, 75);
		imageEdit.setPaintLabel(menuBar, menuBG);
		contentP.add(menuBar);
		
		contentP.add(background);
		
	}
	
	public void openHomePanel() {
		
	}
}
