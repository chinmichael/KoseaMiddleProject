package popUpPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import toolPack.*;

public class OverlapCheck extends JDialog {

	Container contentP = getContentPane();

	public static void main() {
		try {
			OverlapCheck frame = new OverlapCheck(false);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printMsg(boolean f) {
		OverlapCheck frame = new OverlapCheck(f);
		frame.setVisible(true);
	}

	public OverlapCheck(boolean f) {
		
		setSize(300, 180); // 2400 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(300), st.setCenterY(180) - 100);
		setUndecorated(true);
		contentP.setLayout(null);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());

		ImageInput imageEdit = new ImageInput();

		ImageIcon panelImage = new ImageIcon("src\\warningImage\\ResultBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 300, 180);

		if (f) {
			JLabel msgAccount = new JLabel("ID 중복확인을 해주세요");
			msgAccount.setForeground(new Color(153, 102, 0));
			msgAccount.setFont(new Font("굴림", Font.BOLD, 15));
			msgAccount.setBounds(76, 52, 180, 63);
			contentP.add(msgAccount);

			JLabel buttonMsg = new JLabel("확인");
			buttonMsg.setForeground(Color.WHITE);
			buttonMsg.setFont(new Font("굴림", Font.BOLD, 15));
			buttonMsg.setBounds(136, 132, 33, 22);
			contentP.add(buttonMsg);

			ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
			ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
			JButton checkExit = new JButton();
			checkExit.setBounds(105, 125, 97, 31);
			contentP.add(checkExit);
			imageEdit.setButtonImage(checkExit, cnormal, caction);
			checkExit.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			
		} else {
			JLabel msgAccount = new JLabel("ID를 입력해주세요");
			msgAccount.setForeground(new Color(153, 102, 0));
			msgAccount.setFont(new Font("굴림", Font.BOLD, 15));
			msgAccount.setBounds(90, 52, 200, 63);
			contentP.add(msgAccount);

			JLabel buttonMsg = new JLabel("확인");
			buttonMsg.setForeground(Color.WHITE);
			buttonMsg.setFont(new Font("굴림", Font.BOLD, 15));
			buttonMsg.setBounds(136, 132, 33, 22);
			contentP.add(buttonMsg);

			ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
			ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
			JButton checkExit = new JButton();
			checkExit.setBounds(105, 125, 97, 31);
			contentP.add(checkExit);
			imageEdit.setButtonImage(checkExit, cnormal, caction);
			checkExit.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			
			
		}

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
