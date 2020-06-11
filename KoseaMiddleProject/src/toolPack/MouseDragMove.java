package toolPack;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MouseDragMove implements MouseMotionListener {

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
}
