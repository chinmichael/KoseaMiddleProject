package mainPack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import mainResultPanel.ProductInputPanel;
import mainResultPanel.ProductSearchPanel;
import mainResultPanel.StockInputPanel;
import mainResultPanel.StockSearchPanel;
import javax.swing.JLabel;

public class MainSearchPanel extends BasicMP {
	
	boolean ssVis = false;
	boolean siVis = false;
	boolean psVis = false;
	boolean piVis = false;
	
	StockSearchPanel ssP;
	StockInputPanel siP;
	ProductSearchPanel psP;
	ProductInputPanel piP;

	public MainSearchPanel() {
		
		JLabel explain1 = new JLabel("재고조회");
		explain1.setBounds(16, 65, 60, 20);
		imageEdit.setHint(explain1);
		add(explain1);
		
		JLabel explain2 = new JLabel("재고등록");
		explain2.setBounds(127, 65, 60, 20);
		imageEdit.setHint(explain2);
		add(explain2);
		
		JLabel explain3 = new JLabel("상품조회");
		explain3.setBounds(238, 65, 60, 20);
		imageEdit.setHint(explain3);
		add(explain3);
		
		JLabel explain4 = new JLabel("상품등록");
		explain4.setBounds(348, 65, 60, 20);
		imageEdit.setHint(explain4);
		add(explain4);
		
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(false);
				explain2.setVisible(false);
				explain3.setVisible(false);
				explain4.setVisible(false);
			}

		});
		
		ImageIcon searchSNormal = new ImageIcon("src\\mainIcon\\searchSB1.jpg");
		ImageIcon searchSAction = new ImageIcon("src\\mainIcon\\searchSB2.jpg");
		ImageIcon insertSNormal = new ImageIcon("src\\mainIcon\\insertSB1.jpg");
		ImageIcon insertSAction = new ImageIcon("src\\mainIcon\\insertSB2.jpg");
		ImageIcon searchPNormal = new ImageIcon("src\\mainIcon\\searchPB1.jpg");
		ImageIcon searchPAction = new ImageIcon("src\\mainIcon\\searchPB2.jpg");
		ImageIcon insertPNormal = new ImageIcon("src\\mainIcon\\insertPB1.jpg");
		ImageIcon insertPAction = new ImageIcon("src\\mainIcon\\insertPB2.jpg");
		
		JToggleButton searchSB = new JToggleButton();
		searchSB.setBounds(15, 2, 60, 60);
		imageEdit.setButtonImage(searchSB, searchSNormal, searchSAction);
		add(searchSB);
		searchSB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!ssVis) {
					ssVis = true;
					ssP = new StockSearchPanel();
					viewPanel(ssP);
				}
				if(siVis) {
					siP.setVisible(false);
					siVis = false;
				}
				if(psVis) {
					psP.setVisible(false);
					psVis = false;
				}
				if(piVis) {
					piP.setVisible(false);
					piVis = false;
				}	
			}
			
			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(true);
			}
		});
		
		JToggleButton insertSB = new JToggleButton();
		insertSB.setBounds(125, 2, 60, 60);
		imageEdit.setButtonImage(insertSB, insertSNormal, insertSAction);
		add(insertSB);
		insertSB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!siVis) {
					siVis = true;
					siP = new StockInputPanel();
					viewPanel(siP);
				}
				if(ssVis) {
					ssP.setVisible(false);
					ssVis = false;
				}
				if(psVis) {
					psP.setVisible(false);
					psVis = false;
				}
				if(piVis) {
					piP.setVisible(false);
					piVis = false;
				}	
			}
			
			public void mouseEntered(MouseEvent e) {
				explain2.setVisible(true);
			}
		});
		
		JToggleButton searchPB = new JToggleButton();
		searchPB.setBounds(235, 2, 60, 60);
		imageEdit.setButtonImage(searchPB, searchPNormal, searchPAction);
		add(searchPB);
		searchPB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!psVis) {
					psVis = true;
					psP = new ProductSearchPanel();
					viewPanel(psP);
				}
				if(siVis) {
					siP.setVisible(false);
					siVis = false;
				}
				if(ssVis) {
					ssP.setVisible(false);
					ssVis = false;
				}
				if(piVis) {
					piP.setVisible(false);
					piVis = false;
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain3.setVisible(true);
			}
		});
		
		JToggleButton insertPB = new JToggleButton();
		insertPB.setBounds(345, 2, 60, 60);
		imageEdit.setButtonImage(insertPB, insertPNormal, insertPAction);
		add(insertPB);
		insertPB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (!piVis) {
					piVis = true;
					piP = new ProductInputPanel();
					viewPanel(piP);
				}
				if(siVis) {
					siP.setVisible(false);
					siVis = false;
				}
				if(psVis) {
					psP.setVisible(false);
					psVis = false;
				}
				if(ssVis) {
					ssP.setVisible(false);
					ssVis = false;
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain4.setVisible(true);
			}
		});
		
		ButtonGroup searchBG = new ButtonGroup();
		searchBG.add(insertPB);
		searchBG.add(searchPB);
		searchBG.add(insertSB);
		searchBG.add(searchSB);
		
	}
	
	public void viewPanel(JPanel jp) {
		jp.setBounds(0, 85, 420, 415);
		add(jp);
		jp.setVisible(true);
	}

}
