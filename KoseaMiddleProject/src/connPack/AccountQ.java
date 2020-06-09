package connPack;

import java.util.ArrayList;

import java.sql.*;
import loginPack.*;
import mainPack.*;
import warningPack.*;

public class AccountQ {
	
	public ArrayList<AccountDB> list (String id, String pw) {
		ArrayList<AccountDB> list = new ArrayList<AccountDB>();
		
		try {
			ConnDB c = new ConnDB();
			
			String query = "SELECT * FROM USERK WHERE user_id = '" + id + "'"; // 필요하면 toUpperCase()로 대문자화
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			if(c.getRS().getRow() == 0) {
				AccountInput wMsg = new AccountInput();
				wMsg.printMsg();
			} else {
				String checkPW = c.getRS().getString("user_pw");
				
				if (checkPW.equals(pw)) {
					c.getRS().previous(); // 리스트 이전요소 반환하고 커서 역방향 이동
					while (c.getRS().next()) {
						String user_name = c.getRS().getString("user_name");
						String e_mail = c.getRS().getString("e_mail");
						String phone = c.getRS().getString("phone");
						String hint = c.getRS().getString("hint");
						String hint_answer = c.getRS().getString("hint_answer");
						String shop_id = c.getRS().getString("shop_id");
						String user_type = c.getRS().getString("user_type");
						String owner_code = c.getRS().getString("owner_code");
						
						boolean flg = true;

						AccountDB data = new AccountDB(user_name, id, pw, e_mail, phone, hint, hint_answer,
								shop_id, user_type, owner_code, flg);
						
						list.add(data);
						
						MainHome openMain = new MainHome();
						openMain.openMainHome();
					}
					
				} else {
					AccountInput wMsg = new AccountInput();
					wMsg.printMsg();
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
