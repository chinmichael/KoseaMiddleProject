package loginPack;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import toolPack.*;
import connPack.*;
import mainPack.*;

public class LoginHome extends JFrame {
	
	ImageInput imageEdit = new ImageInput();
	private JTextField fieldID;
	private JPasswordField fieldPW;

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
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		setLocation(screen.width/2 - 190, screen.height/2 - 350);
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
		
		ImageIcon panelImage = new ImageIcon("src\\loginImage\\LoginBG1.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 380, 600);
		
		JLabel msgID = new JLabel("아이디를 입력하세요");
		msgID.setForeground(Color.GRAY);
		msgID.setBounds(72, 305, 131, 15);
		getContentPane().add(msgID);
		
		fieldID = new JTextField() {
			public void setBorder(Border border) {	
			}
		}; // 익명클래스로 텍스트 테두리 제거
		fieldID.setBounds(70, 295, 240, 31);
		fieldID.setOpaque(false);
		getContentPane().add(fieldID);
		fieldID.setColumns(10);
		
		JLabel msgPW = new JLabel("비밀번호를 입력하세요");
		msgPW.setForeground(Color.GRAY);
		msgPW.setBounds(72, 356, 133, 15);
		getContentPane().add(msgPW);
		
		fieldPW = new JPasswordField() {
			public void setBorder(Border border) {
			}
		};
		fieldPW.setBounds(70, 346, 240, 31);
		fieldPW.setOpaque(false);
		getContentPane().add(fieldPW);
		fieldPW.setColumns(10);
		
		fieldID.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
                msgID.setVisible(false);
                if(fieldPW.getText().equals(""))
                msgPW.setVisible(true);
            }
		});
		fieldPW.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(fieldID.getText().equals(""))
				msgID.setVisible(true);
                msgPW.setVisible(false);
            }
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (fieldID.getText().equals(""))
					msgID.setVisible(true);
				if (fieldPW.getText().equals(""))
					msgPW.setVisible(true);
			}
		});
		
		ImageIcon textImage = new ImageIcon("src\\loginImage\\Textbar.jpg");

		JLabel backID = new JLabel();
		backID.setBounds(63, 290, 254, 41);
		imageEdit.setPaintLabel(backID, textImage);
		getContentPane().add(backID);
		
		JLabel backPW = new JLabel();
		backPW.setBounds(63, 341, 254, 41);
		imageEdit.setPaintLabel(backPW, textImage);
		getContentPane().add(backPW);
		
		JButton xbutton = new JButton();
		xbutton.setLocation(348, 10);
		xbutton.setSize(20, 20);
		ImageIcon xnormal = new ImageIcon("src\\loginImage\\Xbutton1.jpg");
		ImageIcon xaction = new ImageIcon("src\\loginImage\\Xbutton2.jpg");
		imageEdit.setButtonImage(xbutton, xnormal, xaction);
		getContentPane().add(xbutton);
		xbutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
			
		JButton loginB = new JButton();
		loginB.setBounds(63, 400, 254, 43);
		ImageIcon lnormal = new ImageIcon("src\\loginImage\\Lbutton1.jpg");
		ImageIcon laction = new ImageIcon("src\\loginImage\\Lbutton2.jpg");
		imageEdit.setButtonImage(loginB, lnormal, laction);
		getContentPane().add(loginB);
		loginB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (fieldID.getText().equals("") || fieldPW.getText().equals("")) {
					WarningWindow win = new WarningWindow();
					win.openWarningAccount();
					if (fieldID.getText().equals("")) {
						msgID.setVisible(true);
					}
					if (fieldPW.getText().equals("")) {
						msgPW.setVisible(true);
					}
					
				} else {
					String IDcheck = fieldID.getText();
					String PWcheck = fieldPW.getText();
					
					AccountQ login = new AccountQ();
					ArrayList<AccountDB> list = login.list(IDcheck, PWcheck);
					AccountDB data = (AccountDB) list.get(0);
					if (data.getUcheck()) {
						dispose();
					}
					
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("신규 등록");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setBounds(112, 530, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JButton regB = new JButton();
		regB.setBounds(108, 528, 64, 20);
		getContentPane().add(regB);
		imageEdit.buttonOpaque(regB);
		
		JLabel lblNewLabel = new JLabel("계정 찾기");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setBounds(206, 530, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JButton findB = new JButton();
		findB.setBounds(203, 528, 64, 20);
		getContentPane().add(findB);
		imageEdit.buttonOpaque(findB);
		
		
		getContentPane().add(backG);
		
	}

}
