package mainResultPanel;
import javax.swing.JLabel;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;

import connPack.ProIDList;
import connPack.StockQ;
import mainPopUp.StockInputPop;
import toolPack.DateTool;
import toolPack.IntegerDocument;

import javax.swing.JTextField;

public class StockInputPanel extends BasicRMP {
	
	private JTextField nameTF;
	private JTextField codeTF;
	private JTextField locTF;
	private JTextField expTF;
	private JTextField stockTF;
	
	boolean isChecked = false;
	String checkCode = "";
	
	JLabel expType;
	
	DateTool dt = new DateTool();
	StockQ sq = new StockQ();
	
	public StockInputPanel() {
		
		nameTF = tc.textClean();
		nameTF.setBounds(158, 30, 148, 21);
		add(nameTF);
		nameTF.setColumns(10);
		setExpVis(nameTF);
		
		codeTF = tc.textClean();
		codeTF.setBounds(158, 95, 148, 21);
		add(codeTF);
		codeTF.setColumns(10);
		setExpVis(codeTF);
		
		locTF = tc.textClean();
		locTF.setBounds(158, 160, 248, 21);
		add(locTF);
		locTF.setColumns(10);
		setExpVis(locTF);
		
		expType = new JLabel("YYYY/MM/DD 형식");
		expType.setForeground(Color.LIGHT_GRAY);
		expType.setFont(new Font("굴림", Font.BOLD, 13));
		expType.setHorizontalAlignment(SwingConstants.CENTER);
		expType.setBounds(157, 230, 126, 15);
		add(expType);
		
		locTF.setFocusTraversalKeysEnabled(false);
		locTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 9) {  //keyCode() == 9 는 Tab, 10은 Enter
					expTF.requestFocus();
					
					expType.setVisible(false);
				}
			}
		});
		
		expTF = tc.textClean();
		expTF.setBounds(158, 225, 138, 21);
		add(expTF);
		expTF.setColumns(10);
		expTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expType.setVisible(false);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(expTF.getText().isBlank() && !expTF.isCursorSet()) {
					expType.setVisible(true);
				}
			}
		});
		
		expTF.setFocusTraversalKeysEnabled(false);
		expTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 9) {  //keyCode() == 9 는 Tab, 10은 Enter
					stockTF.requestFocus();
					
					if(expTF.getText().isBlank()) {
						expType.setVisible(true);
					}
				}
			}
		});
		
		IntegerDocument id = new IntegerDocument(8);
		
		stockTF = tc.textClean();
		stockTF.setBounds(328, 225, 38, 21);
		stockTF.setDocument(id);
		add(stockTF);
		stockTF.setColumns(10);
		setExpVis(stockTF);
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel nameArea = new JLabel("New label");
		nameArea.setBounds(150, 20, 160, 40);
		imageEdit.setPaintLabel(nameArea, labelBack);
		add(nameArea);
		
		JLabel codeArea = new JLabel("New label");
		codeArea.setBounds(150, 85, 160, 40);
		imageEdit.setPaintLabel(codeArea, labelBack);
		add(codeArea);
		
		JLabel locArea = new JLabel("New label");
		locArea.setBounds(150, 150, 220, 40);
		imageEdit.setPaintLabel(locArea, labelBack);
		add(locArea);
		
		JLabel expArea = new JLabel("New label");
		expArea.setBounds(150, 215, 150, 40);
		imageEdit.setPaintLabel(expArea, labelBack);
		add(expArea);
		
		JLabel stockArea = new JLabel("New label");
		stockArea.setBounds(320, 215, 50, 40);
		imageEdit.setPaintLabel(stockArea, labelBack);
		add(stockArea);
		
		JLabel lblNewLabel = new JLabel("코드검색 :  ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 30, 88, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("상품코드 :  ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 95, 88, 27);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("상품위치        :  ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(102, 51, 0));
		lblNewLabel_2.setBounds(12, 160, 126, 27);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("(선택)");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(new Color(204, 0, 0));
		lblNewLabel_4.setBounds(88, 167, 35, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("유통기한 / 재고 :  ");
		lblNewLabel_3.setForeground(new Color(102, 51, 0));
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 225, 138, 27);
		add(lblNewLabel_3);
		
		
		ImageIcon reg1 = new ImageIcon("src\\loginImage\\RegButton2.jpg");
		ImageIcon reg2 = new ImageIcon("src\\loginImage\\RegButton3.jpg");
		
		JButton findB = new JButton();
		findB.setBounds(315, 20, 55, 40);
		imageEdit.setOneImage(findB, reg2);
		add(findB);
		findB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ProIDList> list = sq.codeList(nameTF.getText());
				if(sq.getFlg()) {
					sq.setFlg(false);
					StockInputPop sip = new StockInputPop();
					sip.openList(list);
					
					codeTF.setText(sip.getCodeP());
					
				} else {
					cm.printMsg("검색결과가 없습니다");
				}
			}
		});
		
		nameTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 는 Tab, 10은 Enter
					Toolkit.getDefaultToolkit().beep(); 

			        findB.doClick();
				}
			}
		});
		
		JButton checkB = new JButton();
		checkB.setBounds(315, 85, 55, 40);
		imageEdit.setOneImage(checkB, reg1);
		add(checkB);
		checkB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int check = sq.checkStock(codeTF.getText());

				if (check == 0) {
					cm.printMsg("존재하지 않는 상품입니다");
				} else if (check == 1) {
					cm.printMsg("중복되는 상품입니다");
				} else {
					rm.printMsg("등록가능한 상품입니다");
					checkCode = codeTF.getText();
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
		inputB.setBounds(50, 310, 320, 50);
		imageEdit.setButtonImage(inputB, inputNormal, inputAction);
		add(inputB);
		inputB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!codeTF.getText().isBlank() && !expTF.getText().isBlank() && !stockTF.getText().isBlank()) {
					
					if(codeTF.getText().equals(checkCode)) {
						
						if(dt.vildationDate(expTF.getText())) {
							
							int stock = Integer.parseInt(stockTF.getText());
							if(stock < 0) {
								cm.printMsg("재고수량이 유효하지 않습니다");
								
							} else {
								sq.insertStock(codeTF.getText(), expTF.getText(), locTF.getText(), stock, shopID);
								
								if(sq.getFlg()) {
									rm.printMsg("등록을 완료했습니다");
								} else {
									rm.printMsg("상품등록을 실패했습니다");
								}
							}
							
						} else {
							cm.printMsg("유효기간 형식을 확인해주세요");
						}
						
					} else {
						cm.printMsg("상품코드 검사를 해주세요");
					}
					
				} else {
					cm.printMsg("필수정보를 모두 입력하세요");
				}
				
			}
		});
		
		
		stockTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 는 Tab, 10은 Enter
					Toolkit.getDefaultToolkit().beep(); 

			        inputB.doClick();
				}
			}
		});
	}
	
	public void setExpVis(JTextField jt) {
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(expTF.getText().isBlank()) {
					expType.setVisible(true);
				}
			}
		});
	}
	
}
