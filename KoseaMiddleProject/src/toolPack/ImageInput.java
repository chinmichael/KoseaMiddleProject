package toolPack;

import java.awt.*;
import javax.swing.*;

public class ImageInput {

	public ImageIcon imageSetsize(ImageIcon icon, int x, int y) {
		Image a = icon.getImage(); // ImageIcon Imgae변환 (이미지 아이콘 품질 깨지지 않고 변환하기 위해)
		Image b = a.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // (image함수 getScaledInstance로 품질 유지한 채 사이즈 변경)
		ImageIcon c = new ImageIcon(b);
		return c;
	}

	public void setButtonImage(JButton b, ImageIcon bNormal, ImageIcon bAction) {

		buttonOpaque(b);

		Dimension d = b.getSize();

		bNormal = imageSetsize(bNormal, d.width, d.height);
		bAction = imageSetsize(bAction, d.width, d.height);

		b.setIcon(bNormal);
		b.setPressedIcon(bAction);
		b.setRolloverIcon(bAction);

	}
	
	public void buttonOpaque(JButton b) {
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
	}
	
	public void setPaintLabel(JLabel l, ImageIcon back) {
		Dimension d = l.getSize();
		back = imageSetsize(back, d.width, d.height);
		l.setIcon(back);
	}

	public JPanel panelPaint(ImageIcon back) {

		JPanel p = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(back.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		return p;
	}

	public JTextArea textPaint(ImageIcon back) {
		JTextArea t = new JTextArea() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(back.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		return t;
	}

}
