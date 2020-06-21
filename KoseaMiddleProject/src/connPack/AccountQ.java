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

	public ArrayList<AccountDB> list(String id, String pw) {

		ConnDB c = new ConnDB();
		ArrayList<AccountDB> list = new ArrayList<AccountDB>();
		CationMsg cm = new CationMsg();

		try {
			String query = "SELECT * FROM ACCOUNTD WHERE user_id = '" + id + "'"; // 필요하면 toUpperCase()로 대문자화

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			String msg = "아이디 혹은 비밀번호을 확인해주세요";

			if (c.getRS().getRow() == 0) {
				cm.printMsg(msg);
			} else {
				String checkPW = c.getRS().getString("user_pw");

				if (checkPW.equals(pw)) {
					c.getRS().beforeFirst();
					while (c.getRS().next()) {
						String user_name = c.getRS().getString("user_name");
						String e_mail = c.getRS().getString("e_mail");
						String phone = c.getRS().getString("phone");
						String hint = c.getRS().getString("hint");
						String hint_answer = c.getRS().getString("hint_answer");
						String shop_id = c.getRS().getString("shop_id");
						String user_type = c.getRS().getString("user_type");
						String owner_code = c.getRS().getString("owner_code");

						AccountDB data = new AccountDB(user_name, id, pw, e_mail, phone, hint, hint_answer, shop_id,
								user_type, owner_code);

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

	public ArrayList<AccFindDB> idFind(String name, String phoneA, String shop) {

		ConnDB c = new ConnDB();

		ArrayList<AccFindDB> idFind = new ArrayList<AccFindDB>();

		try {
			String query = "SELECT user_id, TO_CHAR(create_date, 'YYYY/MM/DD') \"create_date\" FROM ACCOUNTD WHERE user_name = '"
					+ name + "' AND phone = '" + phoneA + "' AND shop_id = '" + shop + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (c.getRS().getRow() == 0) {
				flg = false;

			} else {

				c.getRS().beforeFirst();

				while (c.getRS().next()) {
					String user_id = c.getRS().getString("user_id");
					String create_date = c.getRS().getString("create_date");

					AccFindDB data = new AccFindDB(user_id, create_date);
					idFind.add(data);
				}
				
				flg = true;
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idFind;
	}

	public void registAccount(String name, String id, String pw, String mail, String phone, String hint, String hAnswer,
			String shop, String rank, String owner) {

		ConnDB c = new ConnDB();

		try {

			String query = "INSERT INTO ACCOUNTD VALUES ('" + name + "', '" + id + "', '" + pw + "', '" + mail + "', '"
					+ phone + "', '" + hint + "', '" + hAnswer + "', '" + shop + "', '" + rank + "', '" + owner
					+ "', sysdate)";

			c.getST().executeQuery(query);
			RegistClear rc = new RegistClear();
			rc.printMsg();
			flg = rc.getFlg();
			rc.setFlg(false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean idcheck(String inputID) {

		ConnDB c = new ConnDB();
		boolean flg = false;

		try {
			String query = "SELECT user_id FROM ACCOUNTD WHERE user_id = '" + inputID + "'";
			c.setRS(c.getST().executeQuery(query)); // 쿼리문 실행시키는 건가요
			c.getRS().last(); // 마지막 쿼리문 결과값을 갖고온다는건가

			if (c.getRS().getRow() == 0) {
				flg = true;
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flg;
	}

	public String hintCheck(String inputID) {

		ConnDB c = new ConnDB();
		String hint = "검색결과가 없습니다";

		try {
			String query = "SELECT hint FROM ACCOUNTD WHERE user_id = '" + inputID + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (!(c.getRS().getRow() == 0)) {
				c.getRS().previous();
				while (c.getRS().next()) {
					hint = c.getRS().getString("hint");
				}
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hint;
	}

	public String pwSearch(String inputID, String inputHintA) {

		ConnDB c = new ConnDB();
		String result = "검색결과가 없습니다";

		try {
			String query = "SELECT user_pw FROM ACCOUNTD WHERE user_id = '" + inputID + "' AND hint_answer = '"
					+ inputHintA + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (!(c.getRS().getRow() == 0)) {
				c.getRS().previous();

				String resultPW = "";
				while (c.getRS().next()) {
					resultPW = c.getRS().getString("user_pw");
				}

				result = "패스워드는 '" + resultPW + "' 입니다";
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
