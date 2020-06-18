package connPack;

public class DisDBShort {
	
	private int serial_num;
	private String pro_name;
	private int stock_num;
	private String exp_date;
	
	public int getNum() {
		return serial_num;
	}
	public String getName() {
		return pro_name;
	}
	public int getStock() {
		return stock_num;
	}
	public String getDate() {
		return exp_date;
	}
	
	public DisDBShort(int serial, String name, int num, String date) {
		serial_num = serial;
		pro_name = name;
		stock_num = num;
		exp_date = date;
	}
	
}
