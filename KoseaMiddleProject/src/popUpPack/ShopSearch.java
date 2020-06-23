package popUpPack;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import connPack.ShopDB;
import connPack.ShopQ;
import loginPack.LoginRegist;
import toolPack.*;

public class ShopSearch extends JDialog {
	
	static String shopCode;
	Container contentP = getContentPane();
	private JTextField shopName;
	
	ImageInput imageEdit = new ImageInput();
	TextClear tc = new TextClear();
	
	public String getCode() {
		return shopCode;
	}
	
	public void openWindow() {
		ShopSearch frame = new ShopSearch();
		frame.setVisible(true);
	}
	
	public ShopSearch() {
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
		
		JLabel msgAccount = new JLabel("점포명을 입력해주세요");
		msgAccount.setForeground(new Color(153, 102, 0));
		msgAccount.setFont(new Font("굴림", Font.BOLD, 15));
		msgAccount.setBounds(70, 39, 160, 63);
		contentP.add(msgAccount);
		
		shopName = tc.textClean();
		shopName.setBounds(31, 109, 195, 25);
		contentP.add(shopName);
		shopName.setColumns(10);
		
		ImageIcon inputArea1 = new ImageIcon("src\\loginImage\\RegInputBar.jpg");
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(23, 104, 207, 35);
		imageEdit.setPaintLabel(lblNewLabel_12, inputArea1);
		contentP.add(lblNewLabel_12);

		ImageIcon reg3 = new ImageIcon("src\\loginImage\\RegButton3.jpg");
		JButton searchShop = new JButton();
		searchShop.setBounds(230, 104, 53, 35);
		imageEdit.setOneImage(searchShop, reg3);
		contentP.add(searchShop);
		searchShop.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String searchName = shopName.getText();

				if (searchName.equals("")) {
					CationMsg cm = new CationMsg();
					String msg = "점포명을 입력해주세요";
					cm.printMsg(msg);
				} else {
					ShopQ sq = new ShopQ();
					ArrayList<ShopDB> list = sq.list(searchName);
					
					ShopList sWin = new ShopList();
					sWin.openList(list, searchName);
					
					if (sWin.getFlg()) {
						shopCode = sWin.getCode();
						sWin.setFlg(false);
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
				dispose();
			}
		});
		
		
		contentP.add(backG);

	}
}