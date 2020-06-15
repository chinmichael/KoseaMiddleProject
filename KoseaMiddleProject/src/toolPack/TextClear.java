package toolPack;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TextClear {
	
	public JTextField textClean() {
		JTextField jt = new JTextField() {
			public void setBorder(Border border) {	
			}
		}; // 익명클래스로 텍스트 테두리 제거
		jt.setOpaque(false);
		
		return jt;
	}
	
	public JPasswordField passClean() {
		JPasswordField jp = new JPasswordField() {
			public void setBorder(Border border) {
				
			}
		};
		jp.setOpaque(false);
		
		return jp;
	}

}
