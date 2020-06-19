package connPack;

import java.util.ArrayList;

public class ExistCheck {

	ConnDB c = new ConnDB();

	public boolean idcheck(String inputID) {

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

		String hint = "검색결과가 없습니다";

		try {
			String query = "SELECT hint FROM ACCOUNTD WHERE user_id = '" + inputID + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (!(c.getRS().getRow() == 0)) {
				c.getRS().beforeFirst();
				while (c.getRS().next()) {
					hint = c.getRS().getString("hint");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hint;
	}

	public String pwSearch(String inputID, String inputHintA) {

		String result = "검색결과가 없습니다";

		try {
			String query = "SELECT user_pw FROM ACCOUNTD WHERE user_id = '" + inputID + "' AND hint_answer = '"
					+ inputHintA + "'";
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			if (!(c.getRS().getRow() == 0)) {
				c.getRS().first();
				
				String resultPW = "";
				while (c.getRS().next()) {
					resultPW = c.getRS().getString("user_pw");
				}
				
				result = "패스워드는 '" + resultPW + "' 입니다";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


}
