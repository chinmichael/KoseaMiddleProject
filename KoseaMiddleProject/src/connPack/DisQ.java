package connPack;

import java.util.ArrayList;

public class DisQ {

	static boolean flg;

	public boolean getFlg() {
		return flg;
	}

	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	
	
	public ArrayList<DisDBShort> disSearchMonth(String shopID) {
		
		ConnDB c = new ConnDB();
		
		ArrayList<DisDBShort> list = new ArrayList<DisDBShort>();
		
		try {
			String query = "SELECT serial_num, pro_name, stock_num, TO_CHAR(exp_date, 'YYYY/MM/DD') \"exp_date\" FROM STOCK s, PRODUCT p"
					+ " WHERE TO_CHAR(exp_date, 'YYYY/MM') = TO_CHAR(SYSDATE, 'YYYY/MM')" + " AND shop_id = '" + shopID
					+ "' AND s.pro_id = p.pro_id";

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			c.getRS().beforeFirst();
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

	public ArrayList<DisDBShort> disSearchDay(String shopID) {
		
		ConnDB c = new ConnDB();
		ArrayList<DisDBShort> list = new ArrayList<DisDBShort>();

		try {
			String query = "SELECT serial_num, pro_name, stock_num, TO_CHAR(exp_date, 'YYYY/MM/DD') \"exp_date\" FROM STOCK s, PRODUCT p"
					+ " WHERE TO_CHAR(exp_date, 'YYYY/MM/DD') = TO_CHAR(SYSDATE, 'YYYY/MM/DD')" + " AND shop_id = '"
					+ shopID + "' AND s.pro_id = p.pro_id";

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			c.getRS().beforeFirst();
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
	
	public ArrayList<DisMCDB> showCNT(String shopID) {

		ConnDB c = new ConnDB();
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
	
	public void updateMonth(String shopID) {

		ConnDB c = new ConnDB();

		try {

			String query = "UPDATE stock SET disuse_count = 0 WHERE shop_id = '" + shopID
					+ "' AND disuse_count != 0 AND count_month != TO_CHAR(SYSDATE, 'YYYY/MM')";

			c.getST().executeUpdate(query);
			c.getCon().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void disChange(int serial, String date, int stock) {
		
		ConnDB c = new ConnDB();

		String dat = date.replace("/", "");
		String ser = Integer.toString(serial);
		String sto = Integer.toString(stock);

		try {
			String query = "UPDATE stock SET stock_num = " + sto + ", exp_date = TO_DATE(" + dat
					+ ", 'YYYY/MM/DD'), disuse_count = disuse_count + 1 WHERE serial_num = " + ser;

			c.getST().executeUpdate(query);
			c.getCon().commit();
			flg = true;
//			c.getCon().close();

		} catch (Exception e) {
			flg = false;
			e.printStackTrace();
		}

	}

}
