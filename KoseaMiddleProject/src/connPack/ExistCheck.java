package connPack;

public class ExistCheck {
	
	public boolean idcheck(String inputID) {
		
		boolean flg = false;
		
		try {
			ConnDB c = new ConnDB();
			
			String query = "SELECT user_id FROM USERK WHERE user_id = '" + inputID + "'";
			c.setRS(c.getST().executeQuery(query)); // ������ �����Ű�� �ǰ���
			c.getRS().last(); // ������ ������ ������� ����´ٴ°ǰ�
			
			if(c.getRS().getRow() == 0) {
				flg = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
	}

}
