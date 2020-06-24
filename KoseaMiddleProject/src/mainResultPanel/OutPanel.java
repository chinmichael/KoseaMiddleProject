package mainResultPanel;
import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import connPack.MainAccountQ;
import loginPack.LoginHome;
import mainPack.MainHome;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class OutPanel extends BasicRMP {
	
	private JPasswordField passCheck;
	
	public OutPanel() {
		
		passCheck = tc.passClean();
		passCheck.setBounds(160, 120, 180, 21);
		add(passCheck);
		passCheck.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("계정을 삭제하시겠습니까?");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 30, 396, 44);
		add(lblNewLabel);
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel pwArea = new JLabel("New label");
		pwArea.setBounds(150, 110, 200, 40);
		imageEdit.setPaintLabel(pwArea, labelBack);
		add(pwArea);
		
		JLabel lblNewLabel_2 = new JLabel("PW 확인 :  ");
		lblNewLabel_2.setForeground(new Color(102, 51, 0));
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(60, 112, 80, 40);
		add(lblNewLabel_2);
		
		ImageIcon outNormal = new ImageIcon("src\\mainIcon\\outB1.jpg");
		ImageIcon outAction = new ImageIcon("src\\mainIcon\\outB2.jpg");
		
		JLabel explain = new JLabel("탈퇴");
		explain.setBounds(186, 267, 48, 20);
		imageEdit.setHint(explain);
		add(explain);
		
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(false);
			}
		});
		
		JButton outButton = new JButton();
		outButton.setBounds(180, 200, 60, 60);
		imageEdit.setButtonImage(outButton, outNormal, outAction);
		add(outButton);
		
		outButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				ck.printMsg("계정을 삭제하시겠습니까", "삭제");
				
				if(ck.getFlg()) {
					ck.setFlg(false);
					
					if(passCheck.getText().equals(ad.getUpw())) {
						
						MainAccountQ maq = new MainAccountQ();
						maq.deleteAcc();
						if(maq.getFlg()) {
							maq.setFlg(false);
							rm.printMsg("계정삭제가 완료 되었습니다");
							LoginHome lh = new LoginHome();
							lh.openWindow();
							MainHome mh = new MainHome();
							mh.diposeMain();
						}
						
					} else {
						cm.printMsg("비밀번호가 일치하지 않습니다.");
					}
					
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(true);

			}
		});
		
	}
}
