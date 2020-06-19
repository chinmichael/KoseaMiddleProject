package connPack;


public class TypeList {
	
	ConnDB c = new ConnDB();
	
	public String[] list () {
		
		String[] types;
		
		try {
			String query = "SELECT DISTINCT type_name1 FROM category";
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			int i = 1;
			types = new String[c.getRS().getRow() + 1];
			types[0] = "´ëºÐ·ù";
			
			c.getRS().beforeFirst();
			
			while(c.getRS().next()) {
				
				types[i] = c.getRS().getString("type_name1");
				
				i++;
			}
			
			c.getCon().close();
			c.getRS().close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			types = new String[0];
		}
		
		return types;
		
	}
	
}