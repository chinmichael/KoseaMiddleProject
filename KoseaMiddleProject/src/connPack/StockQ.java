package connPack;

import java.util.ArrayList;

public class StockQ {
	
	static boolean flg;
	
	public boolean getFlg() {
		return flg;
	}
	
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	
	public void stockChange(int serial, String location, int stock, String date) {

		ConnDB c = new ConnDB();

		String ser = Integer.toString(serial);
		String dat = date.replace("/", "");
		String sto = Integer.toString(stock);

		try {
			String query = "UPDATE stock SET stock_num = " + sto + ", location = '" + location
					+ "', exp_date = TO_DATE(" + dat + ", 'YYYY/MM/DD') WHERE serial_num = " + ser;

			c.getST().executeUpdate(query);
			c.getCon().commit();
			flg = true;

		} catch (Exception e) {
			flg = false;
			e.printStackTrace();
		}
	}

	public int checkStock(String code) {

		int check; // 0 = 상품리스트에 없음, 1 = 중복되는 재고, 2 = 등록가능한 상품
		boolean flg;

		ConnDB c = new ConnDB();

		try {
			String query = "SELECT pro_id FROM stock WHERE pro_id = '" + code + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (c.getRS().getRow() == 0) {
				String query2 = "SELECT pro_id FROM product WHERE pro_id = '" + code + "'";
				c.setRS(c.getST().executeQuery(query2));
				c.getRS().last();

				if (c.getRS().getRow() == 0) {
					check = 0;

				} else {
					check = 2;
				}

			} else {
				check = 1;
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
			check = 0;
		}

		return check;
	}
	
	public ArrayList<SearchStockDB> list(String shopID, String code, String name, String brand, String type,
			String type2, int check) {

		ConnDB c = new ConnDB();
		ArrayList<SearchStockDB> list = new ArrayList<SearchStockDB>();

		try {

			String query;

			if (check == 0) { // 대분류 소분류 둘다 세팅 x
				query = "SELECT serial_num, s.pro_id, pro_name, pro_price, location, comp, stock_num, TO_CHAR(exp_date, 'YYYY/MM/DD') \"exp_date\", type_name1, type_name2, type_exp"
						+ " FROM STOCK s , PRODUCT p , CATEGORY c"
						+ " WHERE s.pro_id = p.pro_id AND p.pro_type = c.pro_type" + " AND shop_id = '" + shopID
						+ "' AND s.pro_id LIKE '%" + code + "%' AND pro_name LIKE '%" + name + "%'"
						+ " AND comp LIKE '%" + brand + "%'";

			} else if (check == 1) { // 대분류만 세팅
				query = "SELECT serial_num, s.pro_id, pro_name, pro_price, location, comp, stock_num, TO_CHAR(exp_date, 'YYYY/MM/DD') \"exp_date\", type_name1, type_name2, type_exp"
						+ " FROM STOCK s , PRODUCT p , CATEGORY c"
						+ " WHERE s.pro_id = p.pro_id AND p.pro_type = c.pro_type" + " AND shop_id = '" + shopID
						+ "' AND s.pro_id LIKE '%" + code + "%' AND pro_name LIKE '%" + name + "%'"
						+ " AND comp LIKE '%" + brand + "%' AND type_name1 = '" + type + "'";

			} else {
				query = "SELECT serial_num, s.pro_id, pro_name, pro_price, location, comp, stock_num, TO_CHAR(exp_date, 'YYYY/MM/DD') \"exp_date\", type_name1, type_name2, type_exp"
						+ " FROM STOCK s , PRODUCT p , CATEGORY c"
						+ " WHERE s.pro_id = p.pro_id AND p.pro_type = c.pro_type" + " AND shop_id = '" + shopID
						+ "' AND s.pro_id LIKE '%" + code + "%' AND pro_name LIKE '%" + name + "%'"
						+ " AND comp LIKE '%" + brand + "%' AND type_name1 = '" + type + "' AND type_name2 = '" + type2
						+ "'";

			}

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (c.getRS().getRow() == 0) {
				flg = false;

			} else {
				c.getRS().beforeFirst();
				while (c.getRS().next()) {
					int serial = c.getRS().getInt("serial_num");
					String code2 = c.getRS().getString("pro_id");
					String name2 = c.getRS().getString("pro_name");
					int price = c.getRS().getInt("pro_price");
					String location = c.getRS().getString("location");
					String company = c.getRS().getString("comp");
					int stock = c.getRS().getInt("stock_num");
					String exp = c.getRS().getString("exp_date");
					String type_1 = c.getRS().getString("type_name1");
					String type_2 = c.getRS().getString("type_name2");
					String type_3 = c.getRS().getString("type_exp");

					SearchStockDB data = new SearchStockDB(serial, code2, name2, price, location, company, stock, exp,
							type_1, type_2, type_3);
					list.add(data);

				}

				flg = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public void insertStock(String code, String exp, String loc, int stock, String shopID) {

		ConnDB c = new ConnDB();

		String sto = Integer.toString(stock);
		String date = exp.replace("/", "");

		try {
			String query1 = "SELECT serial_num FROM (SELECT serial_num FROM stock ORDER BY serial_num DESC) WHERE ROWNUM = 1";

			c.setRS(c.getST().executeQuery(query1));
			c.getRS().last();

			int serial = c.getRS().getInt("serial_num") + 1;

			String query2 = "INSERT INTO STOCK VALUES (" + serial + ", '" + shopID + "', '" + code + "', '" + loc
					+ "', " + sto + ", TO_DATE(" + date + ", 'YYYY/MM/DD'), 0, TO_CHAR(SYSDATE, 'YYYY/MM'))";

			c.setRS(c.getST().executeQuery(query2));

			flg = true;

		} catch (Exception e) {
			e.printStackTrace();
			flg = false;
		}
	}
	
	public ArrayList<ProIDList> codeList (String name) {
		
		ArrayList<ProIDList> list = new ArrayList<ProIDList>();
		ConnDB c = new ConnDB();
		
		try {
			String query = "SELECT pro_id, pro_name, comp FROM product WHERE pro_name LIKE '%" + name + "%' AND pro_id NOT IN (SELECT pro_id FROM stock)";
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			if(c.getRS().getRow() == 0) {
				flg = false;
				
			} else {
				c.getRS().beforeFirst();
				while(c.getRS().next()) {
					
					String code = c.getRS().getString("pro_id");
					String nameP = c.getRS().getString("pro_name");
					String comp = c.getRS().getString("comp");
					
					ProIDList data = new ProIDList(code, nameP, comp);
					
					list.add(data);
				}
				
				flg = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
