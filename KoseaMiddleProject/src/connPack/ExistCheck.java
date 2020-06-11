package connPack;

public class ExistCheck {
	
	public boolean idcheck(String inputID) {
		
		boolean flg = false;
		
		try {
			ConnDB c = new ConnDB();
			
			String query = "SELECT user_id FROM USERK WHERE user_id = '" + inputID + "'";
			c.setRS(c.getST().executeQuery(query)); // 쿼리문 실행시키는 건가요
			c.getRS().last(); // 마지막 쿼리문 결과값을 갖고온다는건가
			
			if(c.getRS().getRow() == 0) {
				flg = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
	}

}
