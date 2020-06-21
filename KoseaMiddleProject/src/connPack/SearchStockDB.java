package connPack;

public class SearchStockDB {
	
	private int serial;
	private String code;
	private String name;
	private int price;
	private String location;
	private String company;
	private int stock;
	private String exp;
	private String type1;
	private String type2;
	private String type3;
	
	public SearchStockDB (int serial, String code, String name, int price, String location, String company, int stock, String exp, String type1, String type2, String type3) {
		this.serial = serial;
		this.code = code;
		this.name = name;
		this.price = price;
		this.location = location;
		this.company = company;
		this.stock = stock;
		this.exp = exp;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		
	}
	
	public int getSerial() {
		return serial;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getLoc() {
		return location;
	}
	
	public String getCom() {
		return company;
	}
	
	public int getStock() {
		return stock;
	}
	
	public String getExp() {
		return exp;
	}
	
	public String getT1() {
		return type1;
	}
	
	public String getT2() {
		return type2;
	}
	
	public String getT3() {
		return type3;
	}
	
	
}
