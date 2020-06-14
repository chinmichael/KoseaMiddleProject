package loginPack;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import toolPack.*;
import connPack.*;
import mainPack.*;
import popUpPack.*;

public class LoginHome extends JFrame {
	
	Container contentP = getContentPane();
	
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
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(380), st.setCenterY(600) - 20);
		setUndecorated(true);
		getContentPane().setLayout(null);
//		setOpaque(false);
		addMouseMotionListener(new MouseDragMove());
		
		ImageInput imageEdit = new ImageInput();
		
		ImageIcon panelImage = new ImageIcon("src\\loginImage\\LoginBG1.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 380, 600);
		
		JLabel msgID = new JLabel("아이디를 입력하세요");
		msgID.setForeground(Color.GRAY);
		msgID.setBounds(72, 305, 131, 15);
		contentP.add(msgID);
		
		fieldID = imageEdit.textClean();
		fieldID.setBounds(70, 295, 240, 31);
		contentP.add(fieldID);
		fieldID.setColumns(10);
		
		JLabel msgPW = new JLabel("비밀번호를 입력하세요");
		msgPW.setForeground(Color.GRAY);
		msgPW.setBounds(72, 356, 133, 15);
		contentP.add(msgPW);
		
		fieldPW = new JPasswordField() {
			public void setBorder(Border border) {
			}
		};
		fieldPW.setBounds(70, 346, 240, 31);
		fieldPW.setOpaque(false);
		contentP.add(fieldPW);
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
		contentP.add(backID);
		
		JLabel backPW = new JLabel();
		backPW.setBounds(63, 341, 254, 41);
		imageEdit.setPaintLabel(backPW, textImage);
		contentP.add(backPW);
		
		JButton xbutton = new JButton();
		xbutton.setLocation(348, 10);
		xbutton.setSize(20, 20);
		ImageIcon xnormal = new ImageIcon("src\\loginImage\\Xbutton1.jpg");
		ImageIcon xaction = new ImageIcon("src\\loginImage\\Xbutton2.jpg");
		imageEdit.setButtonImage(xbutton, xnormal, xaction);
		contentP.add(xbutton);
		xbutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ExitWarning ex = new ExitWarning();
				ex.printMsg();
			}
		});
			
		JButton loginB = new JButton();
		loginB.setBounds(63, 400, 254, 43);
		ImageIcon lnormal = new ImageIcon("src\\loginImage\\Lbutton1.jpg");
		ImageIcon laction = new ImageIcon("src\\loginImage\\Lbutton2.jpg");
		imageEdit.setButtonImage(loginB, lnormal, laction);
		contentP.add(loginB);
		loginB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (fieldID.getText().equals("") || fieldPW.getText().equals("")) {
					AccountInput wMsg = new AccountInput();
					wMsg.printMsg();
					
					if (fieldID.getText().equals("")) {
						msgID.setVisible(true);
					}
					if (fieldPW.getText().equals("")) {
						msgPW.setVisible(true);
					}
					
				} else {
					String IDcheck = fieldID.getText();
					String PWcheck = fieldPW.getText();
					
					AccountQ loginC = new AccountQ();
					ArrayList<AccountDB> list = loginC.list(IDcheck, PWcheck);
					if (loginC.flg) {
						dispose();
					}
					
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("신규 등록");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setBounds(112, 530, 57, 15);
		contentP.add(lblNewLabel_1);
		
		JButton regB = new JButton();
		regB.setBounds(108, 528, 64, 20);
		contentP.add(regB);
		imageEdit.buttonOpaque(regB);
		regB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginRegist reg = new LoginRegist();
				reg.openWindow();
			}
		});		
		JLabel lblNewLabel = new JLabel("계정 찾기");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setBounds(206, 530, 57, 15);
		contentP.add(lblNewLabel);
		
		JButton findB = new JButton();
		findB.setBounds(203, 528, 64, 20);
		contentP.add(findB);
		imageEdit.buttonOpaque(findB);
		
		
		contentP.add(backG);
		
	}

}
