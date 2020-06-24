package mainPack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import mainResultPanel.DayDisPanel;
import mainResultPanel.MonthCkPanel;
import mainResultPanel.MonthDisPanel;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainDisPanel extends BasicMP {
	
	boolean dcVis = false;
	boolean mcVis = false;
	boolean ctVis = false;
	
	DayDisPanel ddp;
	MonthDisPanel mdp;
	MonthCkPanel mcp;

	public MainDisPanel() {
		
		JLabel explain1 = new JLabel("일일 폐기 조회");
		explain1.setBounds(6, 65, 85, 20);
		imageEdit.setHint(explain1);
		add(explain1);
		
		JLabel explain2 = new JLabel("월간 폐기 조회");
		explain2.setBounds(170, 65, 85, 20);
		imageEdit.setHint(explain2);
		add(explain2);
		
		JLabel explain3 = new JLabel("월간 폐기 현황");
		explain3.setBounds(335, 65, 86, 20);
		imageEdit.setHint(explain3);
		add(explain3);
		
		addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(false);
				explain2.setVisible(false);
				explain3.setVisible(false);
			}

		});
		
		ImageIcon dayNormal = new ImageIcon("src\\mainIcon\\dayB1.jpg");
		ImageIcon dayAction = new ImageIcon("src\\mainIcon\\dayB2.jpg");
		ImageIcon monNormal = new ImageIcon("src\\mainIcon\\monthB1.jpg");
		ImageIcon monAction = new ImageIcon("src\\mainIcon\\monthB2.jpg");
		ImageIcon cntNormal = new ImageIcon("src\\mainIcon\\McheckB1.jpg");
		ImageIcon cntAction = new ImageIcon("src\\mainIcon\\McheckB2.jpg");
		
		
		JToggleButton disDayCheck = new JToggleButton();
		disDayCheck.setBounds(15, 2, 60, 60);
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
			
			public void mouseEntered(MouseEvent e) {
				explain1.setVisible(true);
			}
			
		});
		
		JToggleButton disMonthCheck = new JToggleButton();
		disMonthCheck.setBounds(180, 2, 60, 60);
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
			
			public void mouseEntered(MouseEvent e) {
				explain2.setVisible(true);
			}
			
		});
		
		JToggleButton disMonthCount = new JToggleButton();
		disMonthCount.setBounds(345, 2, 60, 60);
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
			
			public void mouseEntered(MouseEvent e) {
				explain3.setVisible(true);
			}
			
		});
		
		ButtonGroup disBG = new ButtonGroup();
		disBG.add(disMonthCount);
		disBG.add(disMonthCheck);
		disBG.add(disDayCheck);
		
	}
	
	public void viewPanel(JPanel jp) {
		jp.setBounds(0, 85, 420, 415);
		add(jp);
		jp.setVisible(true);
	}
}
