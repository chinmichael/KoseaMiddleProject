package connPack;

public class DisDBShort {
	private String pro_name;
	private int stock_num;
	private String exp_date;
	
	public String getName() {
		return pro_name;
	}
	public int getStock() {
		return stock_num;
	}
	public String getDate() {
		return exp_date;
	}
	
	public DisDBShort(String name, int num, String date) {
		pro_name = name;
		stock_num = num;
		exp_date = date;
	}
	
}
