package popUpPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import toolPack.*;


public class ExitWarning extends JDialog {

	Container contentP = getContentPane();

	public static void main(String[] args) {
		try {
			ExitWarning frame = new ExitWarning();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printMsg() {
		ExitWarning frame = new ExitWarning();
		frame.setVisible(true);
	}

	public ExitWarning() {
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
		
		JLabel msgAccount = new JLabel("종료하시겠습니까?");
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("굴림", Font.BOLD, 15));
		msgAccount.setBounds(88, 52, 128, 63);
		contentP.add(msgAccount);
		
		JLabel buttonMsg = new JLabel("종료");
		buttonMsg.setForeground(Color.WHITE);
		buttonMsg.setFont(new Font("굴림", Font.BOLD, 15));
		buttonMsg.setBounds(138, 132, 33, 22);
		getContentPane().add(buttonMsg);
		
		ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
		ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
		JButton checkExit = new JButton();
		checkExit.setBounds(105, 125, 97, 31);
		contentP.add(checkExit);
		imageEdit.setButtonImage(checkExit, cnormal, caction);
		checkExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
