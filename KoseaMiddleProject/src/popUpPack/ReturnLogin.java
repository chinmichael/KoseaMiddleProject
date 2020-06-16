package popUpPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import loginPack.LoginHome;
import toolPack.*;


public class ReturnLogin extends JDialog {

	Container contentP = getContentPane();
	static boolean flg = false;
	
	public boolean getFlg() {
		return flg;
	}

	public static void main(String[] args) {
		try {
			ReturnLogin frame = new ReturnLogin();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printMsg() {
		ReturnLogin frame = new ReturnLogin();
		frame.setVisible(true);
	}

	public ReturnLogin() {
		setSize(300, 180); //2400 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(300), st.setCenterY(180) - 100);
		setUndecorated(true);
		contentP.setLayout(null);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		
		ImageInput imageEdit = new ImageInput();
		
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\CationBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 300, 180);
		
		JLabel msgAccount = new JLabel(" ·Î±×¾Æ¿ô ÇÏ½Ã°Ú½À´Ï±î?");
		msgAccount.setHorizontalAlignment(SwingConstants.CENTER);
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("±¼¸²", Font.BOLD, 15));
		msgAccount.setBounds(0, 52, 300, 63);
		contentP.add(msgAccount);
		
		JLabel buttonMsg = new JLabel("Logout");
		buttonMsg.setHorizontalAlignment(SwingConstants.CENTER);
		buttonMsg.setForeground(Color.WHITE);
		buttonMsg.setFont(new Font("±¼¸²", Font.BOLD, 15));
		buttonMsg.setBounds(104, 132, 95, 22);
		contentP.add(buttonMsg);
		
		ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
		ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
		JButton checkExit = new JButton();
		checkExit.setBounds(103, 125, 97, 31);
		contentP.add(checkExit);
		imageEdit.setButtonImage(checkExit, cnormal, caction);
		checkExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginHome lh = new LoginHome();
				lh.openWindow();
				flg = true;
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