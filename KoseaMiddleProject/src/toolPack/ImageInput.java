package toolPack;

import java.awt.*;
import javax.swing.*;

public class ImageInput {
	
	public ImageIcon imageSetsize(ImageIcon icon, int x, int y) {
		Image a = icon.getImage();  // ImageIcon Imgae��ȯ (�̹��� ������ ǰ�� ������ �ʰ� ��ȯ�ϱ� ����)
		Image b = a.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // (image�Լ� getScaledInstance�� ǰ�� ������ ä ������ ����)
		ImageIcon c = new ImageIcon(b);
		return c;
	}
	
	public void setButtonImage(JButton b, ImageIcon bNormal, ImageIcon bAction) {
		
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		
		Dimension d = b.getSize();
		
		bNormal = imageSetsize(bNormal, d.width, d.height);
		bAction = imageSetsize(bAction, d.width, d.height);
		
		b.setIcon(bNormal);
		b.setPressedIcon(bAction);
		b.setRolloverIcon(bAction);

	}
	
	public void paintCo() {
		
	}
	
}
