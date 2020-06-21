package mainResultPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import connPack.MainAccountQ;
import toolPack.JTextFLimit;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class ShopPassPanel extends BasicRMP {
	
	private JPasswordField codeTF1;
	private JPasswordField codeTF2;
	private JPasswordField codeTF3;
	
	public ShopPassPanel() {
		
		JTextFLimit jf1 = new JTextFLimit(6);
		JTextFLimit jf2 = new JTextFLimit(6);
		JTextFLimit jf3 = new JTextFLimit(6);
		
		codeTF1 = tc.passClean();
		codeTF1.setBounds(180, 45, 170, 21);
		codeTF1.setDocument(jf1);
		add(codeTF1);
		codeTF1.setColumns(10);
		
		codeTF2 = tc.passClean();
		codeTF2.setBounds(180, 120, 170, 21);
		codeTF2.setDocument(jf2);
		add(codeTF2);
		codeTF2.setColumns(10);
		
		codeTF3 = tc.passClean();
		codeTF3.setBounds(180, 195, 170, 21);
		codeTF3.setDocument(jf3);
		add(codeTF3);
		codeTF3.setColumns(10);
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel codeArea1 = new JLabel("New label");
		codeArea1.setBounds(170, 35, 190, 40);
		imageEdit.setPaintLabel(codeArea1, labelBack);
		add(codeArea1);
		
		JLabel codeArea2 = new JLabel("New label");
		codeArea2.setBounds(170, 110, 190, 40);
		imageEdit.setPaintLabel(codeArea2, labelBack);
		add(codeArea2);
		
		JLabel codeArea3 = new JLabel("New label");
		codeArea3.setBounds(170, 185, 190, 40);
		imageEdit.setPaintLabel(codeArea3, labelBack);
		add(codeArea3);
		
		JLabel lblNewLabel_3 = new JLabel("���� ���� �ڵ� :  ");
		lblNewLabel_3.setForeground(new Color(102, 51, 0));
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(15, 36, 143, 40);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("������ �ڵ� :  ");
		lblNewLabel_4.setForeground(new Color(102, 51, 0));
		lblNewLabel_4.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(15, 111, 143, 40);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("���� �ڵ� Ȯ�� :  ");
		lblNewLabel_5.setForeground(new Color(102, 51, 0));
		lblNewLabel_5.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(15, 186, 143, 40);
		add(lblNewLabel_5);
	
		ImageIcon saveNormal = new ImageIcon("src\\mainIcon\\saveB1.jpg");
		ImageIcon saveAction = new ImageIcon("src\\mainIcon\\saveB2.jpg");
		
		JButton saveButton = new JButton();
		saveButton.setBounds(180, 280, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!codeTF1.getText().isBlank() && !codeTF2.getText().isBlank() && !codeTF2.getText().isBlank()) {
					
					if(codeTF1.getText().equals(ad.getUowner())) {
						
						if(codeTF2.getText().equals(codeTF3.getText())) {
							
							ck.printMsg("�����ڵ带 �����Ͻðڽ��ϱ�", "����");
							
							if(ck.getFlg()) {
								ck.setFlg(false);
								
								MainAccountQ maq = new MainAccountQ();
								maq.changeCode(codeTF3.getText());
								
								if(maq.getFlg()) {
									maq.setFlg(false);
									rm.printMsg("�ڵ庯���� �Ϸ��߽��ϴ�.");
								}
							}
							
						} else {
							cm.printMsg("�����Ͻ� �ڵ尡 ��ġ���� �ʽ��ϴ�");
						}
						
					} else {
						cm.printMsg("���� �ڵ尡 ��ġ���� �ʽ��ϴ�");
					}
					
				} else {
					cm.printMsg("�ʼ������� ��� �Է����ּ���");
				}
				
			}		
			
		});
	}
}
