package popUpPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import loginPack.LoginRegist;
import toolPack.*;

public class InputIDcheck extends JDialog {

	Container contentP = getContentPane();
	private static boolean useID = false;
	
	public boolean getUse() {
		return useID;
	}

	public static void main() {
		try {
			boolean f = false;
			InputIDcheck frame = new InputIDcheck(f);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printMsg(boolean f) {
		InputIDcheck frame = new InputIDcheck(f);
		frame.setVisible(true);
	}

	public InputIDcheck(boolean f) {
		
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
			JLabel msgAccount = new JLabel("��밡���� ID�Դϴ�");
			msgAccount.setForeground(new Color(153, 102, 0));
			msgAccount.setFont(new Font("����", Font.BOLD, 15));
			msgAccount.setBounds(83, 52, 180, 63);
			contentP.add(msgAccount);

			JLabel buttonMsg = new JLabel("���");
			buttonMsg.setForeground(Color.WHITE);
			buttonMsg.setFont(new Font("����", Font.BOLD, 15));
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
					useID = true;
					dispose();
				}
			});
			
		} else {
			JLabel msgAccount = new JLabel("�ߺ��Ǵ� ID�� �ֽ��ϴ�");
			msgAccount.setForeground(new Color(153, 102, 0));
			msgAccount.setFont(new Font("����", Font.BOLD, 15));
			msgAccount.setBounds(78, 52, 200, 63);
			contentP.add(msgAccount);

			JLabel buttonMsg = new JLabel("Ȯ��");
			buttonMsg.setForeground(Color.WHITE);
			buttonMsg.setFont(new Font("����", Font.BOLD, 15));
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
				useID = false;
				dispose();
			}
		});

		contentP.add(backG);

	}

}
