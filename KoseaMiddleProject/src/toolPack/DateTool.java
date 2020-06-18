//https://zorba91.tistory.com/229

package toolPack;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTool {
	
	public boolean vildationDate(String checkDate) {
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			dateFormat.setLenient(false);
			dateFormat.parse(checkDate);
			return true;
			
		} catch(ParseException e) {
			return false;
		}
		
	}

}
