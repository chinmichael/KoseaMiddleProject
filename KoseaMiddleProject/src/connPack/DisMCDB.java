package connPack;

public class DisMCDB {
	
	private int serial_num;
	private String pro_name;
	private String type_exp;
	private int disuse_count;
	
	public int getSerial() {
		return serial_num;
	}
	
	public String getPName() {
		return pro_name;
	}
	
	public String getEType() {
		return type_exp;
	}
	
	public int getDisCnt() {
		return disuse_count;
	}
	
	public DisMCDB (int serial, String name, String type, int cnt) {
		serial_num = serial;
		pro_name = name;
		type_exp = type;
		disuse_count = cnt;
	}

}
