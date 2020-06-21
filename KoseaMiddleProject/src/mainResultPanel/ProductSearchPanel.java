package mainResultPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;

import connPack.ProductQ;
import connPack.ProductSearchDB;
import connPack.SearchStockDB;
import connPack.StockQ;
import connPack.TypeList;
import mainPopUp.ProductSearchPop;
import mainPopUp.StockSearchPop;
import toolPack.PersonalComboBoxUI;
import toolPack.TextClear;

public class ProductSearchPanel extends BasicRMP {
	
	TypeList tl = new TypeList();
	
	private JTextField codeTF;
	private JTextField nameTF;
	private JTextField comTF;
	
	public ProductSearchPanel() {
		
		codeTF = tc.textClean();
		codeTF.setBounds(160, 20, 200, 21);
		add(codeTF);
		codeTF.setColumns(10);
		
		nameTF = tc.textClean();
		nameTF.setBounds(160, 85, 200, 21);
		add(nameTF);
		nameTF.setColumns(10);
		
		comTF = tc.textClean();
		comTF.setBounds(160, 150, 200, 21);
		add(comTF);
		comTF.setColumns(10);
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel codeArea = new JLabel("New label");
		codeArea.setBounds(150, 10, 220, 40);
		imageEdit.setPaintLabel(codeArea, labelBack);
		add(codeArea);
		
		JLabel nameArea = new JLabel("New label");
		nameArea.setBounds(150, 75, 220, 40);
		imageEdit.setPaintLabel(nameArea, labelBack);
		add(nameArea);
		
		JLabel brandArea = new JLabel("New label");
		brandArea.setBounds(150, 140, 220, 40);
		imageEdit.setPaintLabel(brandArea, labelBack);
		add(brandArea);
		
		Color CB = new ColorUIResource (255,238,208);
		Color SB = new ColorUIResource(242,183,113);
		
		PersonalComboBoxUI pu = new PersonalComboBoxUI();
		pu.setColorBack(CB, SB);
		PersonalComboBoxUI pu2 = new PersonalComboBoxUI();
		pu2.setColorBack(CB, SB);
		
		JComboBox typeSmall = new JComboBox();
		typeSmall.setFont(new Font("����", Font.PLAIN, 13));
		typeSmall.addItem("�Һз�");
		typeSmall.setFocusTraversalKeysEnabled(false);
		typeSmall.setFocusable(false);
		pu2.installUI(typeSmall);
		typeSmall.setBounds(150, 265, 220, 35);
		add(typeSmall);
		
		JComboBox typeBig = new JComboBox(tl.listB());
		typeBig.setFocusTraversalKeysEnabled(false);
		typeBig.setFocusable(false);
		pu.installUI(typeBig);
		typeBig.setFont(new Font("����", Font.PLAIN, 13));
		typeBig.setBounds(150, 205, 220, 35);
		add(typeBig);
		typeBig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String) typeBig.getSelectedItem();
				
				if(type.equals("��з�")) {
					typeSmall.removeAllItems();
					typeSmall.addItem("�Һз�");
					
				} else {
					String[] type2 = tl.listS(type);
					typeSmall.removeAllItems();
					
					typeSmall.addItem("�Һз�");
					
					for(int i = 0; i < type2.length; i++) {
						typeSmall.addItem(type2[i]);
					}
				}
			}
		});
		
		ImageIcon searchNormal = new ImageIcon("src\\mainIcon\\searchLB1.jpg");
		ImageIcon searchAction = new ImageIcon("src\\mainIcon\\searchLB2.jpg");
		
		JButton searchB = new JButton();
		searchB.setBounds(50, 330, 320, 50);
		imageEdit.setButtonImage(searchB, searchNormal, searchAction);
		add(searchB);
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductQ pq = new ProductQ();
				
				String code = codeTF.getText();
				String name = nameTF.getText();
				String brand = comTF.getText();
				
				String type;
				String type2;
				int check;
				
				String bigType = (String) typeBig.getSelectedItem();
				String smallType = (String) typeSmall.getSelectedItem();

				if (smallType.equals("�Һз�") && bigType.equals("��з�")) {
					type = "";
					type2 = "";
					check = 0;

				} else if (smallType.equals("�Һз�")) {
					type = bigType;
					type2 = "";
					check = 1;

				} else {
					type = bigType;
					type2 = smallType;
					check = 2;
				}

				ArrayList<ProductSearchDB> list = pq.productList(code, name, brand, type, type2, check);
				
				if(pq.getFlg()) {
					ProductSearchPop psp = new ProductSearchPop();
					psp.openList(list);
					pq.setFlg(false);
					
				} else {
					cm.printMsg("�˻������ �����ϴ�");
					
				}
				
				
			}
		});
		
		codeTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 �� Tab, 10�� Enter
					Toolkit.getDefaultToolkit().beep(); 

			        searchB.doClick();
				}
			}
		});
		
		nameTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 �� Tab, 10�� Enter
					Toolkit.getDefaultToolkit().beep(); 

			        searchB.doClick();
				}
			}
		});
		
		
		comTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 �� Tab, 10�� Enter
					Toolkit.getDefaultToolkit().beep(); 

			        searchB.doClick();
				}
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("��ǰ�ڵ� :   ");
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 20, 88, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��ǰ�� :   ");
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(50, 85, 88, 27);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�귣�� :   ");
		lblNewLabel_2.setForeground(new Color(102, 51, 0));
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(50, 150, 88, 27);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�з� :   ");
		lblNewLabel_3.setForeground(new Color(102, 51, 0));
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(50, 210, 88, 27);
		add(lblNewLabel_3);
		
		
		
	}

}
