package popUpPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;
import javax.swing.SwingConstants;

public class RegistClear extends JDialog {
	
	Container contentP = getContentPane();
	ImageInput imageEdit = new ImageInput();
	private static boolean flg = false;
	
	public boolean getFlg() {
		return flg;
	}
	
	public void setFlg(boolean flg) {
		this.flg = false;
	}
	
	public void printMsg() {
		RegistClear frame = new RegistClear();
		frame.setVisible(true);
	}

	public RegistClear() {
		setSize(300, 180); //2400 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(300), st.setCenterY(180) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\ResultBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 300, 180);
		
		JLabel buttonMsg = new JLabel("확인");
		buttonMsg.setForeground(Color.WHITE);
		buttonMsg.setFont(new Font("굴림", Font.BOLD, 15));
		buttonMsg.setBounds(136, 130, 33, 22);
		contentP.add(buttonMsg);
		
		JLabel lblNewLabel = new JLabel(" 계정등록을 완료했습니다");
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 67, 280, 22);
		contentP.add(lblNewLabel);
		
		ImageIcon cnormal = new ImageIcon("src\\warningImage\\Wbutton1.jpg");
		ImageIcon caction = new ImageIcon("src\\warningImage\\Wbutton2.jpg");
		JButton checkOK = new JButton();
		checkOK.setBounds(102, 123, 97, 31);
		contentP.add(checkOK);
		imageEdit.setButtonImage(checkOK, cnormal, caction);
		checkOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				flg= true;
				dispose();
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
				flg = true;
				dispose();
			}
		});
		
		contentP.add(backG);
	}
}
