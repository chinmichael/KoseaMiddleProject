package connPack;

public class AccFindDB {
	String user_id;
	String create_date;
	
	public String getFid() {
		return user_id;
	}
	
	public String getFDate() {
		return create_date;
	}
	
	public AccFindDB (String user_id, String create_date) {
		this.user_id = user_id;
		this.create_date = create_date;
	}
}
