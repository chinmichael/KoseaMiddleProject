package mainResultPanel;
import javax.swing.JLabel;

import javax.swing.plaf.ColorUIResource;

import connPack.ProductQ;
import connPack.TypeList;
import toolPack.IntegerDocument;
import toolPack.PersonalComboBoxUI;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ProductInputPanel extends BasicRMP {
	
	TypeList tl = new TypeList();
	private JTextField codeTF;
	private JTextField nameTF;
	private JTextField compTF;
	private JTextField priceTF;
	
	ProductQ pq = new ProductQ();
	String checkCode = "";
	
	public ProductInputPanel() {
		
		codeTF = tc.textClean();
		codeTF.setBounds(160, 20, 140, 21);
		add(codeTF);
		codeTF.setColumns(10);
		
		nameTF = tc.textClean();
		nameTF.setBounds(160, 80, 200, 21);
		add(nameTF);
		nameTF.setColumns(10);
		
		compTF = tc.textClean();
		compTF.setBounds(160, 140, 200, 21);
		add(compTF);
		compTF.setColumns(10);
		
		IntegerDocument id = new IntegerDocument(9);
		
		priceTF = tc.textClean();
		priceTF.setBounds(160, 200, 65, 21);
		priceTF.setDocument(id);
		add(priceTF);
		priceTF.setColumns(10);
		
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel codeArea = new JLabel("New label");
		codeArea.setBounds(150, 10, 160, 40);
		imageEdit.setPaintLabel(codeArea, labelBack);
		add(codeArea);
		
		JLabel nameArea = new JLabel("New label");
		nameArea.setBounds(150, 70, 220, 40);
		imageEdit.setPaintLabel(nameArea, labelBack);
		add(nameArea);
		
		JLabel compArea = new JLabel("New label");
		compArea.setBounds(150, 130, 220, 40);
		imageEdit.setPaintLabel(compArea, labelBack);
		add(compArea);
		
		JLabel priceArea = new JLabel("New label");
		priceArea.setBounds(150, 193, 85, 35);
		imageEdit.setPaintLabel(priceArea, labelBack);
		add(priceArea);
		
		Color CB = new ColorUIResource (255,238,208);
		Color SB = new ColorUIResource(242,183,113);
		
		PersonalComboBoxUI pu = new PersonalComboBoxUI();
		pu.setColorBack(CB, SB);
		PersonalComboBoxUI pu2 = new PersonalComboBoxUI();
		pu2.setColorBack(CB, SB);
		PersonalComboBoxUI pu3 = new PersonalComboBoxUI();
		pu3.setColorBack(CB, SB);
		
		String[] typeExpList = { "미선택", "장기", "00", "02", "14" };
		
		JComboBox typeExp = new JComboBox(typeExpList);
		typeExp.setFont(new Font("돋움", Font.PLAIN, 13));
		typeExp.setFocusTraversalKeysEnabled(false);
		typeExp.setFocusable(false);
		pu3.installUI(typeExp);
		typeExp.setBounds(270, 193, 100, 35);
		add(typeExp);
		
		JComboBox typeSmall = new JComboBox();
		typeSmall.setFont(new Font("돋움", Font.PLAIN, 13));
		typeSmall.addItem("소분류");
		typeSmall.setFocusTraversalKeysEnabled(false);
		typeSmall.setFocusable(false);
		pu2.installUI(typeSmall);
		typeSmall.setBounds(150, 300, 220, 35);
		add(typeSmall);
		
		JComboBox typeBig = new JComboBox(tl.listB());
		typeBig.setFocusTraversalKeysEnabled(false);
		typeBig.setFocusable(false);
		pu.installUI(typeBig);
		typeBig.setFont(new Font("돋움", Font.PLAIN, 13));
		typeBig.setBounds(150, 250, 220, 35);
		add(typeBig);
		typeBig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String) typeBig.getSelectedItem();
				
				if(type.equals("대분류")) {
					typeSmall.removeAllItems();
					typeSmall.addItem("소분류");
					
				} else {
					String[] type2 = tl.listS(type);
					typeSmall.removeAllItems();

					typeSmall.addItem("소분류");

					for (int i = 0; i < type2.length; i++) {
						typeSmall.addItem(type2[i]);
					}
				}
			}
		});

		ImageIcon reg1 = new ImageIcon("src\\loginImage\\RegButton2.jpg");

		JButton checkB = new JButton();
		checkB.setBounds(315, 10, 55, 40);
		imageEdit.setOneImage(checkB, reg1);
		add(checkB);
		checkB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!codeTF.getText().isBlank()) {

					String code = codeTF.getText();

					if (pq.proIDcheck(code)) {
						rm.printMsg("등록가능한 상품입니다");
						checkCode = code;

					} else {
						cm.printMsg("중복되는 상품이 있습니다");
					}

				} else {
					cm.printMsg("상품코드를 입력해주세요");
				}
			}
		});
		
		codeTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 는 Tab, 10은 Enter
					Toolkit.getDefaultToolkit().beep(); 

			        checkB.doClick();
				}
			}
		});
		
		ImageIcon inputNormal = new ImageIcon("src\\mainIcon\\inputLB1.jpg");
		ImageIcon inputAction = new ImageIcon("src\\mainIcon\\inputLB2.jpg");
		
		JButton inputB = new JButton();
		inputB.setBounds(50, 355, 320, 50);
		imageEdit.setButtonImage(inputB, inputNormal, inputAction);
		add(inputB);
		inputB.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				String typeE = (String) typeExp.getSelectedItem();
				String type1 = (String) typeBig.getSelectedItem();
				String type2 = (String) typeSmall.getSelectedItem();
				
				if(!codeTF.getText().isBlank() && !nameTF.getText().isBlank() && !compTF.getText().isBlank() && !priceTF.getText().isBlank() && !typeE.equals("미선택") && !type1.equals("대분류") && !type2.equals("소분류")) {
					
					if (codeTF.getText().equals(checkCode)) {
						
						pq.inputProduct(codeTF.getText(), nameTF.getText(), compTF.getText(), priceTF.getText(), type1, type2, typeE);
						
						if(pq.getFlg()) {
							pq.setFlg(false);
							rm.printMsg("상품등록을 완료했습니다");
							
						} else {
							cm.printMsg("상품등록을 실패했습니다");
							
						}
						
					} else {
						cm.printMsg("상품코드 중복체크를 해주세요");
					}
					
				} else {
					cm.printMsg("필수정보를 모두 입력해주세요");
				}
			}
			
		});
		
		
		JLabel lblNewLabel = new JLabel("상품코드 :  ");
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 15, 88, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("상품명 :  ");
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(50, 75, 88, 30);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("브랜드 :  ");
		lblNewLabel_2.setForeground(new Color(102, 51, 0));
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(50, 135, 88, 30);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("가격 / 폐기타입 :  ");
		lblNewLabel_3.setForeground(new Color(102, 51, 0));
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 195, 138, 30);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("분류 :  ");
		lblNewLabel_4.setForeground(new Color(102, 51, 0));
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(50, 252, 88, 30);
		add(lblNewLabel_4);

	}
}
