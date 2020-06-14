package toolPack;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboPopup;

public class ImageInput {

	public ImageIcon imageSetsize(ImageIcon icon, int x, int y) {
		Image a = icon.getImage(); // ImageIcon Imgae��ȯ (�̹��� ������ ǰ�� ������ �ʰ� ��ȯ�ϱ� ����)
		Image b = a.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // (image�Լ� getScaledInstance�� ǰ�� ������ ä ������ ����)
		ImageIcon c = new ImageIcon(b);
		return c;
	}
	
	public void setOneImage(JButton b, ImageIcon im) {

		buttonOpaque(b);

		Dimension d = b.getSize();

		im = imageSetsize(im, d.width, d.height);

		b.setIcon(im);
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
	
	public static void setSelectionColorOfComboBox(JComboBox<String> comboBox) 
	{ 
	 Object child = comboBox.getAccessibleContext().getAccessibleChild(0); 
	 BasicComboPopup popup = (BasicComboPopup) child; 
	 JList list = popup.getList(); 
	 list.setBorder(new LineBorder(new Color(254, 230, 160))); 
	 list.setSelectionBackground(new Color(254, 230, 160)); 
	 list.setSelectionForeground(new Color(254, 230, 160)); 
	 list.setFocusable(false); 
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
	
	public JTextField textClean() {
		JTextField jt = new JTextField() {
			public void setBorder(Border border) {	
			}
		}; // �͸�Ŭ������ �ؽ�Ʈ �׵θ� ����
		jt.setOpaque(false);
		
		return jt;
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
