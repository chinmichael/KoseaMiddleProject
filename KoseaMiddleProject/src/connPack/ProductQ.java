package connPack;

import java.util.ArrayList;

public class ProductQ {
	
	static boolean flg;
	
	public boolean getFlg() {
		return flg;
	}
	
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	
	public ArrayList<ProductSearchDB> productList(String code, String name, String brand, String type1, String type2, int check) {
		
		ConnDB c = new ConnDB();
		ArrayList<ProductSearchDB> list = new ArrayList<ProductSearchDB>();
		
		try {
			
			String query;
			
			if(check == 0) { // 대분류, 소분류 모두 기본값
				query = "SELECT pro_id, pro_name, pro_price, comp, type_name1, type_name2, type_exp"
						+ " FROM PRODUCT p, CATEGORY c"
						+ " WHERE p.pro_type = c.pro_type"
						+ " AND pro_id LIKE '%" + code + "%' AND pro_name LIKE '%" + name + "%' AND comp LIKE '%" + brand + "%'";
				
				
			} else if (check == 1) { //대분류만 세팅
				query = "SELECT pro_id, pro_name, pro_price, comp, type_name1, type_name2, type_exp"
						+ " FROM PRODUCT p, CATEGORY c"
						+ " WHERE p.pro_type = c.pro_type"
						+ " AND pro_id LIKE '%" + code + "%' AND pro_name LIKE '%" + name + "%' AND comp LIKE '%" + brand + "%'"
						+ " AND type_name1 = '" + type1 + "'";
				
				
				
			} else {
				query = "SELECT pro_id, pro_name, pro_price, comp, type_name1, type_name2, type_exp"
						+ " FROM PRODUCT p, CATEGORY c"
						+ " WHERE p.pro_type = c.pro_type"
						+ " AND pro_id LIKE '%" + code + "%' AND pro_name LIKE '%" + name + "%' AND comp LIKE '%" + brand + "%'"
						+ " AND type_name1 = '" + type1 + "'AND type_name2 = '" + type2 + "'";
				
			}
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			if(c.getRS().getRow() == 0) {
				flg = false;
				
			} else {
				c.getRS().beforeFirst();
				while (c.getRS().next()) {
					String codeP = c.getRS().getString("pro_id");
					String nameP = c.getRS().getString("pro_name");
					int priceP = c.getRS().getInt("pro_price");
					String compP = c.getRS().getString("comp");
					String typeP1 = c.getRS().getString("type_name1");
					String typeP2 = c.getRS().getString("type_name2");
					String typeExp = c.getRS().getString("type_exp");
					
					ProductSearchDB data = new ProductSearchDB(codeP, nameP, priceP, compP, typeP1, typeP2, typeExp);
					
					list.add(data);
				}
				
				flg = true;
				
				c.getCon().close();
				c.getRS().close();
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public boolean proIDcheck (String code) {
		
		boolean flg;
		ConnDB c = new ConnDB();
		
		try {
			String query = "SELECT pro_id FROM product WHERE pro_id = '" + code + "'";
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			if(c.getRS().getRow() == 0) {
				flg = true;
			} else {
				flg = false;
			}
			
			c.getCon().close();
			c.getRS().close();
			
		} catch (Exception e) {
			e.printStackTrace();
			flg = false;
		}
		
		return flg;
	}
	
	public void inputProduct (String code, String name, String comp, String price, String typeB, String typeS, String exp) {
		
		ConnDB c = new ConnDB();
		int pri = Integer.parseInt(price);
		
		try {
			String query1 = "SELECT pro_type FROM category WHERE type_name1 = '" + typeB + "' AND type_name2 = '" + typeS + "'";
			c.setRS(c.getST().executeQuery(query1));
			c.getRS().last();
			
			String proType = c.getRS().getString("pro_type");
			
			String query2 = "INSERT INTO product VALUES ('" + code + "', '" + name + "', " + pri + ", '" + proType + "', '" + comp + "', '" + exp + "')";
			c.getST().execute(query2);
			
			flg = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			flg = false;
		}
		
	}
}
