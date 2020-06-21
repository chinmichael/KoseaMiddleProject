package connPack;

public class ProductSearchDB {
	
	private String code;
	private String name;
	private int price;
	private String comp;
	private String type1;
	private String type2;
	private String typeExp;
	
	public ProductSearchDB(String code, String name, int price, String comp, String type1, String type2, String typeExp) {
		
		this.code = code;
		this.name = name;
		this.price = price;
		this.comp = comp;
		this.type1 = type1;
		this.type2 = type2;
		this.typeExp = typeExp;
		
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
	
	public String getCom() {
		return comp;
	}
	
	public String getTypeB() {
		return type1;
	}
	
	public String getTypeS() {
		return type2;
	}
	
	public String getTypeE() {
		return typeExp;
	}

}
