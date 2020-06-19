package connPack;

public class DisMCUpdate {
	
	ConnDB c = new ConnDB();
	
	public void updateMonth(String shopID) {
		
		try {
		
		String query = "UPDATE stock SET disuse_count = 0 WHERE shop_id = '" + shopID + "' AND disuse_count != 0 AND count_month != TO_CHAR(SYSDATE, 'YYYY/MM')";
		
		c.getST().executeUpdate(query);
		c.getCon().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
