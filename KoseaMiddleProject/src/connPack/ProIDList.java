package connPack;

public class ProIDList {
	
	private String pro_id;
	private String pro_name;
	private String comp;
	
	public String getCode() {
		return pro_id;
	}
	
	public String getName() {
		return pro_name;
	}
	
	public String getCom() {
		return comp;
	}
	
	public ProIDList (String code, String name, String brand) {
		
		pro_id = code;
		pro_name = name;
		comp = brand;
		
		
	}

}
