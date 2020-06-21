package loginPack;

import java.awt.*;




import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicArrowButton;

import connPack.AccountQ;
import popUpPack.CationMsg;
import popUpPack.ExitWarning;
import popUpPack.OverCheck;
import popUpPack.OwnerCodeInput;
import popUpPack.ShopList;
import popUpPack.ShopSearch;
import toolPack.*;

public class LoginRegist extends JDialog {
	
	Container contentP = getContentPane();
	private JTextField nameF;
	private JTextField idF;
	private JPasswordField pwF;
	private JPasswordField checkPwF;
	private JTextField hintF;
	private JTextField hAnswerF;
	private JTextField phoneF1, phoneF2, phoneF3;
	private JTextField mailF1, mailF2;
	private String rankF;
	private JTextField shopF;
	
	JLabel checkinfo2;
	JRadioButton rankS1, rankS2, rankS3;
	
	boolean passflg = true;
	TextClear tc = new TextClear();
	ImageInput imageEdit = new ImageInput();
	CationMsg cm = new CationMsg();
	AccountQ regAcc;

	public static void main(String[] args) {
		try {
			LoginRegist frame = new LoginRegist();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openWindow() {
		LoginRegist frame = new LoginRegist();
		frame.setVisible(true);
	}

	public LoginRegist() {
		setSize(450, 700);// 1800 x 2800 / 450 x 700
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(450), st.setCenterY(700) - 50);
		setUndecorated(true);
		setModal(true);
		contentP.setLayout(null);
		addMouseMotionListener(new DragMoveDialog());
		
		ImageIcon panelImage = new ImageIcon("src\\loginImage\\LRegBG1.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 450, 700);
		
		ImageIcon xNormal = new ImageIcon("src\\loginImage\\Wxbutton1.jpg");
		ImageIcon xAction = new ImageIcon("src\\loginImage\\Wxbutton2.jpg");
		
		JButton xButton = new JButton();
		xButton.setBounds(415, 16, 18, 18);
		imageEdit.setButtonImage(xButton, xNormal, xAction);
		contentP.add(xButton);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		JLabel checkinfo = new JLabel("중복확인 버튼을 눌러주세요 >>");
		checkinfo.setForeground(Color.LIGHT_GRAY);
		checkinfo.setFont(new Font("굴림", Font.BOLD, 13));
		checkinfo.setBounds(143, 137, 192, 25);
		contentP.add(checkinfo);
		
		checkinfo2 = new JLabel("8자리 이상을 입력해주세요");
		checkinfo2.setHorizontalAlignment(SwingConstants.RIGHT);
		checkinfo2.setForeground(Color.LIGHT_GRAY);
		checkinfo2.setFont(new Font("굴림", Font.BOLD, 13));
		checkinfo2.setBounds(108, 192, 220, 25);
		contentP.add(checkinfo2);
		
		nameF = tfsetting(nameF);
		nameF.setBounds(135, 80, 195, 25);
		contentP.add(nameF);
		nameF.setColumns(10);
		
		idF = tc.textClean();
		idF.setEditable(false);
		idF.setBounds(135, 135, 195, 25);
		contentP.add(idF);
		idF.setColumns(10);
		
		idF.setFocusTraversalKeysEnabled(false);
		idF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 9) { // keyCode() == 9 는 Tab, 10은 Enter
					pwF.requestFocus();
					checkinfo2.setVisible(false);
					passflg = true;
				}
			}
		});
		
		pwF = tc.passClean();
		pwF.setBounds(135, 190, 195, 25);
		contentP.add(pwF);
		pwF.setColumns(10);
		pwF.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				checkinfo2.setVisible(false);
				passflg = true;
			}
		});
		
		pwF.setFocusTraversalKeysEnabled(false);
		pwF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 9) {  //keyCode() == 9 는 Tab, 10은 Enter
					checkPwF.requestFocus();
					if (pwF.getText().isBlank()) {
						checkinfo2.setVisible(true);
						passflg = false;
					}
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pwF.getText().isBlank()) {
					checkinfo2.setVisible(true);
					passflg = false;
				}
			}
		});
		
		checkPwF = tc.passClean();
		checkPwF.setBounds(135, 245, 195, 25);
		contentP.add(checkPwF);
		checkPwF.setColumns(10);
		checkPwF.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pwF.getText().isBlank()) {
					checkinfo2.setVisible(true);
					passflg = false;
				}
			}
		});
		
		hintF = tfsetting(hintF);
		hintF.setBounds(135, 300, 195, 25);
		contentP.add(hintF);
		hintF.setColumns(10);
		
		hAnswerF = tfsetting(hAnswerF);
		hAnswerF.setBounds(135, 355, 195, 25);
		contentP.add(hAnswerF);
		hAnswerF.setColumns(10);
		
		IntegerDocument id = new IntegerDocument(3);
		IntegerDocument id2 = new IntegerDocument(4);
		IntegerDocument id3 = new IntegerDocument(4);
		
		phoneF1 = tfsetting(phoneF1);
		phoneF1.setBounds(135, 410, 45, 25);
		phoneF1.setDocument(id);
		phoneF1.setHorizontalAlignment(SwingConstants.CENTER);
		contentP.add(phoneF1);
		phoneF1.setColumns(10);
		
		phoneF2 = tfsetting(phoneF2);
		phoneF2.setBounds(225, 410, 45, 25);
		phoneF2.setDocument(id2);
		phoneF2.setHorizontalAlignment(SwingConstants.CENTER);
		contentP.add(phoneF2);
		phoneF2.setColumns(10);
		
		phoneF3 = tfsetting(phoneF3);
		phoneF3.setBounds(315, 410, 45, 25);
		phoneF3.setDocument(id3);
		phoneF3.setHorizontalAlignment(SwingConstants.CENTER);
		contentP.add(phoneF3);
		phoneF3.setColumns(10);
		
		mailF1 = tfsetting(mailF1);
		mailF1.setBounds(135, 465, 103, 25);
		contentP.add(mailF1);
		mailF1.setColumns(10);
		
		mailF2 = tfsetting(mailF2);
		mailF2.setBounds(285, 465, 103, 25);
		contentP.add(mailF2);
		mailF2.setColumns(10);
		
		shopF = tfsetting(shopF);
		shopF.setBounds(135, 575, 195, 25);
		contentP.add(shopF);
		shopF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("성명");
		lblNewLabel.setBounds(45, 85, 41, 20);
		settextQ(lblNewLabel);
		contentP.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(45, 140, 41, 20);
		settextQ(lblNewLabel_1);
		contentP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setBounds(45, 195, 70, 20);
		settextQ(lblNewLabel_2);
		contentP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PW 확인");
		lblNewLabel_3.setBounds(45, 250, 70, 20);
		settextQ(lblNewLabel_3);
		contentP.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PW Hint");
		lblNewLabel_4.setBounds(45, 305, 70, 20);
		settextQ(lblNewLabel_4);
		contentP.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hint 답변");
		lblNewLabel_5.setBounds(45, 360, 70, 20);
		settextQ(lblNewLabel_5);
		contentP.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("연락처");
		lblNewLabel_6.setBounds(45, 415, 70, 20);
		settextQ(lblNewLabel_6);
		contentP.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setBounds(45, 470, 70, 20);
		settextQ(lblNewLabel_7);
		contentP.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("직급");
		lblNewLabel_8.setBounds(45, 525, 70, 20);
		settextQ(lblNewLabel_8);
		contentP.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("점포 코드");
		lblNewLabel_9.setBounds(45, 580, 70, 20);
		settextQ(lblNewLabel_9);
		contentP.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("(선택)");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("굴림", Font.PLAIN, 10));
		lblNewLabel_10.setBounds(94, 472, 41, 18);
		contentP.add(lblNewLabel_10);
		
		ImageIcon inputArea1 = new ImageIcon("src\\loginImage\\RegInputBar.jpg");
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(127, 75, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_11, inputArea1);
		contentP.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(127, 130, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_12, inputArea1);
		contentP.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(127, 185, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_13, inputArea1);
		contentP.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(127, 240, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_14, inputArea1);
		contentP.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(127, 295, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_15, inputArea1);
		contentP.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(127, 350, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_16, inputArea1);
		contentP.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17_1 = new JLabel("New label");
		lblNewLabel_17_1.setBounds(127, 405, 57, 35);
		imageEdit.setPaintLabel(lblNewLabel_17_1, inputArea1);
		contentP.add(lblNewLabel_17_1);
		
		JLabel lblNewLabel_17_2 = new JLabel("New label");
		lblNewLabel_17_2.setBounds(217, 405, 57, 35);
		imageEdit.setPaintLabel(lblNewLabel_17_2, inputArea1);
		getContentPane().add(lblNewLabel_17_2);
		
		JLabel lblNewLabel_17_3 = new JLabel("New label");
		lblNewLabel_17_3.setBounds(307, 405, 57, 35);
		imageEdit.setPaintLabel(lblNewLabel_17_3, inputArea1);
		getContentPane().add(lblNewLabel_17_3);
		
		JLabel lblNewLabel_17_4 = new JLabel("-");
		lblNewLabel_17_4.setForeground(new Color(102, 51, 0));
		lblNewLabel_17_4.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_17_4.setBounds(286, 417, 18, 15);
		contentP.add(lblNewLabel_17_4);
		
		JLabel lblNewLabel_17_5 = new JLabel("-");
		lblNewLabel_17_5.setForeground(new Color(102, 51, 0));
		lblNewLabel_17_5.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_17_5.setBounds(196, 417, 18, 15);
		contentP.add(lblNewLabel_17_5);
		
		JLabel lblNewLabel_18_1 = new JLabel("New label");
		lblNewLabel_18_1.setBounds(127, 460, 115, 35);
		imageEdit.setPaintLabel(lblNewLabel_18_1, inputArea1);
		contentP.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_18_2 = new JLabel("New label");
		lblNewLabel_18_2.setBounds(277, 460, 115, 35);
		imageEdit.setPaintLabel(lblNewLabel_18_2, inputArea1);
		contentP.add(lblNewLabel_18_2);
		
		JLabel lblNewLabel_18_3 = new JLabel("@");
		lblNewLabel_18_3.setForeground(new Color(102, 51, 0));
		lblNewLabel_18_3.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_18_3.setBounds(251, 467, 18, 25);
		contentP.add(lblNewLabel_18_3);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setBounds(127, 570, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_20, inputArea1);
		contentP.add(lblNewLabel_20);
		
		ImageIcon reg1 = new ImageIcon("src\\loginImage\\RegButton2.jpg");
		ImageIcon reg2 = new ImageIcon("src\\loginImage\\RegButton3.jpg");
		
		JButton overlap = new JButton();
		overlap.setBounds(336, 130, 53, 35);
		imageEdit.setOneImage(overlap, reg1);
		contentP.add(overlap);
		overlap.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				OverCheck ov = new OverCheck();
				ov.openWindow();
				
				idF.setText(ov.getID());
				if(idF.getText().equals("")) {
					checkinfo.setVisible(true);
				} else {
					checkinfo.setVisible(false);
				}
			}
		});
		
		RadioSelect radioS = new RadioSelect();
		
		rankS1 = new JRadioButton(" 아르바이트");
		setRadio(rankS1);
		rankS1.setBounds(123, 524, 115, 23);
		contentP.add(rankS1);
		rankS1.addActionListener(radioS);
		
		rankS2 = new JRadioButton(" 매니저");
		setRadio(rankS2);
		rankS2.setBounds(243, 524, 85, 23);
		contentP.add(rankS2);
		rankS2.addActionListener(radioS);
		
		rankS3 = new JRadioButton(" 점장");
		setRadio(rankS3);
		rankS3.setBounds(334, 524, 70, 23);
		contentP.add(rankS3);
		rankS3.addActionListener(radioS);
		
		ButtonGroup rankG = new ButtonGroup();
		rankG.add(rankS1);
		rankG.add(rankS2);
		rankG.add(rankS3);
		
		
		JButton searchS = new JButton();
		searchS.setBounds(336, 570, 53, 35);
		imageEdit.setOneImage(searchS, reg2);
		contentP.add(searchS);
		searchS.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ShopSearch ss = new ShopSearch();
				ss.openWindow();
				shopF.setText(ss.getCode());
			}
		});
		
		ImageIcon subNormal = new ImageIcon("src\\loginImage\\SubmitReg1.jpg");
		ImageIcon subAction = new ImageIcon("src\\loginImage\\SubmitReg2.jpg");
		
		JButton submitB = new JButton();
		submitB.setBounds(2, 637, 446, 61);
		imageEdit.setButtonImage(submitB, subNormal, subAction);
		contentP.add(submitB);
		submitB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (!nameF.getText().isBlank() && !idF.getText().isBlank() && !pwF.getText().isBlank()
						&& !checkPwF.getText().isBlank() && !hintF.getText().isBlank() && !hAnswerF.getText().isBlank()
						&& !phoneF1.getText().isBlank() && !phoneF2.getText().isBlank() && !phoneF3.getText().isBlank()
						&& !rankF.equals("") && !shopF.getText().isBlank()) {
					
					if (pwF.getText().equals(checkPwF.getText())) {

						if (pwF.getText().length() >= 8) {

							String mail;
							if (mailF1.getText().isBlank() || mailF2.getText().isBlank()) {
								mail = "";
							} else {
								mail = mailF1.getText() + "@" + mailF2.getText();
							}
							String phone = phoneF1.getText() + "-" + phoneF2.getText() + "-" + phoneF3.getText();
							String owner;

							if (rankF.equals("점장")) {
								OwnerCodeInput oc = new OwnerCodeInput();
								oc.openWindow();
								owner = oc.getCode();
							} else {
								owner = "";
							}

							if (rankF.equals("점장") && owner.equals("")) {
								String msg = "필수정보를 모두 입력해주세요";
								cm.printMsg(msg);

							} else {
								regAcc = new AccountQ();
								regAcc.registAccount(nameF.getText(), idF.getText(), checkPwF.getText(), mail, phone,
										hintF.getText(), hAnswerF.getText(), shopF.getText(), rankF, owner);
								if (regAcc.getFlg()) {
									regAcc.setFlg(false);
									dispose();
								}
							}
						} else {
							cm.printMsg("비밀번호는 8자리 이상 입력했주세요");
						}
						
					} else {
						String msg = "비밀번호가 일치하지 않습니다";
						cm.printMsg(msg);
					}

				} else {
					String msg = "필수정보를 모두 입력해주세요";
					cm.printMsg(msg);
				}

			}
		});
		
		contentP.add(backG);
	}
	
	public void settextQ(JLabel l) {
		l.setForeground(new Color(153, 102, 0));
		l.setFont(new Font("굴림", Font.BOLD, 15));
	}
	
	public void setRadio(JRadioButton jr) {
		jr.setIcon(new ImageIcon(LoginRegist.class.getResource("/loginImage/LRaidoB1.png")));
		jr.setSelectedIcon(new ImageIcon(LoginRegist.class.getResource("/loginImage/LRaidoB2.png")));
		jr.setFocusable(false);
		jr.setOpaque(false);
	}
	
	public class RadioSelect implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(rankS1.isSelected()) {
				rankF = "아르바이트";
//				System.out.println(rankF); 확인용
			}
			if(rankS2.isSelected()) {
				rankF = "매니저";
			}
			if(rankS3.isSelected()) {
				rankF = "점장";
			}
			
		}
	}
	
	public JTextField tfsetting (JTextField tf) {
		tf = tc.textClean();
		tf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(pwF.getText().isBlank() && passflg) {
					checkinfo2.setVisible(true);
					passflg = false;
				}
			}
		});
		
		return tf;
	}

}
