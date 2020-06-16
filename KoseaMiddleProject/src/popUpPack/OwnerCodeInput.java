package popUpPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connPack.ShopDB;
import connPack.ShopQ;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;
import toolPack.TextClear;

public class OwnerCodeInput extends JDialog {

	Container contentP = getContentPane();
	JPasswordField ownerC = new JPasswordField();
	static String ownerCode = "";
	
	ImageInput imageEdit = new ImageInput();
	TextClear tc = new TextClear();
	CationMsg cm = new CationMsg();
	
	public String getCode() {
		return ownerCode;
	}
	
	public void openWindow() {
		OwnerCodeInput frame = new OwnerCodeInput();
		frame.setVisible(true);
	}
	
	public OwnerCodeInput() {
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
		
		JLabel msgAccount = new JLabel("6�ڸ� ���� �ڵ带 �Է����ּ���");
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("����", Font.BOLD, 15));
		msgAccount.setBounds(23, 39, 260, 63);
		msgAccount.setHorizontalAlignment(JLabel.CENTER);
		contentP.add(msgAccount);
		
		ownerC = tc.passClean();
		ownerC.setBounds(31, 109, 195, 25);
		contentP.add(ownerC);
		ownerC.setColumns(10);
		
		ImageIcon inputArea1 = new ImageIcon("src\\loginImage\\RegInputBar.jpg");
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(23, 104, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_12, inputArea1);
		contentP.add(lblNewLabel_12);

		ImageIcon reg3 = new ImageIcon("src\\loginImage\\RegButton2.jpg");
		JButton searchShop = new JButton();
		searchShop.setBounds(230, 104, 53, 35);
		imageEdit.setOneImage(searchShop, reg3);
		contentP.add(searchShop);
		searchShop.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String inputCode = ownerC.getText();
				
				if(inputCode.length() != 6) {
					String msg = "6�ڸ��� �Է����ּ���";
					cm.printMsg(msg);
				} else {
					ownerCode = inputCode;
					dispose();
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
				dispose();
			}
		});
		
		
		contentP.add(backG);

	}

}
