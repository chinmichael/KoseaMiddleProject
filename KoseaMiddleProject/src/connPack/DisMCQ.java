package connPack;

import java.util.ArrayList;

public class DisMCQ {
	
	ConnDB c = new ConnDB();
	
	public ArrayList<DisMCDB> showCNT(String shopID) {
		
		ArrayList<DisMCDB> list = new ArrayList<DisMCDB>();
		
		try {	
			String query = "SELECT serial_num, pro_name, type_exp, disuse_count FROM stock s, product p"
					+ " WHERE s.pro_id = p.pro_id AND count_month = TO_CHAR(SYSDATE, 'YYYY/MM') AND disuse_count != 0"
					+ " AND shop_id = '" + shopID + "' ORDER BY disuse_count DESC";

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			c.getRS().beforeFirst();
			
			while (c.getRS().next()) {
				int serial = c.getRS().getInt("serial_num");
				String name = c.getRS().getString("pro_name");
				String type = c.getRS().getString("type_exp");
				int cnt = c.getRS().getInt("disuse_count");
				

				DisMCDB data = new DisMCDB(serial, name, type, cnt);
				list.add(data);
			}
			
			c.getCon().close();
			c.getRS().close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
	}

}
