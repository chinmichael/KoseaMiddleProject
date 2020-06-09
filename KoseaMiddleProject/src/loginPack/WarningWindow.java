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
		
		JLabel msgAccount = new JLabel("아이디 혹은 비밀번호를 확인해주세요");
		msgAccount.setForeground(new Color(102, 51, 0));
		msgAccount.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		msgAccount.setBounds(32, 10, 274, 63);
		contentP1.add(msgAccount);
		
		JButton checkOK = new JButton("확인");
		checkOK.setBounds(115, 72, 97, 31);
		contentP1.add(checkOK);
		checkOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}
}
