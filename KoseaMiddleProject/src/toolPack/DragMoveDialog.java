package toolPack;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;

public class DragMoveDialog implements MouseMotionListener {

	int xDrag, yDrag, xPress, yPress;

	@Override
	public void mouseDragged(MouseEvent e) {
			xDrag = e.getX();
			yDrag = e.getY();
			JDialog sDialog = (JDialog) e.getSource();
			sDialog.setLocation(sDialog.getLocation().x + xDrag - xPress, sDialog.getLocation().y + yDrag - yPress);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
			xPress = e.getX();
			yPress = e.getY();

	}

}
