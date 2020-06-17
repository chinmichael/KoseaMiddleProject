package mainPack;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import mainResultPanel.DayDisPanel;
import mainResultPanel.MonthCkPanel;
import mainResultPanel.MonthDisPanel;
import toolPack.ImageInput;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainDisPanel extends BasicMP {
	
	boolean dcVis = false;
	boolean mcVis = false;
	boolean ctVis = false;
	
	DayDisPanel ddp;
	MonthDisPanel mdp;
	MonthCkPanel mcp;

	public MainDisPanel() {
		
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
		disDayCheck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!dcVis) {
					dcVis = true;
					ddp = new DayDisPanel();
					viewPanel(ddp);
				}
				
				if(mcVis) {
					mdp.setVisible(false);
					mcVis = false;
				}
				if(ctVis) {
					mcp.setVisible(false);
					ctVis = false;
				}
			}
		});
		
		JButton disMonthCheck = new JButton();
		disMonthCheck.setBounds(180, 0, 60, 60);
		imageEdit.setButtonImage(disMonthCheck, monNormal, monAction);
		add(disMonthCheck);
		disMonthCheck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!mcVis) {
					mcVis = true;
					mdp = new MonthDisPanel();
					viewPanel(mdp);
				}
				
				if(dcVis) {
					ddp.setVisible(false);
					dcVis = false;
				}
				if(ctVis) {
					mcp.setVisible(false);
					ctVis = false;
				}
			}
		});
		
		JButton disMonthCount = new JButton();
		disMonthCount.setBounds(345, 0, 60, 60);
		imageEdit.setButtonImage(disMonthCount, cntNormal, cntAction);
		add(disMonthCount);
		disMonthCount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!ctVis) {
					ctVis = true;
					mcp = new MonthCkPanel();
					viewPanel(mcp);
				}
				
				if(dcVis) {
					ddp.setVisible(false);
					dcVis = false;
				}
				if(mcVis) {
					mdp.setVisible(false);
					mcVis = false;
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
