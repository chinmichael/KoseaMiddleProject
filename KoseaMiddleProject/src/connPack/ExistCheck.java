package connPack;

import java.util.ArrayList;

public class ExistCheck {

	ConnDB c = new ConnDB();

	public boolean idcheck(String inputID) {

		boolean flg = false;

		try {
			String query = "SELECT user_id FROM ACCOUNTD WHERE user_id = '" + inputID + "'";
			c.setRS(c.getST().executeQuery(query)); // ������ �����Ű�� �ǰ���
			c.getRS().last(); // ������ ������ ������� ����´ٴ°ǰ�

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

		String hint = "�˻������ �����ϴ�";

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

		String result = "�˻������ �����ϴ�";

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
				
				result = "�н������ '" + resultPW + "' �Դϴ�";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


}
