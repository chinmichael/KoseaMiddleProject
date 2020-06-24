package mainPack;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.plaf.ColorUIResource;

import mainResultPanel.OutPanel;
import mainResultPanel.PassChangePanel;
import mainResultPanel.PhoneChangePanel;
import mainResultPanel.RankChangePanel;
import mainResultPanel.ShopPassPanel;
import toolPack.ImageInput;
import javax.swing.JLabel;

public class MainAccountPanel extends JLayeredPane {
	
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);
	
	boolean passVis = false;
	boolean shopVis = false;
	boolean phonVis = false;
	boolean rankVis = false;
	boolean exitVis = false;
	
	PassChangePanel pcp = new PassChangePanel();
	ShopPassPanel spp = new ShopPassPanel();
	PhoneChangePanel php = new PhoneChangePanel();
	RankChangePanel rcp = new RankChangePanel();
	OutPanel op = new OutPanel();
	
	public MainAccountPanel() {
		
	}

	public MainAccountPanel(String Type) {
		setBackground(BG); //
		setSize(420, 500); //setBound at 40, 185
		setLayout(null);
		
		JLabel explain1 = new JLabel("PW 변경");
		explain1.setBounds(15, 65, 65, 20);
		imageEdit.setHint(explain1);
		add(explain1);
		
		JLabel explain2 = new JLabel("점포코드 변경");
		explain2.setBounds(85, 65, 90, 20);
		imageEdit.setHint(explain2);
		add(explain2);

		JLabel explain3 = new JLabel("연락처 변경");
		explain3.setBounds(170, 65, 85, 20);
		imageEdit.setHint(explain3);
		add(explain3);
		
		JLabel explain4 = new JLabel("직급 변경");
		explain4.setBounds(260, 65, 65, 20);
		imageEdit.setHint(explain4);
		add(explain4);
		
		JLabel explain5 = new JLabel("계정 삭제");
		explain5.setBounds(345, 65, 65, 20);
		imageEdit.setHint(explain5);
		add(explain5);
		
		addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(false);
				explain2.setVisible(false);
				explain3.setVisible(false);
				explain4.setVisible(false);
				explain5.setVisible(false);
			}
		});
		
		ButtonGroup accBG = new ButtonGroup();
		JToggleButton shopChange;
		JToggleButton rankChange;
		
		if(Type.equals("점장")) {
			
			ImageIcon shopNormal = new ImageIcon("src\\mainIcon\\shopCB1.jpg");
			ImageIcon shopAction = new ImageIcon("src\\mainIcon\\shopCB2.jpg");
			ImageIcon rankNormal = new ImageIcon("src\\mainIcon\\rankCB1.jpg");
			ImageIcon rankAction = new ImageIcon("src\\mainIcon\\rankCB2.jpg");
			
			shopChange = new JToggleButton();
			shopChange.setBounds(97, 2, 60, 60);
			imageEdit.setButtonImage(shopChange, shopNormal, shopAction);
			add(shopChange);
			shopChange.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					
					if (!shopVis) {
						shopVis = true;
						spp = new ShopPassPanel();
						viewPanel(spp);
					}
					if(passVis) {
						pcp.setVisible(false);
						passVis = false;
					}
					if(phonVis) {
						php.setVisible(false);
						phonVis = false;
					}
					if(rankVis) {
						rcp.setVisible(false);
						rankVis = false;
					}
					if(exitVis) {
						op.setVisible(false);
						exitVis = false;
					}
					
				}
				
				public void mouseEntered(MouseEvent e) {
					explain2.setVisible(true);
				}
				
			});
			
			rankChange = new JToggleButton();
			rankChange.setBounds(262, 2, 60, 60);
			imageEdit.setButtonImage(rankChange, rankNormal, rankAction);
			add(rankChange);
			rankChange.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					
					if (!rankVis) {
						rankVis = true;
						rcp = new RankChangePanel();
						viewPanel(rcp);
					}
					if(shopVis) {
						spp.setVisible(false);
						shopVis = false;
					}
					if(phonVis) {
						php.setVisible(false);
						phonVis = false;
					}
					if(passVis) {
						pcp.setVisible(false);
						passVis = false;
					}
					if(exitVis) {
						op.setVisible(false);
						exitVis = false;
					}	
				}
				
				public void mouseEntered(MouseEvent e) {
					explain4.setVisible(true);
				}
			});
			
			accBG.add(rankChange);
			accBG.add(shopChange);
			
		}
		
		ImageIcon passNormal = new ImageIcon("src\\mainIcon\\passCB1.jpg");
		ImageIcon passAction = new ImageIcon("src\\mainIcon\\passCB2.jpg");
		ImageIcon phoneNormal = new ImageIcon("src\\mainIcon\\phoneCB1.jpg");
		ImageIcon phoneAction = new ImageIcon("src\\mainIcon\\phoneCB2.jpg");
		ImageIcon outNormal = new ImageIcon("src\\mainIcon\\exitB1.jpg");
		ImageIcon outAction = new ImageIcon("src\\mainIcon\\exitB2.jpg");
		
		JToggleButton passChange = new JToggleButton();
		passChange.setBounds(15, 2, 60, 60);
		imageEdit.setButtonImage(passChange, passNormal, passAction);
		add(passChange);
		passChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!passVis) {
					passVis = true;
					pcp = new PassChangePanel();
					viewPanel(pcp);
				}
				if(shopVis) {
					spp.setVisible(false);
					shopVis = false;
				}
				if(phonVis) {
					php.setVisible(false);
					phonVis = false;
				}
				if(rankVis) {
					rcp.setVisible(false);
					rankVis = false;
				}
				if(exitVis) {
					op.setVisible(false);
					exitVis = false;
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(true);
			}
		});
		
		JToggleButton phoneChange = new JToggleButton();
		phoneChange.setBounds(180, 2, 60, 60);
		imageEdit.setButtonImage(phoneChange, phoneNormal, phoneAction);
		add(phoneChange);
		phoneChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!phonVis) {
					phonVis = true;
					php = new PhoneChangePanel();
					viewPanel(php);
				}
				if(shopVis) {
					spp.setVisible(false);
					shopVis = false;
				}
				if(passVis) {
					pcp.setVisible(false);
					passVis = false;
				}
				if(rankVis) {
					rcp.setVisible(false);
					rankVis = false;
				}
				if(exitVis) {
					op.setVisible(false);
					exitVis = false;
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain3.setVisible(true);
			}
		});
		
		JToggleButton accountExit = new JToggleButton();
		accountExit.setBounds(345, 2, 60, 60);
		imageEdit.setButtonImage(accountExit, outNormal, outAction);
		add(accountExit);
		accountExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!exitVis) {
					exitVis = true;
					op = new OutPanel();
					viewPanel(op);
				}
				if(shopVis) {
					spp.setVisible(false);
					shopVis = false;
				}
				if(phonVis) {
					php.setVisible(false);
					phonVis = false;
				}
				if(rankVis) {
					rcp.setVisible(false);
					rankVis = false;
				}
				if(passVis) {
					pcp.setVisible(false);
					passVis = false;
				}	
			}
			
			public void mouseEntered(MouseEvent e) {
				explain5.setVisible(true);
			}
		});
		
		accBG.add(accountExit);
		accBG.add(phoneChange);
		accBG.add(passChange);

	}
	
	public void viewPanel(JPanel jp) {
		jp.setBounds(0, 85, 420, 415);
		add(jp);
		jp.setVisible(true);
	}

}
