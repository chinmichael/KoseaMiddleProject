package mainResultPanel;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import connPack.MainAccountQ;
import toolPack.IntegerDocument;

import javax.swing.JTextField;

public class PhoneChangePanel extends BasicRMP {
	private JTextField phoneTF1;
	private JTextField phoneTF2;
	private JTextField phoneTF3;
	private JTextField mailTF1;
	private JTextField mailTF2;

	public PhoneChangePanel() {
		
		IntegerDocument id1 = new IntegerDocument(3);
		IntegerDocument id2 = new IntegerDocument(4);
		IntegerDocument id3 = new IntegerDocument(4);
		
		phoneTF1 = tc.textClean();
		phoneTF1.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTF1.setBounds(85, 70, 50, 21);
		phoneTF1.setDocument(id1);
		add(phoneTF1);
		phoneTF1.setColumns(10);
		
		phoneTF2 = tc.textClean();
		phoneTF2.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTF2.setBounds(185, 70, 50, 21);
		phoneTF2.setDocument(id2);
		add(phoneTF2);
		phoneTF2.setColumns(10);
		
		phoneTF3 = tc.textClean();
		phoneTF3.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTF3.setBounds(285, 70, 50, 21);
		phoneTF3.setDocument(id3);
		add(phoneTF3);
		phoneTF3.setColumns(10);
		
		String currentPhone = ad.getUphone();
		String[] cpArray = currentPhone.split("-");
		
		phoneTF1.setText(cpArray[0]);
		phoneTF2.setText(cpArray[1]);
		phoneTF3.setText(cpArray[2]);
		
		mailTF1 = tc.textClean();
		mailTF1.setBounds(85, 180, 100, 21);
		mailTF1.setHorizontalAlignment(SwingConstants.CENTER);
		add(mailTF1);
		mailTF1.setColumns(10);
		
		mailTF2 = tc.textClean();
		mailTF2.setBounds(235, 180, 100, 21);
		mailTF2.setHorizontalAlignment(SwingConstants.CENTER);
		add(mailTF2);
		mailTF2.setColumns(10);
		
		String currentMail = ad.getUmail();
		
		if (currentMail != null) {
			String[] cmArray = currentMail.split("@");
			
			if(cmArray.length == 2) {
				mailTF1.setText(cmArray[0]);
				mailTF2.setText(cmArray[1]);
			}
		}
		
		
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(80, 60, 60, 40);
		imageEdit.setPaintLabel(lblNewLabel, labelBack);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(180, 60, 60, 40);
		imageEdit.setPaintLabel(lblNewLabel_1, labelBack);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(280, 60, 60, 40);
		imageEdit.setPaintLabel(lblNewLabel_2, labelBack);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(80, 170, 110, 40);
		imageEdit.setPaintLabel(lblNewLabel_3, labelBack);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(230, 170, 110, 40);
		imageEdit.setPaintLabel(lblNewLabel_4, labelBack);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("연락처 변경 :");
		lblNewLabel_5.setForeground(new Color(102, 51, 0));
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_5.setBounds(80, 10, 140, 40);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail 변경 :");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(102, 51, 0));
		lblNewLabel_6.setBounds(80, 120, 140, 40);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("@");
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_7.setForeground(new Color(102, 51, 0));
		lblNewLabel_7.setBounds(200, 172, 30, 40);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("-");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_8.setForeground(new Color(102, 51, 0));
		lblNewLabel_8.setBounds(142, 62, 30, 40);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("-");
		lblNewLabel_9.setForeground(new Color(102, 51, 0));
		lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(242, 62, 30, 40);
		add(lblNewLabel_9);
		
		JLabel explain = new JLabel("저장");
		explain.setBounds(188, 325, 45, 20);
		imageEdit.setHint(explain);
		add(explain);
		
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(false);
			}
		});
		
		
		ImageIcon saveNormal = new ImageIcon("src\\mainIcon\\saveB1.jpg");
		ImageIcon saveAction = new ImageIcon("src\\mainIcon\\saveB2.jpg");

		JButton saveButton = new JButton();
		saveButton.setBounds(180, 255, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		
		saveButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				if(!phoneTF1.getText().isBlank() && !phoneTF2.getText().isBlank() && !phoneTF3.getText().isBlank()) {
					
					if((mailTF1.getText().isBlank() && !mailTF2.getText().isBlank()) || (!mailTF1.getText().isBlank() && mailTF2.getText().isBlank())) {
						cm.printMsg("메일주소 형식을 올바르게 맞춰주세요");
					
					} else {
						
						ck.printMsg("연락처를 변경하시겠습니까", "확인");
						
						if(ck.getFlg()) {
							
							String lastPhone = phoneTF1.getText() + "-" + phoneTF2.getText() + "-" + phoneTF3.getText();
							String lastMail = mailTF1.getText() + "@" + mailTF2.getText();
							
							MainAccountQ maq = new MainAccountQ();
							maq.changeAdress(lastPhone, lastMail);
							
							if(maq.getFlg()) {
								maq.setFlg(false);
								ad.setPhone(lastPhone);
								ad.setMail(lastMail);
								rm.printMsg("연락처 변경이 완료되었습니다");
							}
							
						}
						
					}
					
				} else {
					cm.printMsg("연락처를 반드시 입력해 주세요");
				}
				
			}
			
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(true);

			}
		});
		
		
	}
}
