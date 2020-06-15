package popUpPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;

public class CationMsg extends JDialog {

	Container contentP = getContentPane();
	ImageInput imageEdit = new ImageInput();
	
	public void printMsg(String msg) {
		CationMsg frame = new CationMsg(msg);
		frame.setVisible(true);
	}
	
	public CationMsg() {
		
	}

	public CationMsg(String msg) {
		setSize(300, 180); //2400 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(300), st.setCenterY(180) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\CationBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 300, 180);
		
		JLabel msgAccount = new JLabel(msg);
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("±º∏≤", Font.BOLD, 15));
		msgAccount.setBounds(0, 52, 300, 63);
		msgAccount.setHorizontalAlignment(JLabel.CENTER);
		contentP.add(msgAccount);
		
		JLabel buttonMsg = new JLabel("»Æ¿Œ");
		buttonMsg.setForeground(Color.WHITE);
		buttonMsg.setFont(new Font("±º∏≤", Font.BOLD, 15));
		buttonMsg.setBounds(136, 132, 33, 22);
		contentP.add(buttonMsg);
		
		ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
		ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
		JButton checkOK = new JButton();
		checkOK.setBounds(102, 125, 97, 31);
		contentP.add(checkOK);
		imageEdit.setButtonImage(checkOK, cnormal, caction);
		checkOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		ImageIcon xnormal = new ImageIcon("src\\warningImage\\Wxbutton1.jpg");
		ImageIcon xaction = new ImageIcon("src\\warningImage\\Wxbutton2.jpg");
		JButton xButton = new JButton();
		xButton.setBounds(279, 8, 10, 10);
		getContentPane().add(xButton);
		imageEdit.setButtonImage(xButton, xnormal, xaction);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		
		contentP.add(backG);

	}

}