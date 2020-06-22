package connPack;

public class DisDB {
	
	private int serial_num;
	private String pro_name;
	private int stock_num;
	private String exp_date;
	
	private String comp;
	private String location;
	private String typeB;
	private String typeS;
	private String typeE;
	
	
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
	
	public String getCom() {
		return comp;
	}
	public String getLoc() {
		return location;
	}
	public String getTypeB() {
		return typeB;
	}
	public String getTypeS() {
		return typeS;
	}
	public String getTypeE() {
		return typeE;
	}
	
	
	
	public DisDB(int serial, String name, int num, String date) {
		serial_num = serial;
		pro_name = name;
		stock_num = num;
		exp_date = date;
	}
	
	public DisDB(int serial, String name, int num, String date, String loc, String comp, String typeB, String typeS, String typeE) {
		serial_num = serial;
		pro_name = name;
		stock_num = num;
		exp_date = date;
		
		location = loc;
		this.comp = comp;
		this.typeB = typeB;
		this.typeS = typeS;
		this.typeE = typeE;
	}
	
}
