package loginPack;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginStart extends JFrame {
	
	public class Content extends JPanel {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("C:\\Users\\chinm\\git\\KoseaMiddleProject\\KoseaMiddleProject\\src\\imagePack");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
		}
	}
	
	public static void main(String[] args) {

		try {
			LoginStart frame = new LoginStart();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	


	public LoginStart() {
		setTitle("Login");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(117, 142, 97, 23);
		getContentPane().add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 1300);
		setLocation(800, 400);
		
		Content panel = new Content();
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 1300);
		setContentPane(panel);
	}
}
