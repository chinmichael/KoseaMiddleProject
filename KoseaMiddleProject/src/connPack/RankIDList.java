package connPack;

public class RankIDList {
	
	String rank_id;
	String rank_type;
	String rank_date;
	
	public String getID() {
		return rank_id;
	}
	
	public String getType() {
		return rank_type;
	}
	
	public String getDate() {
		return rank_date;
	}
	
	public RankIDList (String id, String type, String date) {
		
		rank_id = id;
		rank_type = type;
		rank_date = date;
		
	}
	
}
