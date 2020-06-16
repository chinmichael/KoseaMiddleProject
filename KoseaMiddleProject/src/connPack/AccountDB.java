package connPack;

public class AccountDB {
	private String user_name;
	private String user_id;
	private String user_pw;
	private String e_mail;
	private String phone;
	private String hint;
	private String hint_answer;
	private String shop_id;
	private static String user_type;
	private String owner_code;
	
	public AccountDB() {
	}
	
	public AccountDB(String user_name, String user_id, String user_pw, String e_mail, String phone, String hint, String hint_answer,
			String shop_id, String user_type, String owner_code) {
		
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.e_mail = e_mail;
		this.phone = phone;
		this.hint = hint;
		this.hint_answer = hint_answer;
		this.shop_id = shop_id;
		this.user_type = user_type;
		this.owner_code = owner_code;
	}
	
	public String getUname() {
		return user_name;
	}
	
	public String getUid() {
		return user_id;
	}
	
	public String getUpw() {
		return user_pw;
	}
	
	public String getUmail() {
		return e_mail;
	}
	
	public String getUphone() {
		return phone;
	}
	
	public String getUhint() {
		return hint;
	}
	
	public String getUanswer() {
		return hint_answer;
	}
	
	public String getUshop() {
		return shop_id;
	}
	
	public String getUtype() {
		return user_type;
	}
	
	public String getUowner() {
		return owner_code;
	}
}
