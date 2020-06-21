package connPack;

import java.util.ArrayList;

public class MainAccountQ {
	
	AccountDB ad = new AccountDB();
	String id = ad.getUid();
	
	static boolean flg;
	
	public boolean getFlg() {
		return flg;
	}
	
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	
	public void changePW (String pw, String hint, String hintA) {
		
		ConnDB c = new ConnDB();
		
		try {
			String query = "UPDATE ACCOUNTD SET user_pw = '" + pw + "', hint = '" + hint + "', hint_answer = '" + hintA + "' WHERE user_id = '" + id + "'";
			
			c.getST().executeUpdate(query);
			c.getCon().commit();
			flg = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			flg = false;
		}
		
	}
	
	public void changeCode(String code) {
		
		ConnDB c= new ConnDB();
		
		try {
			String query = "UPDATE ACCOUNTD SET owner_code = '" + code + "' WHERE user_id = '" + id + "'";
			
			c.getST().executeUpdate(query);
			c.getCon().commit();
			flg = true;
			
		} catch(Exception e) {
			e.printStackTrace();
			flg = false;
		}
		
	}
	
	public void changeAdress (String phone, String mail) {
		
		ConnDB c = new ConnDB();
		
		try {
			String query = "UPDATE ACCOUNTD SET phone = '" + phone + "', e_mail = '" + mail + "' WHERE user_id = '" + id + "'";
			
			c.getST().executeUpdate(query);
			c.getCon().commit();
			flg = true;
			
		} catch(Exception e) {
			e.printStackTrace();
			flg = false;
		}
	}
	
	public void deleteAcc() {
		
		ConnDB c = new ConnDB();
		
		try {
			String query = "DELETE FROM ACCOUNTD WHERE user_id = '" + id + "'";
			
			c.getST().execute(query);
			c.getCon().commit();
			flg = true;
			c.getCon().close();
			
		} catch (Exception e) {
			e.printStackTrace();
			flg = false;
		}
	}
	
	public ArrayList<RankIDList> rankIDSearch(String shopID, String name) {
		
		ConnDB c = new ConnDB();
		ArrayList<RankIDList> list = new ArrayList<RankIDList>();
		
		try {
			String query = "SELECT user_id, user_type, TO_CHAR(create_date, 'YYYY/MM/DD') \"create_date\"  FROM ACCOUNTD WHERE shop_id = '" + shopID + "' AND user_name = '" + name + "' AND user_type != '¡°¿Â'";
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			if(c.getRS().getRow() == 0) {
				
				flg =false;
				
			} else {
				c.getRS().beforeFirst();
				while(c.getRS().next()) {
					
					String rankID = c.getRS().getString("user_id");
					String rankType = c.getRS().getString("user_type");
					String rankDate = c.getRS().getString("create_date");
					
					RankIDList data = new RankIDList(rankID, rankType, rankDate);
					
					list.add(data);
				}
				
				flg = true;
				
				c.getCon().close();
				c.getRS().close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			flg = false;
		}
		
		return list;
		
	}
	
	public void rankChange(String rankID, String type) {
		
		ConnDB c = new ConnDB();
		
		try {
			String query = "UPDATE ACCOUNTD SET user_type = '" + type + "' WHERE user_id = '" + rankID + "'";
			
			c.getST().executeUpdate(query);
			c.getCon().commit();
			flg = true;
			
		} catch (Exception e) {
			flg = false;
			e.printStackTrace();
		}
	}

}
