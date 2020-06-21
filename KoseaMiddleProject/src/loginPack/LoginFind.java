package loginPack;

import java.awt.BorderLayout;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connPack.AccFindDB;
import connPack.AccountQ;
import popUpPack.CationMsg;
import popUpPack.IDList;
import popUpPack.ResultMsg;
import popUpPack.ShopSearch;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.IntegerDocument;
import toolPack.SizeTool;
import toolPack.TextClear;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class LoginFind extends JDialog {

	Container contentP = getContentPane();

	ImageInput imageEdit = new ImageInput();
	TextClear tc = new TextClear();
	AccountQ ec = new AccountQ();
	CationMsg cm = new CationMsg();
	ResultMsg rm = new ResultMsg();

	private JTextField nameF;
	private JTextField phoneF1;
	private JTextField phoneF2;
	private JTextField phoneF3;
	private JTextField shopF;
	private JTextField idF;
	private JTextField hintF;
	private JTextField hintAF;
	private JTextField textField;

//	public static void main(String[] args) {
//		try {
//			LoginFind dialog = new LoginFind();
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void openWindow() {
		LoginFind frame = new LoginFind();
		frame.setVisible(true);
	}

	public LoginFind() {
		setSize(600, 450);// 2800 2100
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(600), st.setCenterY(450) - 50);
		setUndecorated(true);
		setModal(true);
		contentP.setLayout(null);
		addMouseMotionListener(new DragMoveDialog());

		ImageIcon panelImage = new ImageIcon("src\\loginImage\\FindingBG1.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 600, 450);

		ImageIcon xNormal = new ImageIcon("src\\loginImage\\Wxbutton1.jpg");
		ImageIcon xAction = new ImageIcon("src\\loginImage\\Wxbutton2.jpg");

		JButton xButton = new JButton();
		xButton.setBounds(559, 15, 18, 18);
		imageEdit.setButtonImage(xButton, xNormal, xAction);
		contentP.add(xButton);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		JLabel idInputL = new JLabel("ID 찾기");
		idInputL.setForeground(Color.WHITE);
		idInputL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idInputL.setBounds(485, 128, 57, 25);
		idInputL.setHorizontalAlignment(JLabel.CENTER);
		contentP.add(idInputL);

		JLabel pwInputL = new JLabel("PW 찾기");
		pwInputL.setForeground(Color.WHITE);
		pwInputL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pwInputL.setHorizontalAlignment(SwingConstants.CENTER);
		pwInputL.setBounds(470, 362, 85, 15);
		contentP.add(pwInputL);

		JLabel hintInputL = new JLabel("힌트 검색");
		hintInputL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		hintInputL.setHorizontalAlignment(SwingConstants.CENTER);
		hintInputL.setForeground(Color.WHITE);
		hintInputL.setBounds(470, 285, 85, 15);
		getContentPane().add(hintInputL);

		JLabel nameLabel = new JLabel("성명  :");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setForeground(new Color(102, 51, 0));
		nameLabel.setFont(new Font("굴림", Font.BOLD, 16));
		nameLabel.setBounds(66, 81, 65, 25);
		contentP.add(nameLabel);

		JLabel phoneLabel = new JLabel("연락처  :");
		phoneLabel.setForeground(new Color(102, 51, 0));
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneLabel.setFont(new Font("굴림", Font.BOLD, 16));
		phoneLabel.setBounds(32, 128, 99, 25);
		contentP.add(phoneLabel);

		JLabel shopLabel = new JLabel("점포코드  :");
		shopLabel.setForeground(new Color(102, 51, 0));
		shopLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		shopLabel.setFont(new Font("굴림", Font.BOLD, 16));
		shopLabel.setBounds(32, 176, 99, 25);
		contentP.add(shopLabel);

		JLabel idLabel = new JLabel("ID  :");
		idLabel.setForeground(new Color(102, 51, 0));
		idLabel.setFont(new Font("굴림", Font.BOLD, 16));
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(74, 282, 57, 25);
		contentP.add(idLabel);

		JLabel hintLabel = new JLabel("Hint  :");
		hintLabel.setForeground(new Color(102, 51, 0));
		hintLabel.setFont(new Font("굴림", Font.BOLD, 16));
		hintLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hintLabel.setBounds(46, 334, 85, 25);
		contentP.add(hintLabel);

		JLabel hintALabel = new JLabel("Hint 답변  :");
		hintALabel.setForeground(new Color(102, 51, 0));
		hintALabel.setFont(new Font("굴림", Font.BOLD, 16));
		hintALabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hintALabel.setBounds(46, 387, 85, 25);
		contentP.add(hintALabel);

		nameF = tc.textClean();
		nameF.setBounds(170, 83, 220, 21);
		contentP.add(nameF);
		nameF.setColumns(10);

		IntegerDocument id = new IntegerDocument(3);
		IntegerDocument id2 = new IntegerDocument(4);
		IntegerDocument id3 = new IntegerDocument(4);

		phoneF1 = tc.textClean();
		phoneF1.setBounds(170, 130, 40, 21);
		phoneF1.setDocument(id);
		phoneF1.setHorizontalAlignment(SwingConstants.CENTER);
		contentP.add(phoneF1);
		phoneF1.setColumns(10);

		phoneF2 = tc.textClean();
		phoneF2.setText("");
		phoneF2.setBounds(260, 130, 40, 21);
		phoneF2.setDocument(id2);
		phoneF2.setHorizontalAlignment(SwingConstants.CENTER);
		contentP.add(phoneF2);
		phoneF2.setColumns(10);

		phoneF3 = tc.textClean();
		phoneF3.setBounds(350, 130, 40, 21);
		phoneF3.setDocument(id3);
		phoneF3.setHorizontalAlignment(SwingConstants.CENTER);
		contentP.add(phoneF3);
		phoneF3.setColumns(10);

		shopF = tc.textClean();
		shopF.setText("");
		shopF.setBounds(170, 178, 158, 21);
		contentP.add(shopF);
		shopF.setColumns(10);

		idF = tc.textClean();
		idF.setBounds(170, 283, 220, 21);
		contentP.add(idF);
		idF.setColumns(10);

		hintF = tc.textClean();
		hintF.setBounds(170, 335, 220, 21);
		hintF.setEditable(false);
		contentP.add(hintF);
		hintF.setColumns(10);

		hintAF = tc.textClean();
		hintAF.setBounds(170, 388, 220, 21);
		contentP.add(hintAF);
		hintAF.setColumns(10);

		ImageIcon textBar1 = new ImageIcon("src\\loginImage\\FindTextbar1.jpg");
		ImageIcon textBar2 = new ImageIcon("src\\loginImage\\FindTextbar2.jpg");

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(160, 75, 240, 35);
		imageEdit.setPaintLabel(lblNewLabel, textBar1);
		contentP.add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel("New label");
		lblNewLabel2.setBounds(160, 122, 60, 35);
		imageEdit.setPaintLabel(lblNewLabel2, textBar1);
		contentP.add(lblNewLabel2);

		JLabel lblNewLabel2_2 = new JLabel("New label");
		lblNewLabel2_2.setBounds(250, 122, 60, 35);
		imageEdit.setPaintLabel(lblNewLabel2_2, textBar1);
		contentP.add(lblNewLabel2_2);

		JLabel lblNewLabel2_3 = new JLabel("New label");
		lblNewLabel2_3.setBounds(340, 122, 60, 35);
		imageEdit.setPaintLabel(lblNewLabel2_3, textBar1);
		contentP.add(lblNewLabel2_3);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(230, 135, 18, 15);
		contentP.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(102, 51, 0));
		lblNewLabel_2.setBounds(320, 135, 27, 15);
		contentP.add(lblNewLabel_2);

		JLabel lblNewLabel3 = new JLabel("New label");
		lblNewLabel3.setBounds(160, 170, 178, 35);
		imageEdit.setPaintLabel(lblNewLabel3, textBar1);
		contentP.add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel("New label");
		lblNewLabel4.setBounds(160, 275, 240, 35);
		imageEdit.setPaintLabel(lblNewLabel4, textBar1);
		contentP.add(lblNewLabel4);

		JLabel lblNewLabel5 = new JLabel("New label");
		lblNewLabel5.setBounds(160, 327, 240, 35);
		imageEdit.setPaintLabel(lblNewLabel5, textBar2);
		contentP.add(lblNewLabel5);

		JLabel lblNewLabel6 = new JLabel("New label");
		lblNewLabel6.setBounds(160, 380, 240, 35);
		imageEdit.setPaintLabel(lblNewLabel6, textBar1);
		contentP.add(lblNewLabel6);

		ImageIcon findNormal = new ImageIcon("src\\loginImage\\FindIDbutton1.jpg");
		ImageIcon findAction = new ImageIcon("src\\loginImage\\FindIDbutton2.jpg");
		ImageIcon findshop = new ImageIcon("src\\loginImage\\RegButton3.jpg");

		JButton shopFind = new JButton();
		shopFind.setBounds(350, 170, 50, 35);
		imageEdit.setOneImage(shopFind, findshop);
		contentP.add(shopFind);
		shopFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ShopSearch ss = new ShopSearch();
				ss.openWindow();
				shopF.setText(ss.getCode());
			}
		});

		JButton idFindB = new JButton();
		idFindB.setBounds(470, 75, 85, 130);
		imageEdit.setButtonImage(idFindB, findNormal, findAction);
		contentP.add(idFindB);
		idFindB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (!nameF.getText().isBlank() && !phoneF1.getText().isBlank() && !phoneF2.getText().isBlank()
						&& !phoneF3.getText().isBlank() && !shopF.getText().isBlank()) {
					String phone = phoneF1.getText() + "-" + phoneF2.getText() + "-" + phoneF3.getText();
					AccountQ idfind = new AccountQ();
					ArrayList<AccFindDB> list = idfind.idFind(nameF.getText(), phone, shopF.getText());
					
					if(idfind.getFlg()) {
						idfind.setFlg(false);
						IDList il = new IDList();
						il.openList(list);
						idF.setText(il.getID());
						
					} else {
						CationMsg cm = new CationMsg();
						cm.printMsg("검색결과가 없습니다");
					}

				} else {
					String msg = "필수정보를 모두 입력해주세요";
					cm.printMsg(msg);
				}

			}
		});

		ImageIcon hintNormal = new ImageIcon("src\\loginImage\\HintSearchB1.jpg");
		ImageIcon hintAction = new ImageIcon("src\\loginImage\\HintSearchB2.jpg");

		JButton hintFindB = new JButton();
		hintFindB.setBounds(470, 275, 85, 35);
		imageEdit.setButtonImage(hintFindB, hintNormal, hintAction);
		contentP.add(hintFindB);
		hintFindB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!idF.getText().isBlank()) {
					hintF.setText(ec.hintCheck(idF.getText()));
				} else {
					String msg = "ID를 입력해주세요";
					cm.printMsg(msg);
				}
			}
		});

		JButton pwFindB = new JButton();
		pwFindB.setBounds(470, 325, 85, 90);
		imageEdit.setButtonImage(pwFindB, findNormal, findAction);
		contentP.add(pwFindB);
		pwFindB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!idF.getText().isBlank() && !hintF.getText().isBlank()) {
					String result = ec.pwSearch(idF.getText(), hintAF.getText());
					rm.printMsg(result);

				} else {
					String msg = "필수정보를 모두 입력해주세요";
					cm.printMsg(msg);
				}
			}
		});

		contentP.add(backG);
	}
}
