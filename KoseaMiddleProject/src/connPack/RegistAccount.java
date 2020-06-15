package connPack;

import popUpPack.RegistClear;

public class RegistAccount {
	
	static boolean flg = false;
	
	public boolean getFlg() {
		return flg;
	}
	
	public void registAccount (String name, String id, String pw, String mail, String phone, String hint,
			String hAnswer, String shop, String rank, String owner) {
		
		try {
			ConnDB c = new ConnDB();
			
			String query = "INSERT INTO ACCOUNTD VALUES ('" + name + "', '" + id + "', '" + pw + "', '" + mail + "', '" + phone + "', '" + hint
					+ "', '" + hAnswer + "', '" + shop + "', '" + rank + "', '" + owner + "', sysdate)";
			
			c.getST().executeQuery(query);
			RegistClear rc = new RegistClear();
			rc.printMsg();
			flg = rc.getFlg();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
