package warningPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class AccountInput extends JFrame {

	Container contentP = getContentPane();

	public static void main(String[] args) {
		try {
			AccountInput frame = new AccountInput();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printMsg() {
		AccountInput frame = new AccountInput();
		frame.setVisible(true);
	}

	public AccountInput() {
		setBounds(100, 100, 352, 164);
		contentP.setLayout(null);
		
		JLabel msgAccount = new JLabel("���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���");
		msgAccount.setForeground(new Color(102, 51, 0));
		msgAccount.setFont(new Font("���� ���", Font.PLAIN, 16));
		msgAccount.setBounds(32, 10, 274, 63);
		contentP.add(msgAccount);
		
		JButton checkOK = new JButton("Ȯ��");
		checkOK.setBounds(115, 72, 97, 31);
		contentP.add(checkOK);
		checkOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}

}
