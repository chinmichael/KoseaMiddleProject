package connPack;

public class DisUpdateQ {
	
	ConnDB c = new ConnDB();
	static boolean flg;
	
	public boolean getFlg() {
		return flg;
	}
	
	public void setFlg(boolean flg) {
		this.flg = flg;
	}

	public void disChange(int serial, String date, int stock) {

		String dat = date.replace("/", "");
		String ser = Integer.toString(serial);
		String sto = Integer.toString(stock);

		try {
			String query = "UPDATE stock SET stock_num = " + sto + ", exp_date = TO_DATE(" + dat
					+ ", 'YYYY/MM/DD') WHERE serial_num = " + ser;

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
