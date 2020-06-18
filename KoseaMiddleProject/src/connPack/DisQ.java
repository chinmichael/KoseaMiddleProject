package connPack;

import java.util.ArrayList;

public class DisQ {
	
	ConnDB c = new ConnDB();
	
	public ArrayList<DisDBShort> disSearchMonth(String shopID) {
		
		ArrayList<DisDBShort> list = new ArrayList<DisDBShort>();
		
		try {
			String query = "SELECT serial_num, pro_name, stock_num, TO_CHAR(exp_date, 'YYYY/MM/DD') \"exp_date\" FROM STOCK s, PRODUCT p"
					+ " WHERE TO_CHAR(exp_date, 'YYYY/MM') = TO_CHAR(SYSDATE, 'YYYY/MM')" + " AND shop_id = '" + shopID
					+ "' AND s.pro_id = p.pro_id";

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			c.getRS().first();
			while (c.getRS().next()) {
				int serial = c.getRS().getInt("serial_num");
				String name = c.getRS().getString("pro_name");
				int stock = c.getRS().getInt("stock_num");
				String date = c.getRS().getString("exp_date");
				

				DisDBShort data = new DisDBShort(serial, name, stock, date);
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
