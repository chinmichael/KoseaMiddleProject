package mainPack;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import toolPack.*;
import loginPack.*;

public class MainHome extends JFrame {

	Container contentP = getContentPane();
	ImageInput imageEdit = new ImageInput();

	public static void main(String[] args) {

				try {
					MainHome frame = new MainHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public void openMainHome() {
		MainHome frame = new MainHome();
		frame.setVisible(true);
		System.out.println("Àú±â³Ä");
		LoginHome s = new LoginHome();
		s.dispose();
		
	}


	public MainHome() {
		setSize(460, 550); // 2800 3300 / 6
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		setLocation(screen.width/2 - 230, screen.height/2 - 320);
		setUndecorated(true);
		contentP.setLayout(null);
		addMouseMotionListener(new MouseMotionListener() {
			int xDrag, yDrag, xPress, yPress;
			@Override
			public void mouseDragged(MouseEvent e) {
				xDrag = e.getX();
				yDrag = e.getY();
				JFrame sframe = (JFrame) e.getSource();
				sframe.setLocation(sframe.getLocation().x + xDrag - xPress, sframe.getLocation().y + yDrag - yPress);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				xPress = e.getX();
				yPress = e.getY();
			}			
		});
		
		ImageIcon back = new ImageIcon("src\\mainImage\\MainBG1.jpg");
		JPanel backG = imageEdit.panelPaint(back);
		backG.setBounds(0, 0, 460, 550);
		
		JButton xMain = new JButton();
		xMain.setLocation(428, 10);
		xMain.setSize(20, 19);
		xMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		ImageIcon xNormal = new ImageIcon("src\\mainImage\\XMain1.jpg");
		ImageIcon xAction = new ImageIcon("src\\mainImage\\XMain2.jpg");
		imageEdit.setButtonImage(xMain, xNormal, xAction);
		contentP.add(xMain);
		
		contentP.add(backG);
	}
}
