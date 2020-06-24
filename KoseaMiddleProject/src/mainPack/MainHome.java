package mainPack;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

import connPack.AccountDB;
import toolPack.*;
import popUpPack.ReturnLogin;

public class MainHome extends JFrame {
	
	AccountDB ad = new AccountDB();
	String Type = ad.getUtype();
//	String Type = ""; // Ȯ���۾���
//	String Type = "����"; //Ȯ���۾���2
	
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
		
		JLabel explain1 = new JLabel("Ȩ");
		imageEdit.setHint(explain1);
		explain1.setBounds(52, 130, 35, 20);
		contentP.add(explain1);
		
		JLabel explain2 = new JLabel("���Ȯ��");
		imageEdit.setHint(explain2);
		explain2.setBounds(147, 131, 62, 20);
		contentP.add(explain2);
		
		JLabel explain3 = new JLabel("��� �˻�");
		imageEdit.setHint(explain3);
		explain3.setBounds(252, 131, 65, 20);
		contentP.add(explain3);
		
		JLabel explain4 = new JLabel("��������");
		imageEdit.setHint(explain4);
		explain4.setBounds(364, 131, 60, 20);
		contentP.add(explain4);

		addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(false);
				explain2.setVisible(false);
				explain3.setVisible(false);
				explain4.setVisible(false);
			}

		});
		
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
				
//				System.exit(0);  // �۾��� ���� ���� ������ Ȯ�� �� �ݴ� ��
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
		
		
		JToggleButton homeButton = new JToggleButton();
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
			
			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(true);
			}
			
		});
		
		explain1.setVisible(false);
		
		JToggleButton disButton = new JToggleButton();
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
			
			public void mouseEntered(MouseEvent e) {
				explain2.setVisible(true);
			}
			
		});
		
		JToggleButton searchButton = new JToggleButton();
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
			
			public void mouseEntered(MouseEvent e) {
				explain3.setVisible(true);
			}
		});
		
		JToggleButton accountButton = new JToggleButton();
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
			
			public void mouseEntered(MouseEvent e) {
				explain4.setVisible(true);
			}
		});
		
		ButtonGroup mainBG = new ButtonGroup();
		mainBG.add(homeButton);
		mainBG.add(disButton);
		mainBG.add(searchButton);
		mainBG.add(accountButton);
		
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
