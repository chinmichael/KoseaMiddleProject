package loginPack;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginHome extends JFrame {

	public static void main(String[] args) {

		try {
			LoginHome frame = new LoginHome();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LoginHome() {
		setSize(380, 600);
		setResizable(false);
		setLocation(600, 200);
		setUndecorated(true);
		getContentPane().setLayout(null);
		addMouseMotionListener(new MouseMotionListener() {
			int xDrag, yDrag, xPress, yPress;
			
			@Override
			public void mouseDragged(MouseEvent e) {
				xDrag = e.getX();
				yDrag = e.getY();
				JFrame sframe = (JFrame) e.getSource();
				sframe.setLocation(sframe.getLocation().x +  xDrag - xPress, sframe.getLocation().y +  yDrag - yPress);
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				xPress = e.getX();
				yPress = e.getY();
			}
			
		});
		
		JButton xbutton = new JButton();
		xbutton.setBounds(348, 10, 20, 21);
		xbutton.setBorderPainted(false);
		xbutton.setContentAreaFilled(false);
		xbutton.setFocusPainted(false);
		Dimension d1 = xbutton.getSize();
		
		ImageIcon xnormal = new ImageIcon("src\\imagePack\\Xbutton1.png");
		xnormal = imageSetsize(xnormal, d1.width, d1.height);
		ImageIcon xaction = new ImageIcon("src\\imagePack\\Xbutton2.png");
		xaction = imageSetsize(xaction, d1.width, d1.height);
		
		xbutton.setIcon(xnormal);
		xbutton.setPressedIcon(xaction);
		xbutton.setRolloverIcon(xaction);
		xbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton loginB = new JButton();
		loginB.setBounds(52, 378, 280, 40);
		loginB.setBorderPainted(false);
		loginB.setContentAreaFilled(false);
		loginB.setFocusPainted(false);
		Dimension d2 = loginB.getSize();
		
		ImageIcon lnormal = new ImageIcon("src\\imagePack\\Lbutton1.png");
		lnormal = imageSetsize(lnormal, d2.width, d2.height);
		ImageIcon laction = new ImageIcon("src\\imagePack\\Lbutton2.png");
		laction = imageSetsize(laction, d2.width, d2.height);
		
		loginB.setIcon(lnormal);
		loginB.setPressedIcon(laction);
		loginB.setRolloverIcon(laction);
		
		getContentPane().add(xbutton);
		getContentPane().add(loginB);
		
		
		JTextField IDcheck = new JTextField();
		IDcheck = new JTextField("ID를 입력하세요");
		IDcheck.setBounds(52, 278, 280, 40);
		getContentPane().add(IDcheck);
		IDcheck.setColumns(10);
		
		JTextField PWcheck = new JTextField();
		PWcheck = new JTextField("PW를 입력하세요");
		PWcheck.setBounds(52, 328, 280, 40);
		getContentPane().add(PWcheck);
		PWcheck.setColumns(10);
		
		JLabel regText = new JLabel("신규 등록");
		regText.setFont(new Font("굴림", Font.PLAIN, 13));
		regText.setBounds(119, 428, 57, 27);
		getContentPane().add(regText);
		
		JLabel lblNewLabel_1 = new JLabel("|");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(189, 428, 7, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel findText = new JLabel("계정 찾기");
		findText.setFont(new Font("굴림", Font.PLAIN, 13));
		findText.setBounds(218, 431, 57, 21);
		getContentPane().add(findText);
		
		JButton regB = new JButton();
		regB.setBorderPainted(false);
		regB.setContentAreaFilled(false);
		regB.setFocusPainted(false);
		regB.setBounds(86, 428, 97, 23);
		getContentPane().add(regB);
		
		JButton findB = new JButton();
		findB.setBorderPainted(false);
		findB.setContentAreaFilled(false);
		findB.setFocusPainted(false);
		findB.setBounds(227, 519, 97, 23);
		getContentPane().add(findB);
		
	}
	
	public void paint(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon("src\\imagePack\\LoginBG1.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}
	
	public ImageIcon imageSetsize(ImageIcon icon, int x, int y) {
		Image a = icon.getImage();  // ImageIcon Imgae변환 (이미지 아이콘 품질 깨지지 않고 변환하기 위해)
		Image b = a.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // (image함수 getScaledInstance로 품질 유지한 채 사이즈 변경)
		ImageIcon c = new ImageIcon(b);
		return c;
	}
}
