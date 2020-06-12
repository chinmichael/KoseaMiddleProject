package popUpPack;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import toolPack.*;


public class EssentialW extends JDialog {

	Container contentP = getContentPane();

	public static void main(String[] args) {
		try {
			EssentialW frame = new EssentialW();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printMsg() {
		EssentialW frame = new EssentialW();
		frame.setVisible(true);
	}

	public EssentialW() {
		setSize(300, 180); //2400 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(300), st.setCenterY(180) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		ImageInput imageEdit = new ImageInput();
		
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\CationBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 300, 180);
		
		JLabel msgAccount = new JLabel("필수 정보를 모두 입력해주세요");
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("굴림", Font.BOLD, 15));
		msgAccount.setBounds(45, 52, 255, 63);
		contentP.add(msgAccount);
		
		JLabel buttonMsg = new JLabel("확인");
		buttonMsg.setForeground(Color.WHITE);
		buttonMsg.setFont(new Font("굴림", Font.BOLD, 15));
		buttonMsg.setBounds(138, 132, 33, 22);
		getContentPane().add(buttonMsg);
		
		ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
		ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
		JButton checkOK = new JButton();
		checkOK.setBounds(105, 125, 97, 31);
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