package popUpPack;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

import connPack.AccountQ;
import loginPack.LoginRegist;
import toolPack.*;

public class OverCheck extends JDialog {
	
	Container contentP = getContentPane();
	private static JTextField idF;
	
	ImageInput imageEdit = new ImageInput();
	TextClear tc = new TextClear();
	CheckMsg ck  = new CheckMsg();
	CationMsg cm = new CationMsg();
	
	
	public String getID() {
		return idF.getText();
	}
	
	public void openWindow() {
		OverCheck frame = new OverCheck();
		frame.setVisible(true);
	}
	
	public OverCheck() {
		setSize(300, 180); //2400 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(300), st.setCenterY(180) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\CationBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 300, 180);
		
		JLabel msgAccount = new JLabel("���̵� �ߺ�üũ�� ���ּ���");
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("����", Font.BOLD, 15));
		msgAccount.setBounds(55, 39, 190, 63);
		contentP.add(msgAccount);
		
		idF = tc.textClean();
		idF.setBounds(31, 109, 195, 25);
		contentP.add(idF);
		idF.setColumns(10);
		
		ImageIcon inputArea1 = new ImageIcon("src\\loginImage\\RegInputBar.jpg");
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(23, 104, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_12, inputArea1);
		contentP.add(lblNewLabel_12);
		
		LoginRegist lR = new LoginRegist();
		ImageIcon reg1 = new ImageIcon("src\\loginImage\\RegButton2.jpg");
		JButton overlap = new JButton();
		overlap.setBounds(230, 104, 53, 35);
		imageEdit.setOneImage(overlap, reg1);
		contentP.add(overlap);
		overlap.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String idInput = idF.getText();

				if (idInput.length() < 6) {
					String msg = "ID�� 6�ڸ� �̻��� �Է����ּ���";
					CationMsg cm = new CationMsg();
					cm.printMsg(msg);

				} else {
					AccountQ ex = new AccountQ();
					boolean flg = ex.idcheck(idInput);

					if (flg == false) {
						cm.printMsg("�ߺ��Ǵ� ID�� �ֽ��ϴ�");
						idF.setText("");
					} else {
						ck.printMsg("��밡���� ID�Դϴ�", "���");
					}
					
					if(ck.getFlg()) {
						ck.setFlg(false);
						dispose();
					}
				}
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
				idF.setText("");
				dispose();
			}
		});
		
		
		contentP.add(backG);

	}
}
