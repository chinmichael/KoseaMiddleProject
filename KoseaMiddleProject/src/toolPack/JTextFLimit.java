package toolPack;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFLimit extends PlainDocument {
	
	private int limit;
	
	public JTextFLimit(int limit) {
		super(); // super�� �ٽ� �����ؾ߱ߴ�
		this.limit = limit;
		
	}
	
	public void insertString (int offset, String str, AttributeSet attr) throws BadLocationException {
		if(str == null) {
			return;
		}
		
		if(getLength() + str.length() <= limit) {
			super.insertString(offset, str, attr);
		}
	}

}
