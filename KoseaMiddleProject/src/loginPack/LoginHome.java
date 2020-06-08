package loginPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import toolPack.*;

public class LoginHome extends JFrame {
	
	ImageInput imageEdit = new ImageInput();
	private JTextField fieldID;
	private JTextField fieldPW;

	public static void main(String[] args) {

		try {
			LoginHome frame = new LoginHome();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LoginHome() {
		setSize(380, 600);
		setResizable(false);
		setLocation(600, 200);
		setUndecorated(true);
		getContentPane().setLayout(null);
		addMouseMotionListener(new MouseMotionListener() {
			int xDrag, yDrag, xPress, yPress;
			
			@Override
			public void mouseDragged(MouseEvent e) {
				xDrag = e.getX();
				yDrag = e.getY();
				JFrame sframe = (JFrame) e.getSource();
				sframe.setLocation(sframe.getLocation().x +  xDrag - xPress, sframe.getLocation().y +  yDrag - yPress);
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				xPress = e.getX();
				yPress = e.getY();
			}
			
		});
		
		ImageIcon panelImage = new ImageIcon("src\\imagePack\\LoginBG1.png");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 380, 600);
		
		JButton xbutton = new JButton();
		xbutton.setLocation(348, 10);
		getContentPane().add(xbutton);
		xbutton.setSize(20, 20);
		xbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ImageIcon xnormal = new ImageIcon("src\\imagePack\\Xbutton1.png");
		ImageIcon xaction = new ImageIcon("src\\imagePack\\Xbutton2.png");
		imageEdit.setButtonImage(xbutton, xnormal, xaction);
		
		
		JButton loginB = new JButton();
		loginB.setBounds(63, 402, 254, 41);
		getContentPane().add(loginB);
		
		
		ImageIcon lnormal = new ImageIcon("src\\imagePack\\Lbutton1.png");
		ImageIcon laction = new ImageIcon("src\\imagePack\\Lbutton2.png");
		imageEdit.setButtonImage(loginB, lnormal, laction);
		
		
		fieldID = new JTextField("ID를 입력하세요") {
			public void setBorder(Border border) {	
			}
		}; // 익명클래스로 텍스트 테두리 제거
		fieldID.setBounds(70, 295, 240, 31);
		fieldID.setOpaque(false);
		getContentPane().add(fieldID);
		fieldID.setColumns(10);
		fieldID.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
                fieldID.setText("");
            }
		});
		
		fieldPW = new JTextField("비밀번호를 입력하세요") {
			public void setBorder(Border border) {
			}
		};
		fieldPW.setBounds(70, 346, 240, 31);
		fieldPW.setOpaque(false);
		getContentPane().add(fieldPW);
		fieldPW.setColumns(10);
		fieldPW.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
                fieldPW.setText("");
            }
		});
		
		ImageIcon textImage = new ImageIcon("src\\imagePack\\Textbar.png");

		JLabel backID = new JLabel();
		backID.setBounds(63, 290, 254, 41);
		imageEdit.setPaintLabel(backID, textImage);
		getContentPane().add(backID);
		
		JLabel backPW = new JLabel();
		backPW.setBounds(63, 341, 254, 41);
		imageEdit.setPaintLabel(backPW, textImage);
		getContentPane().add(backPW);
		
		getContentPane().add(backG);
	}
	
	public ImageIcon imageSetsize(ImageIcon icon, int x, int y) {
		Image a = icon.getImage();  // ImageIcon Imgae변환 (이미지 아이콘 품질 깨지지 않고 변환하기 위해)
		Image b = a.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // (image함수 getScaledInstance로 품질 유지한 채 사이즈 변경)
		ImageIcon c = new ImageIcon(b);
		return c;
	}
}
