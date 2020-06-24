package mainResultPanel;
import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import connPack.MainAccountQ;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class PassChangePanel extends BasicRMP {
	private JPasswordField currentPT;
	private JPasswordField changePT;
	private JPasswordField changePCT;
	private JTextField changeHT;
	private JTextField changeHAT;
	
	public PassChangePanel() {
		
		currentPT = tc.passClean();
		currentPT.setBounds(160, 20, 200, 21);
		add(currentPT);
		currentPT.setColumns(10);
		
		changePT = tc.passClean();
		changePT.setBounds(160, 85, 200, 21);
		add(changePT);
		changePT.setColumns(10);
		
		changePCT = tc.passClean();
		changePCT.setBounds(160, 150, 200, 21);
		add(changePCT);
		changePCT.setColumns(10);
		
		changeHT = tc.textClean();
		changeHT.setBounds(160, 215, 200, 21);
		add(changeHT);
		changeHT.setColumns(10);
		changeHT.setText(ad.getUhint());
		
		changeHAT = tc.textClean();
		changeHAT.setBounds(160, 280, 200, 21);
		add(changeHAT);
		changeHAT.setColumns(10);
		changeHAT.setText(ad.getUanswer());
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel currentPA = new JLabel("New label");
		currentPA.setBounds(150, 10, 220, 40);
		imageEdit.setPaintLabel(currentPA, labelBack);
		add(currentPA);
		
		JLabel changePA = new JLabel("New label");
		changePA.setBounds(150, 75, 220, 40);
		imageEdit.setPaintLabel(changePA, labelBack);
		add(changePA);
		
		JLabel checkPA = new JLabel("New label");
		checkPA.setBounds(150, 140, 220, 40);
		imageEdit.setPaintLabel(checkPA, labelBack);
		add(checkPA);
		
		JLabel hintA = new JLabel("New label");
		hintA.setBounds(150, 205, 220, 40);
		imageEdit.setPaintLabel(hintA, labelBack);
		add(hintA);
		
		JLabel hintAA = new JLabel("New label");
		hintAA.setBounds(150, 270, 220, 40);
		imageEdit.setPaintLabel(hintAA, labelBack);
		add(hintAA);
		
		JLabel lblNewLabel_4 = new JLabel("���� PW :  ");
		lblNewLabel_4.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(102, 51, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(12, 20, 126, 27);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("������ PW :  ");
		lblNewLabel_5.setForeground(new Color(102, 51, 0));
		lblNewLabel_5.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(12, 85, 126, 27);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("������ PW Ȯ�� :  ");
		lblNewLabel_6.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(102, 51, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(0, 150, 138, 27);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("������ Hint :  ");
		lblNewLabel_7.setForeground(new Color(102, 51, 0));
		lblNewLabel_7.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(0, 215, 138, 27);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("������ Hint �� :  ");
		lblNewLabel_8.setForeground(new Color(102, 51, 0));
		lblNewLabel_8.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(12, 280, 126, 27);
		add(lblNewLabel_8);
		
		JLabel explain = new JLabel("����");
		explain.setBounds(248, 330, 45, 20);
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
		saveButton.setBounds(180, 335, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!currentPT.getText().isBlank() && !changePT.getText().isBlank() && !changePCT.getText().isBlank()
						&& !changeHT.getText().isBlank() && !changeHAT.getText().isBlank()) {

					if (currentPT.getText().equals(ad.getUpw())) {

						if (changePT.getText().length() >= 8) {

							if (changePT.getText().equals(changePCT.getText())) {

								if (!currentPT.getText().equals(changePCT.getText())) {

									ck.printMsg("��й�ȣ�� �����Ͻðڽ��ϱ�", "Ȯ��");

									if (ck.getFlg()) {
										ck.setFlg(false);

										MainAccountQ maq = new MainAccountQ();
										maq.changePW(changePCT.getText(), changeHT.getText(), changeHAT.getText());

										if (maq.getFlg()) {
											maq.setFlg(false);
											ad.setPW(changePCT.getText());
											ad.setHint(changeHT.getText());
											ad.setAnswer(changeHAT.getText());
											rm.printMsg("��й�ȣ ������ �Ϸ��߽��ϴ�");
										} else {
											cm.printMsg("���������� �����߽��ϴ�");
										}
									}
								} else {
									cm.printMsg("�����Ͻ� PW�� ������ �����ϴ�");
								}

							} else {
								cm.printMsg("�����Ͻ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�");
							}

						} else {
							cm.printMsg("��й�ȣ�� 8�ڸ� �̻��̾�� �մϴ�");
						}
						
					} else {
						cm.printMsg("���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�");
					}
					
				} else {
					cm.printMsg("�ʼ������� ��� �Է����ּ���");
				}
				
			}
			
		});
		
		saveButton.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(true);

			}
			
		});
		
		
	}
}
