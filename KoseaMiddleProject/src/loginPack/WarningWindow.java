package loginPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import toolPack.*;

public class WarningWindow extends JFrame {
	Container contentP1 = getContentPane();

	public static void main(String[] args) {
		try {
			WarningWindow frame = new WarningWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openWarningAccount() {
		WarningWindow frame = new WarningWindow();
		frame.setVisible(true);
	}

	public WarningWindow() {
		setBounds(100, 100, 352, 164);
		contentP1.setLayout(null);
		
		JLabel msgAccount = new JLabel("���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���");
		msgAccount.setForeground(new Color(102, 51, 0));
		msgAccount.setFont(new Font("���� ���", Font.PLAIN, 16));
		msgAccount.setBounds(32, 10, 274, 63);
		contentP1.add(msgAccount);
		
		JButton checkOK = new JButton("Ȯ��");
		checkOK.setBounds(115, 72, 97, 31);
		contentP1.add(checkOK);
		checkOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}
}
