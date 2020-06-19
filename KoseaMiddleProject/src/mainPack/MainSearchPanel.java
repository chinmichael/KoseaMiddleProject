package mainPack;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import mainResultPanel.DayDisPanel;
import mainResultPanel.ProductInputPanel;
import mainResultPanel.ProductSearchPanel;
import mainResultPanel.StockInputPanel;
import mainResultPanel.StockSearchPanel;
import toolPack.ImageInput;
import javax.swing.JButton;

public class MainSearchPanel extends BasicMP {
	
	boolean ssVis = false;
	boolean siVis = false;
	boolean psVis = false;
	boolean piVis = false;
	
	StockSearchPanel ssP;
	StockInputPanel siP = new StockInputPanel();
	ProductSearchPanel psP = new ProductSearchPanel();
	ProductInputPanel piP = new ProductInputPanel();

	public MainSearchPanel() {
		
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
		});
		
		JButton insertSB = new JButton();
		insertSB.setBounds(125, 0, 60, 60);
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
		});
		
		JButton searchPB = new JButton();
		searchPB.setBounds(235, 0, 60, 60);
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
		});
		
		JButton insertPB = new JButton();
		insertPB.setBounds(345, 0, 60, 60);
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
		});
		
	}
	
	public void viewPanel(JPanel jp) {
		jp.setBounds(0, 85, 420, 415);
		add(jp);
		jp.setVisible(true);
	}

}
