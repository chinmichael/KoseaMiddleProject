package connPack;

public class ShopDB {
	private String shop_id;
	private String shop_name;
	private String shop_location;
	
	public ShopDB() {
		
	}
	
	public ShopDB(String shop_id, String shop_name, String shop_location) {
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.shop_location = shop_location;
	}
	
	public String getShopID() {
		return shop_id;
	}
	
	public String getShopName() {
		return shop_name;
	}
	
	public String getShopLoc() {
		return shop_location;
	}
}
