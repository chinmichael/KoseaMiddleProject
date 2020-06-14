//https://dantes.kr/126 ����

package toolPack;

import javax.swing.text.*;

public class IntegerDocument extends PlainDocument {
	
	int currentValue = 0;
	private int limit;
	
	public IntegerDocument(int limit) {
		super(); // super�� �ٽ� �����ؾ߱ߴ�
		this.limit = limit;
	}
	
	public int getValue() {
		return currentValue;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

		if (str == null) {
			return;

		} else {
			String newValue;
			int length = getLength();

			if (length == 0) {
				newValue = str;

			} else {
				String currentContent = getText(0, length);
				StringBuffer currentBuffer = new StringBuffer(currentContent);
				currentBuffer.insert(offset, str);
				newValue = currentBuffer.toString();
			}

			if (getLength() + str.length() <= limit) {
				currentValue = checkInput(newValue, offset);
				super.insertString(offset, str, attr);
			}
		}
	}
	
	public void remove(int offset, int length) throws BadLocationException {
		int currentLength = getLength();
		String currentContent = getText(0, currentLength);
		String before = currentContent.substring(0, offset);
		String after = currentContent.substring(length + offset, currentLength);
		String newValue = before + after;
		currentValue = checkInput(newValue, offset);
		super.remove(offset, length);
	}
	
	public int checkInput(String proposedValue, int offset) throws BadLocationException {
		if(proposedValue.length() > 0) {
			try {
				int newValue = Integer.parseInt(proposedValue);
				return newValue;
				
			} catch(NumberFormatException e) {
				throw new BadLocationException(proposedValue, offset);

			}
			
		} else {
			return 0;
		}
	}
}
