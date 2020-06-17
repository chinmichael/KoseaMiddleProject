package connPack;

import java.util.ArrayList;
import mainPack.*;
import popUpPack.*;

public class AccountQ {
	
	private static boolean flg;
	
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	
	public boolean getFlg() {
		return flg;
	}
	
	public ArrayList<AccountDB> list (String id, String pw) {
		ArrayList<AccountDB> list = new ArrayList<AccountDB>();
		CationMsg cm = new CationMsg();
		
		try {
			ConnDB c = new ConnDB();
			
			String query = "SELECT * FROM ACCOUNTD WHERE user_id = '" + id + "'"; // �ʿ��ϸ� toUpperCase()�� �빮��ȭ
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			String msg= "���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���";
			
			if(c.getRS().getRow() == 0) {
				cm.printMsg(msg);
			} else {
				String checkPW = c.getRS().getString("user_pw");
				
				if (checkPW.equals(pw)) {
					c.getRS().first(); // ����Ʈ ������� ��ȯ�ϰ� Ŀ�� ������ �̵�
					while (c.getRS().next()) {
						String user_name = c.getRS().getString("user_name");
						String e_mail = c.getRS().getString("e_mail");
						String phone = c.getRS().getString("phone");
						String hint = c.getRS().getString("hint");
						String hint_answer = c.getRS().getString("hint_answer");
						String shop_id = c.getRS().getString("shop_id");
						String user_type = c.getRS().getString("user_type");
						String owner_code = c.getRS().getString("owner_code");

						AccountDB data = new AccountDB(user_name, id, pw, e_mail, phone, hint, hint_answer,
								shop_id, user_type, owner_code);
						
						list.add(data);
					}
					
					flg = true;
					
					MainHome openMain = new MainHome();
					openMain.openMainHome();
					
				} else {
					cm.printMsg(msg);
				}
			}
			
			c.getCon().close();
			c.getRS().close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
