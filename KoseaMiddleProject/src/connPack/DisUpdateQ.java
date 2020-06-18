package connPack;

public class DisUpdateQ {
	
	ConnDB c = new ConnDB();

	public void disChange(int serial, String date, int stock) {

		String dat = date.replace("/", "");
		String ser = Integer.toString(serial);
		String sto = Integer.toString(stock);

		try {
			String query = "UPDATE stock SET stock_num = " + sto + ", exp_date = TO_DATE(" + dat
					+ ", 'YYYY/MM/DD') WHERE serial_num = " + ser;

			c.getST().executeUpdate(query);
			c.getCon().commit();
//			c.getCon().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
