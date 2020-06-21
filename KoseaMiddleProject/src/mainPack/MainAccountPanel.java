package mainPack;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import mainResultPanel.OutPanel;
import mainResultPanel.PassChangePanel;
import mainResultPanel.PhoneChangePanel;
import mainResultPanel.RankChangePanel;
import mainResultPanel.ShopPassPanel;
import mainResultPanel.StockSearchPanel;
import toolPack.ImageInput;

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
		
		JButton shopChange;
		JButton rankChange;
		
		if(Type.equals("¡°¿Â")) {
			
			ImageIcon shopNormal = new ImageIcon("src\\mainIcon\\shopCB1.jpg");
			ImageIcon shopAction = new ImageIcon("src\\mainIcon\\shopCB2.jpg");
			ImageIcon rankNormal = new ImageIcon("src\\mainIcon\\rankCB1.jpg");
			ImageIcon rankAction = new ImageIcon("src\\mainIcon\\rankCB2.jpg");
			
			shopChange = new JButton();
			shopChange.setBounds(97, 0, 60, 60);
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
			});
			
			rankChange = new JButton();
			rankChange.setBounds(262, 0, 60, 60);
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
			});
			
		}
		
		ImageIcon passNormal = new ImageIcon("src\\mainIcon\\passCB1.jpg");
		ImageIcon passAction = new ImageIcon("src\\mainIcon\\passCB2.jpg");
		ImageIcon phoneNormal = new ImageIcon("src\\mainIcon\\phoneCB1.jpg");
		ImageIcon phoneAction = new ImageIcon("src\\mainIcon\\phoneCB2.jpg");
		ImageIcon outNormal = new ImageIcon("src\\mainIcon\\exitB1.jpg");
		ImageIcon outAction = new ImageIcon("src\\mainIcon\\exitB2.jpg");
		
		JButton passChange = new JButton();
		passChange.setBounds(15, 0, 60, 60);
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
		});
		
		JButton phoneChange = new JButton();
		phoneChange.setBounds(180, 0, 60, 60);
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
		});
		
		JButton accountExit = new JButton();
		accountExit.setBounds(345, 0, 60, 60);
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
		});
		

	}
	
	public void viewPanel(JPanel jp) {
		jp.setBounds(0, 85, 420, 415);
		add(jp);
		jp.setVisible(true);
	}

}
