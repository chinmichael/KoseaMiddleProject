package connPack;

public class RegistAccount {
	
	public void registAccount (String name, String id, String pw, String mail, String phone, String hint,
			String hAnswer, String shop, String rank, String owner) {
		
		try {
			ConnDB c = new ConnDB();
			
			String query = "INSERT INTO ACCOUNTD VALUES ('" + name + "', '" + id + "', '" + pw + "', '" + mail + "', '" + phone + "', '" + hint
					+ "', '" + hAnswer + "', '" + shop + "', '" + rank + "', '" + owner + "')";
			
			c.getST().executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
