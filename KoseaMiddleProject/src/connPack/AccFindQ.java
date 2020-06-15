package connPack;

import java.util.ArrayList;

public class AccFindQ {
	
	ConnDB c = new ConnDB();

	public ArrayList<AccFindDB> idFind(String name, String phoneA, String shop) {

		ArrayList<AccFindDB> idFind = new ArrayList<AccFindDB>();

		try {
			String query = "SELECT user_id, create_date FROM ACCOUNTD WHERE user_name = '" + name + "' AND phone = '" + phoneA
					+ "' AND shop_id = '" + shop + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (c.getRS().getRow() == 0) {

			} else {
				c.getRS().previous();
				while (c.getRS().next()) {
					String user_id = c.getRS().getString("user_id");
					String create_date = c.getRS().getString("create_date");
					
					AccFindDB data = new AccFindDB(user_id, create_date);
					idFind.add(data);
				}
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idFind;
	}
}
