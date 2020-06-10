package toolPack;

import java.awt.Dimension;
import java.awt.Toolkit;

public class SizeTool {
	
	public int setCenterX(int xLength) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		
		int setPointX = screen.width / 2 - xLength / 2;
		
		return setPointX;
		
	}
	
	public int setCenterY(int yLength) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		
		int setPointX = screen.height / 2 - yLength / 2;
		
		return setPointX;
		
	}
	
}
